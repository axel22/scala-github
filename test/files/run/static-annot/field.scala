


import java.lang.reflect.Modifier
import annotation.static
import reflect._



/* A @static-annotated field in the companion object should yield
 * a static field in its companion class.
 */
object Foo {
  @static val bar = 17
}


class Foo


class Foo2


/** The order of declaring the class and its companion is inverted now. */
object Foo2 {
  @static val bar = 199
}


/** The case where there is no explicit companion class */
object Foo3 {
  @static val bar = 1984
}


object Test {
  
  def checkStatic(cls: Class[_]) {
    cls.getDeclaredFields.find(_.getName == "bar") match {
      case Some(f) => assert(Modifier.isStatic(f.getModifiers), "no static modifier")
      case None => assert(false, "no static field bar in class")
    }
  }
  
  def main(args: Array[String]) {
    checkStatic(classOf[Foo])
    assert(Foo.bar == 17, "Companion object field should be 17.")
    
    checkStatic(classOf[Foo2])
    assert(Foo2.bar == 199, "Companion object field should be 199.")
    
    checkStatic(Class.forName("Foo3"))
    assert(Foo3.bar == 1984, "Companion object field should be 1984.")
  }
  
}
