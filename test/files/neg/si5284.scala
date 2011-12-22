





object Test {
  def main(args: Array[String]) {
    val a = Blarg(Array(1, 2, 3))
    println(a.foo((x: Int) => x + 1))
  }
}


object Blarg {
  def apply[T: Manifest](a: Array[T]) = new Blarg(a)
}


class Blarg[T: Manifest](val a: Array[T]) {
  def foo[@specialized(Int) W >: T, @specialized(Int) S](f: W => S) = f(a(0))
}









