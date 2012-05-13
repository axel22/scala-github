


import collection._



object View extends testing.Benchmark {
  val length = sys.props("length").toInt
  val coll = mutable.ArrayBuffer[Int](0 until length: _*)
  
  def run = {
    coll.view.flatMap(x => List(x)).foreach {
      x =>
    }
  }
}


object Strict extends testing.Benchmark {
  val length = sys.props("length").toInt
  val coll = mutable.ArrayBuffer[Int](0 until length: _*)
  
  def run = {
    coll.flatMap(x => List(x)).foreach {
      x =>
    }
  }
}

