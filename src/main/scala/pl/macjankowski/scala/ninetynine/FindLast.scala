
package pl.macjankowski.scala.ninetynine

import scala.annotation.tailrec

object FindLast {

  @tailrec
  def last(list: List[Int]): Int = list match {
    case Nil => throw new java.util.NoSuchElementException("-1")
    case x :: Nil => x
    case x :: xs => last(xs)
  }

  @tailrec
  def lastG[T](list: List[T]): T = list match {
    case Nil => throw new java.util.NoSuchElementException("-1")
    case x :: Nil => x
    case x :: xs => lastG(xs)
  }

  @tailrec
  def lastT[T](t: Traversable[T]): T = t.toSeq match {
    case Seq() => throw new java.util.NoSuchElementException("-1")
    case Seq(x) => x
    case Seq(x, xs @ _*) => lastT(xs)
  }

}
