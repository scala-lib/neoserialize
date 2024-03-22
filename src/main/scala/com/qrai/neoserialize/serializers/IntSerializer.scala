package com.qrai.neoserialize

/**
* Used to serialize/deserialize integer values.
* @param delimiter character that delimits a number (example: 1.000 where `.` is delimiter), will be erased
*/
sealed class IntSerializer(val delimiter: String | Null = null) extends Serializer[Int] {
	override def serialize(value: Int): String = value.toString()

	override def deserialize(raw: String): Int =
		// With delimiter
		if (delimiter != null) raw.replace(delimiter, "").toInt
		// Without
		else raw.toInt
}