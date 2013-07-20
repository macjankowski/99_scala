package pl.macjankowski.scala.ninetynine

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

/**
 * @author mac
 *
 */
class TestFindLast extends FunSpec with ShouldMatchers {

  describe("FindLast.last") {
    it("should return last element of a list") {
      FindLast.last(List(1, 2, 3, 4, 5)) should equal(5)
    }

    it("should throw exception for empty list") {
      evaluating { FindLast.last(Nil) } should produce[NoSuchElementException]
    }

    it("should return the only element of a list of size 1") {
      FindLast.last(List(3)) should equal(3)
    }
  }

  describe("FindLast generic version") {
    it("should work for double") {
      FindLast.lastG(List(1.0, 4.3, 9.3)) should equal(9.3)
    }

    it("should work for string") {
      FindLast.lastG(List("a", "b", "c")) should equal("c")
    }
  }

  describe("FindLast in Traversable") {
    
    it("should work for seq") {
      FindLast.lastT(Seq(1.0, 4.3, 9.3)) should equal(9.3)
    }
    
    it("should work for set") {
      FindLast.lastT(Set(1.0, 4.3, 9.3)) should equal(9.3)
    }

  }

}