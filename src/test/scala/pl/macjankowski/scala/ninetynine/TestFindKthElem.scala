package pl.macjankowski.scala.ninetynine

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.prop.TableDrivenPropertyChecks

/**
 * @author "Maciej Jankowski <mac.rarry@gmail.com>"
 *
 */
class TestFindKthElem extends FunSpec with ShouldMatchers with TableDrivenPropertyChecks {

  val wrongParams = Table(
    ("collection", "index", "result"),
    (Nil, 1, -1),
    (List(1), 3, -1),
    (Seq(15), 5, -1))

  val intParams = Table(
    ("collection", "index", "result"),
    (List(1, 2, 3, 4, 5), 2, 3),
    (List(3, 1), 1, 1),
    (Seq(1, 2, 3, 4), 0, 1),
    (Seq(1), 0, 1),
    (Seq(1, 2, 3, 4, 5, 6), 4, 5))

  describe("FindKth elem") {

    forAll(wrongParams) { (col: Seq[Int], index: Int, res) =>
      it(s"should throw exception for index $index and collection [${col.mkString(", ")}]") {
        evaluating {
          FindKthElem.kthElem(index, col)
        } should produce[NoSuchElementException]
      }
    }

    forAll(intParams) { (col: Seq[Int], index: Int, res) =>
      it(s"${index}th element of [${col.mkString(", ")}] should be $res") {
        FindKthElem.kthElem(index, col) should equal(res)
      }
    }
  }

}
