import com.qrai.neoserialize.{KeyValueSerializer, IntSerializer, Raw}

@main def hello(): Unit =
  val nonserialized = "key:300,keytwo:600"

  println(new KeyValueSerializer[String, Int](
    rowDelimiter = ",",
    delimiter = ":",
    keySerializer = Raw,
    valueSerializer = new IntSerializer()
  ).deserialize(nonserialized))


  /* 
  neoserialize.seq(",", nonserialize.int("_"))
  */

  