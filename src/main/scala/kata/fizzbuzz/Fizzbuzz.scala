package kata.fizzbuzz

object FizzBuzz {
  def apply(input: Int): String = {
      (unwrapper compose sevens compose buzzer compose fizzer)(input, None)
  }

  private val fizzer = (bla("fizz", isDivBy3, _: Int, _: Option[String])).tupled
  private val buzzer = (bla("buzz", isDivBy5, _: Int, _: Option[String])).tupled
  private val sevens = (bla("seven", (input: Int) => input == 7, _: Int, _: Option[String])).tupled
  private val unwrapper = (unwrap _).tupled

  private def bla(response: String, testFn: Int => Boolean, dividend: Int, responseAcc: Option[String]): (Int, Option[String]) = {
    val returnVal = if (testFn(dividend)) Some(responseAcc.getOrElse("") + response) else responseAcc
    (dividend, returnVal)
  }

  private def unwrap(inputValue:Int, responseStr: Option[String]): String = {
    responseStr.getOrElse(inputValue.toString)
  }

  private val isDivBy3 = divBy(_: Int ,3)

  private val isDivBy5 = divBy(_:Int, 5)

  private def divBy(dividend: Int, divisor: Int): Boolean = dividend % divisor == 0
}
