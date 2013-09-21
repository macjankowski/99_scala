package pl.macjankowski.scala.ninetynine

import scala.collection.mutable.ListBuffer
import scala.annotation.tailrec
import scala.collection.generic.CanBuildFrom
import scala.collection.SeqLike
import scala.collection.TraversableLike

/**
 * @author "Maciej Jankowski <mac.rarry@gmail.com>"
 *
 */
object ListReverse {

  def reverse[T](seq: Seq[T]): Seq[T] = {

    @tailrec
    def reverseInternal[T](tmpI: Seq[T], seqI: Seq[T]): Seq[T] = seqI match {
      case Nil => tmpI
      case x :: xs => reverseInternal(tmpI :+ x, xs)
    }
    reverseInternal(Nil, seq)
  }

  def reverseFold[T](seq: Seq[T]): Seq[T] =
    seq.foldLeft(List[T]()) {
      (acc: List[T], el: T) => el :: acc
    }

  def reverseBuffer[T](seq: Seq[T]): Seq[T] = {
    val ret = ListBuffer[T]()
    for (el <- seq) el +: ret
    ret.toSeq
  }

  /**
   * Always returns the correct type
   */
  def reverseAny[T, Coll](c: Coll)(implicit evidence: Coll <:< TraversableLike[T, Coll],
    bf: CanBuildFrom[Coll, T, Coll]): Coll = {

    val a = c.toSeq
    val ret = bf()
    ret.sizeHint(a.size)
    a.foldLeft(ret) { (acc, el: T) => acc += el }
    ret.result
  }
}