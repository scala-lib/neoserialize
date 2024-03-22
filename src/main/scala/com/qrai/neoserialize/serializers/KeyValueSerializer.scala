package com.qrai.neoserialize

import scala.reflect.ClassTag
import scala.collection.immutable.{Map}

/**
* Used to serialize/deserialize list of key/value pair values
* @param rowDelimiter character that will split raw value into array of pairs
* @param delimiter character that will split raw value into key and value
* @param keySerializer serializer that will serialize keys
* @param valueSerializer serializer that will serialize values
*/
sealed class KeyValueSerializer[TPairKey, TPairValue:ClassTag]
	(rowDelimiter: String, delimiter: String, keySerializer: Serializer[TPairKey], valueSerializer: Serializer[TPairValue])
	extends Serializer[Map[TPairKey, TPairValue]] {

	override def serialize(value: Map[TPairKey, TPairValue]): String = {
		value
			.map((key, value) => s"${key}${delimiter}${value}")
			.mkString(rowDelimiter)
	}
	
	override def deserialize(raw: String): Map[TPairKey, TPairValue] = {
		raw
			.split(rowDelimiter)
			.map(deserializeRow(_))
			.toMap
	}

	private def deserializeRow(row: String): (TPairKey, TPairValue) = {
		val Array(key, value) = row.split(delimiter)

		// Deserialize key and value
		(keySerializer.deserialize(key), valueSerializer.deserialize(value))
	}
}
