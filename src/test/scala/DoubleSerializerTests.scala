import com.qrai.neoserialize.DoubleSerializer

class DoubleSerializerTests extends munit.FunSuite {
  test("serialize an Double") {
    val raw = 123.456
    val serialized = new DoubleSerializer().serialize(raw)

    assertEquals(serialized, "123.456")
  }
  test("deserialize an Double") {
    val raw = "123.456"
    val serialized = new DoubleSerializer().deserialize(raw)
    
    assertEquals(serialized, 123.456)
  }
  test("serialize and deserialize an Double") {
    val raw = 123.456
    val serialized = new DoubleSerializer().serialize(raw)
    val deserialized = new DoubleSerializer().deserialize(serialized)
    
    assertEquals(raw, deserialized)
  }
}
