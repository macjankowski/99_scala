package pl.macjankowski.scala.ninetynine

import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FunSpec

/**
 * @author "Maciej Jankowski <mac.rarry@gmail.com>"
 *
 */
class TestPalindrome extends FunSpec with ShouldMatchers with TableDrivenPropertyChecks {

  val testLists = Table(
    ("collection", "isPalindrome"),
    (List(), true),
    (List(1), true),
    (List(1, 2, 3, 4, 5), false),
    (List(1, 3, 1), true),
    (List(1, 3, 5, 3, 1), true),
    (List(1, 3, 3, 3, 1), true),
    (List(5, 5, 5, 5, 5, 5, 5, 5), true))

  describe("Test palindrome methods") {

    forAll(testLists) { (collection, isPalindrome) =>

      val p = if (isPalindrome) "" else " not"
      it(s"list [${collection}] is$p a palindrome") {
        Palindrome.isPalindrome(collection) should be(isPalindrome)
      }
    }

  }
}