/**
 *
 */
package pl.macjankowski.scala.ninetynine

import scala.annotation.tailrec

/**
 * @author "Maciej Jankowski <mac.rarry@gmail.com>"
 *
 */
object ListLength {

  def length[T](seq: Seq[T]): Int = {
    @tailrec
    def lengthInternal[T](currentLength: Int, col: Seq[T]): Int = col match {
      case Seq() => currentLength
      case Seq(x, xs @ _*) => lengthInternal(1 + currentLength, xs)
    }
    lengthInternal(0, seq)
  }

  def lengthT[T](traversable: Traversable[T]): Int = {

    var length = 0;
    traversable.foreach {
      e =>
        length += 1
    }
    length
  }
}