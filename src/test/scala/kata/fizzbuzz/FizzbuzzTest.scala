package kata.fizzbuzz

import org.scalatest.FunSuite

class FizzBuzzSpec extends FunSuite {
  test("return fizz if the number is dividable by 3") {
    assert(FizzBuzz(3) == "fizz")
    assert(FizzBuzz(6) == "fizz")
  }

  test("return buzz if the number is dividable by 5") {
    assert(FizzBuzz(5) == "buzz")
    assert(FizzBuzz(10) == "buzz")
  }

  test("return fizzbuzz if the number is dividable by 15") {
    assert(FizzBuzz(15) == "fizzbuzz")
    assert(FizzBuzz(30) == "fizzbuzz")
  }

  test("return seven if the number is 7") {
    assert(FizzBuzz(7) == "seven")
  }

  test("return the same number if no other requirement is fulfilled") {
    assert(FizzBuzz(1) == "1")
    assert(FizzBuzz(2) == "2")
    assert(FizzBuzz(4) == "4")
  }
}