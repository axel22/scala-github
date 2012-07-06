


trait Foo[@specialized(AnyRef, Int) A, @specialized(Boolean) B] {
  def apply(x: A): B
}


abstract class Inter extends Foo[String, Boolean]


class Baz extends Inter {
  def apply(x: String) = false
}


object Test {
  
  def main(args: Array[String]) {
    val b = new Baz
    println(b.apply(""))
  }
  
}
