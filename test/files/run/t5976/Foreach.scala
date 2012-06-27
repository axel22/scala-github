


import scala.runtime.BoxedUnit



object japi {
  trait MyFunction[-T, +R] {
    def apply(t: T): R
  }
  
  @deprecated("Do not use this directly, use subclasses of this", "2.0")
  class UnitFunctionBridge[-T] extends MyFunction[T, BoxedUnit] {
    override final def apply(t: T): BoxedUnit = {
      internal(t)
      BoxedUnit.UNIT
    }
    protected def internal(result: T): Unit = ()
  }
}


abstract class Foreach[-T] extends japi.UnitFunctionBridge[T] {
  override final def internal(t: T): Unit = each(t)

  /**
   * This method will be invoked once when/if a Future that this callback is registered on
   * becomes successfully completed
   */
  @throws(classOf[Throwable])
  def each(result: T): Unit
}




