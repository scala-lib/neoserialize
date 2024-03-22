package com.qrai.neoserialize

/**
* Used to just use raw strings instead of serializing
*/
object Raw extends Serializer[String] {
	override def serialize(value: String): String = value
	override def deserialize(raw: String): String = raw
}