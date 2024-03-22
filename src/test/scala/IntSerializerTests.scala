import com.qrai.neoserialize.IntSerializer

class IntSerializerTests extends munit.FunSuite {
  test("serialize an Int") {
    val raw = 12345
    val serialized = new IntSerializer().serialize(raw)

    assertEquals(serialized, "12345")
  }
  test("deserialize an Int") {
    val raw = "12345"
    val serialized = new IntSerializer().deserialize(raw)
    
    assertEquals(serialized, 12345)
  }
  test("serialize and deserialize an Int") {
    val raw = 12345
    val serialized = new IntSerializer().serialize(raw)
    val deserialized = new IntSerializer().deserialize(serialized)
    
    assertEquals(raw, deserialized)
  }
}
