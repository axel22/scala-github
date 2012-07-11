


import java.lang.reflect.Modifier
import annotation.static



/* A @static-annotated field in the companion object should yield
 * a static field in its companion class.
 */
object Foo {
  @static val bar = 17
}


class Foo {
}


object Test {
  
  def main(args: Array[String]) {
    classOf[Foo].getDeclaredFields.find(_.getName == "bar") match {
      case Some(f) => assert(Modifier.isStatic(f.getModifiers), "no static modifier")
      case None => assert(false, "no static field bar in class")
    }
    
    assert(Foo.bar == 17, "Companion object field should be 17.")
  }
  
}
