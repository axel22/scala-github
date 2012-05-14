


import collection.parallel.mutable.ParHashMap
import scala.concurrent.forkjoin._



object Map extends testing.Benchmark {
  val length = sys.props("length").toInt
  val par = sys.props("par").toInt
  val async = sys.props("async").toBoolean
  val phm = ParHashMap((0 until length) zip (0 until length): _*)
  
  phm.tasksupport = new collection.parallel.ForkJoinTaskSupport(new scala.concurrent.forkjoin.ForkJoinPool(par, ForkJoinPool.defaultForkJoinWorkerThreadFactory, null, async))
  
  def run = {
    phm map {
      kv => kv
    }
  }
}


object MapSeq extends testing.Benchmark {
  val length = sys.props("length").toInt
  val hm = collection.mutable.HashMap((0 until length) zip (0 until length): _*)
  
  def run = {
    hm map {
      kv => kv
    }
  }
}

