package pl.macjankowski.scala.ninetynine

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FunSpec
import org.scalatest.prop.TableDrivenPropertyChecks

/**
 * @author "Maciej Jankowski <mac.rarry@gmail.com>"
 *
 */
class TestListLength extends FunSpec with ShouldMatchers with TableDrivenPropertyChecks {

  describe("Calculate length of Seq") {

    val testParams = Table(
      ("collection", "length"),
      (List(), 0),
      (List(1, 2, 3, 4, 5), 5),
      (List(3, 1), 2),
      (Seq(1, 2, 3, 4), 4),
      (Seq(1), 1),
      (Seq(1, 2, 3, 4, 5, 6), 6))

    forAll(testParams) { (col: Seq[Int], length: Int) =>
      it(s"collection [${col.mkString(", ")}] should have length $length") {
        ListLength.length(col) == length
      }
    }
  }

  describe("Calculate length of Traversable") {

    val testParams = Table(
      ("collection", "length"),
      (List(), 0),
      (List(1, 2, 3, 4, 5), 5),
      (List(3, 1), 2),
      (Seq(1, 2, 3, 4), 4),
      (Seq(1), 1),
      (Seq(1, 2, 3, 4, 5, 6), 6),
      (Set(), 0),
      (Set(5), 1),
      (Set(5, 2, 4, 3, 1), 5))

    forAll(testParams) { (col: Traversable[Int], length: Int) =>
      it(s"collection ${col.getClass.getName()}[${col.mkString(", ")}] should have length $length") {
        ListLength.lengthT(col) == length
      }
    }
  }
}
