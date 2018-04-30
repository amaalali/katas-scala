package kata.fizzbuzz

import org.scalatest.FlatSpec

class FizzBuzzSpec extends FlatSpec {
  "FizzBuzz" should "return fizz if the number is dividable by 3" in {
    assert(FizzBuzz(3) == "fizz")
    assert(FizzBuzz(6) == "fizz")
  }
 
  it should "return buzz if the number is dividable by 5" in {
    assert(FizzBuzz(5) == "buzz")
    assert(FizzBuzz(10) == "buzz")
  }
 
  it should "return fizzbuzz if the number is dividable by 15" in {
   assert(FizzBuzz(15) == "fizzbuzz")
   assert(FizzBuzz(30) == "fizzbuzz")
  }

  it should "return seven if the number is 7" in {
    assert(FizzBuzz(7) == "seven")
  }

  it should "return the same number if no other requirement is fulfilled" in {
   assert(FizzBuzz(1) == "1")
   assert(FizzBuzz(2) == "2")
   assert(FizzBuzz(4) == "4")
  }
}