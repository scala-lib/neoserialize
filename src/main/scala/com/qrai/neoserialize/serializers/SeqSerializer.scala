package com.qrai.neoserialize

import scala.reflect.ClassTag

/**
* Used to serialize/deserialize list of values delimited
* @param delimiter character that will split raw value into array of values
* @param serializer serializer that will serialize individual sequence values
*/
sealed class SeqSerializer[TSeqElement:ClassTag](delimiter: String, serializer: Serializer[TSeqElement]) extends Serializer[Seq[TSeqElement]] {
	override def serialize(value: Seq[TSeqElement]): String = 
		value.map(value => serializer.serialize(value))
			.mkString(delimiter)
	
	override def deserialize(raw: String): Seq[TSeqElement] =
		raw.split(delimiter)
			.map(value => serializer.deserialize(value))
			.toSeq
}
