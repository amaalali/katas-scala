package kata.fizzbuzz

object FizzBuzz {
  def apply(input: Int): String = {
      (unwrap compose sevens compose buzzer compose fizzer)(input, None)
  }

  private val fizzer = bla("fizz", divBy(3)) _ tupled
  private val buzzer = bla("buzz", divBy(5)) _ tupled
  private val sevens = bla("seven", _ == 7) _ tupled

  private def bla(response: String, testFn: Int => Boolean)( dividend: Int, responseAcc: Option[String]): (Int, Option[String]) = {
    val returnVal = if (testFn(dividend)) Some(responseAcc.getOrElse("") + response) else responseAcc
    (dividend, returnVal)
  }

  private val unwrap: ((Int, Option[String])) => String = {
    case (inputValue, responseStr) => responseStr.getOrElse(inputValue.toString)
  }

  private def divBy(divisor: Int)(dividend: Int): Boolean = dividend % divisor == 0
}
