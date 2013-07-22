package pl.macjankowski.scala.ninetynine

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.prop.TableDrivenPropertyChecks

/**
 * @author mac
 *
 */
class TestFindLast extends FunSpec with ShouldMatchers with TableDrivenPropertyChecks {

  val wrongParams = Table(
    ("colName", "collection", "result"),
    ("Empty list", Nil, -1),
    ("Empty set", Set.empty, -1))

  val intParams = Table(
    ("colName", "collection", "result"),
    ("List", List(1, 2, 3, 4, 5), 5),
    ("List", List(3), 3),
    ("Seq", Set(1, 2, 3, 4), 4))

  val doubleParams = Table(
    ("colName", "collection", "result"),
    ("Seq", Seq(1.0, 4.3, 9.3), 9.3),
    ("List", List(1.0, 4.3, 9.3), 9.3))

  describe("FindLast.last") {

    forAll(wrongParams) { (colName: String, col: Traversable[Nothing], res) =>
      it(s"should throw exception for ${colName}") {
        evaluating {
          FindLast.lastT(col)
        } should produce[NoSuchElementException]
      }
    }

    forAll(intParams) { (colName: String,col: Traversable[Int], res) =>
      it(s"should return $res for ${colName} with ints ${col.mkString(", ")}") {
        FindLast.lastT(col) should equal(res)
      }
    }

    forAll(doubleParams) { (colName: String,col: Traversable[Double], res) =>
      it(s"should return $res for ${colName} with doubles ${col.mkString(", ")}") {
        FindLast.lastT(col) should equal(res)
      }
    }

  }

}
