import com.qrai.neoserialize.{SeqSerializer, IntSerializer}

class SeqSerializerTests extends munit.FunSuite {
  test("serialize an Seq[Int]") {
    val raw = Seq(123, 456, 789)
    val serialized = new SeqSerializer[Int](
		delimiter = ",",
		serializer = new IntSerializer()
	).serialize(raw)

    assertEquals(serialized, "123,456,789")
  }
  test("deserialize an Seq[Int]") {
    val raw = "123,456,789"
    val serialized = new SeqSerializer[Int](
		delimiter = ",",
		serializer = new IntSerializer()
	).deserialize(raw)
    
    assertEquals(serialized, Seq(123, 456, 789))
  }
  test("serialize and deserialize an Seq[Int]") {
    val raw = Seq(123, 456, 789)

    val serializer = new SeqSerializer[Int](
		delimiter = ",",
		serializer = new IntSerializer()
	)
	
    val serialized = serializer.serialize(raw)
    val deserialized = serializer.deserialize(serialized)
    
    assertEquals(raw, deserialized)
  }
}
