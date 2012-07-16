


import collection._
import parallel.TaskSupport
import parallel.withTaskSupport


/** Test changing task supports. */
object Test {
  
  def check(ts: TaskSupport) {
    val pa = Array[Int]((0 until 400): _*).par
    withTaskSupport(ts) {
      for (x <- pa) {
        assert(pa.tasksupport eq ts, "Task support incorrect: " + pa.tasksupport)
      }
      
      val pb = for (x <- pa; y <- pa) yield {
        assert(pa.tasksupport eq ts, "Nested loop incorrect: " + pa.tasksupport)
        (x, y)
      }
      
      val shortpa = Array[Int](1, 2, 3, 4).par
      for (x <- shortpa) {
        val nested = new parallel.ForkJoinTaskSupport
        withTaskSupport(nested) {
          for (y <- pa) {
            assert(pa.tasksupport eq nested, "Nested tasksupport incorrect: " + pa.tasksupport)
          }
        }
      }
    }
  }
  
  def main(args: Array[String]) {
    check(new parallel.ForkJoinTaskSupport)
    check(new parallel.ThreadPoolTaskSupport)
  }
  
}
