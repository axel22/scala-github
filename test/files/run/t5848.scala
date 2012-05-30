


import collection._
import generic._



object Test {
  
  implicit def decorator[K, V](m: mutable.Map[K, V]) = new {
    def revealingTransform[S, That](f: (K, V) => S)(implicit cbf: CanBuildFrom[mutable.Map[K, V], S, That]): That = {
      println(cbf.getClass)
      println(cbf(m).getClass)
      
      null.asInstanceOf[That]
    }
  }
  
  def main(args: Array[String]) {
    val intMap: mutable.Map[String, Int] = mutable.Map("one" -> 1)
    val stringMap: mutable.Map[String, String] = intMap.revealingTransform({
      case (s, i) => s -> i.toString
    })
  }
  
}
