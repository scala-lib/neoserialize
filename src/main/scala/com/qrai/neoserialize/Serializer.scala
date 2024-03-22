package com.qrai.neoserialize

abstract class Serializer[T] {
	def serialize(value: T): String
	def deserialize(raw: String): T
}