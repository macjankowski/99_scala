package pl.macjankowski.scala.ninetynine

import scala.annotation.tailrec

/**
 * @author "Maciej Jankowski <mac.rarry@gmail.com>"
 *
 */
object FindKthElem {

  def kthElem[T](k: Int, col: Seq[T]): T = {

    @tailrec
    def find[T](n: Int, col: Seq[T]): T = col match {
      case Seq() => throw new NoSuchElementException
      case Seq(x, xs @ _*) => if (n == 0) x else find(n - 1, xs)
    }
    find(k, col)
  }
}