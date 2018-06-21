package kata.rotatedWords

import org.scalatest.{Assertion, FunSuite}

class RotatedWordsAcceptenceSpec extends FunSuite {
  test("returns partitions of single elements when none are rotations") {
    val list = List("Tokyo", "London", "Rome", "Paris")
    implicit val expectedResult = Set(Set("Tokyo"), Set("London"), Set("Rome"), Set("Paris"))

    RotatedWords(list)?
  }

  test("returns single partition grouping words when all are rotations of each other") {
    val list = List("Tokyo", "Kyoto")
    implicit val expectedResult = Set(Set("Tokyo", "Kyoto"))

    RotatedWords(list)?
  }

  test("returns multiple partitions grouping words when there are multiple different rotations") {
    val list = List("Tokyo", "London", "Donlon", "Kyoto")
    implicit val expectedResult = Set(Set("Tokyo", "Kyoto"), Set("London", "Donlon"))

    RotatedWords(list)?
  }

  test("returns partitions of single elements for non-matches and grouped words for those that are rotations") {
    val list = List("Tokyo", "London", "Rome", "Donlon", "Kyoto", "Paris")
    implicit val expectedResult = Set(Set("Tokyo", "Kyoto"), Set("London", "Donlon"), Set("Rome"), Set("Paris"))

    RotatedWords(list)?
  }

  test("words that are sub-cycles of others should not be in the same partition") {
    val list = List("abc", "abca")
    implicit val expectedResult = Set(Set("abc"), Set("abca"))

    RotatedWords(list)?
  }

  private implicit class ExpectationHelper(underTest: Set[Set[String]]) {
    def ?(implicit expectedValue: Set[Set[String]]): Assertion = assert(underTest === expectedValue)
  }
}
