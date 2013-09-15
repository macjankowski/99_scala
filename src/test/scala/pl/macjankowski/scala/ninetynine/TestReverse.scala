package pl.macjankowski.scala.ninetynine

import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FunSpec

/**
 * @author "Maciej Jankowski <mac.rarry@gmail.com>"
 *
 */
class TestReverse extends FunSpec with ShouldMatchers with TableDrivenPropertyChecks {

  describe("Calculate length of Seq") {

    val testParams = Table(
      ("collection", "length"),
      (List(), List()),
      (List(1, 2, 3, 4, 5), List(5, 4, 3, 2, 1)),
      (List(3, 1), List(1, 3)),
      (Seq(1, 2, 3, 4), Seq(4, 3, 2, 1, 0)),
      (Seq(1), Seq(1))/*,
      (Seq.empty, Seq.empty)*/)

    forAll(testParams) { (col: Seq[Int], reversed: Seq[Int]) =>
      it(s"reversed collection [${col}] should be equal to [$reversed]") {
        ListReverse.reverse(col) should be (reversed)
      }
    }
  }
}