package pl.macjankowski.scala.ninetynine

/**
 * @author "Maciej Jankowski <mac.rarry@gmail.com>"
 *
 */
object Palindrome {

  def isPalindrome[T](l: List[T]): Boolean = l == l.reverse
}