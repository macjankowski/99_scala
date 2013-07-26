package pl.macjankowski.scala.ninetynine

import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FunSpec

/**
 * @author "Maciej Jankowski <mac.rarry@gmail.com>"
 *
 */
class TestFindLastButOne extends FunSpec with ShouldMatchers with TableDrivenPropertyChecks {

  val wrongParams = Table(
    ("colName", "collection", "result"),
    ("Empty list", Nil, -1),
    ("List with one elem", List(1), -1),
    ("Seq with one elem", Seq(15), -1))

  val intParams = Table(
    ("colName", "collection", "result"),
    ("List", List(1, 2, 3, 4, 5), 4),
    ("List", List(3, 1), 3),
    ("Seq", Seq(1, 2, 3, 4), 3))

  describe("FindLast.last") {

    forAll(wrongParams) { (colName: String, col: Seq[Int], res) =>
      it(s"should throw exception for ${colName}") {
        evaluating {
          FindLastButOne.lastButOne(col)
        } should produce[NoSuchElementException]
      }
    }

    forAll(intParams) { (colName: String, col: Seq[Int], res) =>
      it(s"should return $res for ${colName} with ints ${col.mkString(", ")}") {
        FindLastButOne.lastButOne(col) should equal(res)
      }
    }
  }

}