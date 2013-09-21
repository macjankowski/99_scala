package pl.macjankowski.scala.ninetynine

import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FunSpec
import scala.collection.generic.CanBuildFrom

/**
 * @author "Maciej Jankowski <mac.rarry@gmail.com>"
 *
 */
class TestReverse extends FunSpec with ShouldMatchers with TableDrivenPropertyChecks {

  describe("Reverse eny collection") {

    val testLists = Table(
      ("collection", "reversed"),
      (List(), List()),
      (List(1, 2, 3, 4, 5), List(5, 4, 3, 2, 1)),
      (List(3, 1), List(1, 3)))

    val testSeqs = Table(
      ("collection", "reversed"),
      (Seq(1, 2, 3, 4), Seq(4, 3, 2, 1)),
      (Seq(1), Seq(1)))

    val testArrays = Table(
      ("collection", "reversed"),
      (Array(), Array()),
      (Array(1, 2, 3, 4), Array(4, 3, 2, 1)),
      (Array(1), Array(1)))

    forAll(testLists) { (collection, reversed) =>
      it(s"reversed list [${collection}] should be equal to [$reversed]") {
        val after = ListReverse.reverseAny(collection)
        after should be(reversed)

        println("collection.getClass(): " + collection.getClass())
        println("after.getClass(): " + after.getClass())
        collection.getClass() should equal(after.getClass())

      }
    }

    forAll(testSeqs) { (collection, reversed) =>

      it(s"reversed sequence [${collection}] should be equal to [$reversed]") {
        val after = ListReverse.reverseAny(collection)
        after should be(reversed)

        println("collection.getClass(): " + collection.getClass())
        println("after.getClass(): " + after.getClass())
        collection.getClass() should equal(after.getClass())
      }
    }

//    val arrayToTraversableBuilder = new CanBuildFrom[Array[Int], Int, Array[Int]] { def apply(from: Array[Int]) = this.apply(); def apply() = Array.newBuilder }
//
//    forAll(testArrays) { (collection, reversed) =>
//
//      it(s"reversed sequence [${collection}] should be equal to [$reversed]") {
//        val after = ListReverse.reverseAny(collection)(arrayToTraversableBuilder)
//        after should be(reversed)
//
//        println("collection.getClass(): " + collection.getClass())
//        println("after.getClass(): " + after.getClass())
//        collection.getClass() should equal(after.getClass())
//      }
//    }
  }
}