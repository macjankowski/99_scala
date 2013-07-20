
package pl.macjankowski.scala.ninetynine

object ListTools {

  def last(list: List[Int]): Int = list match {
    case Nil => throw new java.util.NoSuchElementException("-1")
    case x :: Nil => return x
    case x :: xs => last(xs)
  }
}
