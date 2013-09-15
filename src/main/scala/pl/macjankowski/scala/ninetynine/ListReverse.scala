package pl.macjankowski.scala.ninetynine

import scala.collection.mutable.ListBuffer
import scala.annotation.tailrec

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
  
  def reverse[T, Coll](trav: Coll): Traversable[T, Coll] ={
    Nil
  }
}