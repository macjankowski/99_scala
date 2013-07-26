package pl.macjankowski.scala.ninetynine

import java.util.NoSuchElementException
import scala.annotation.tailrec

/**
 * @author "Maciej Jankowski <mac.rarry@gmail.com>"
 *
 */
object FindLastButOne {

  @tailrec
  def lastButOne[T](col: Seq[T]): T = col match {
    case seq if (seq.isEmpty || seq.size == 1) => throw new NoSuchElementException
    case Seq(x1, x2) => x1
    case Seq(x1, x2, xs @ _*) => lastButOne(x2 +: xs)
  }
}