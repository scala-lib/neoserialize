package com.qrai.neoserialize

/**
* Used to serialize/deserialize double/real/float values.
*/
sealed class DoubleSerializer extends Serializer[Double] {
	override def serialize(value: Double): String = value.toString()

	override def deserialize(raw: String): Double =
		raw.toDoubleOption.getOrElse(Double.NaN)
}