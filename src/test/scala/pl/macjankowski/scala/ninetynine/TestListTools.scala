package pl.macjankowski.scala.ninetynine

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

/**
 * @author mac
 *
 */
class TestListTools extends FunSpec with ShouldMatchers {

  describe("ListTools.last") {
    it("should return last element of a list") {
      ListTools.last(List(1, 2, 3, 4, 5)) should equal(5)
    }

    it("should throw exception for empty list") {
      evaluating { ListTools.last(Nil) } should produce[NoSuchElementException]
    }

    it("should return the only element of a list of size 1") {
      ListTools.last(List(3)) should equal(4)
    }
  }

}