




trait Super[@specialized(Int) A] {
  def superb = 0
}


object Sub extends Super[Int] {
  super[Super].superb // scala.tools.nsc.symtab.Types$$TypeError: Super does not name a parent class of object Sub
  super.superb        // okay
  override def superb: Int = super.superb // okay
}


