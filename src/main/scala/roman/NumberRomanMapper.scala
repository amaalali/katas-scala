package roman

import scala.annotation.tailrec

case class RomanNumeral(value: String)

object NumberRomanMapper {

  private val mapping = Map(
    1    -> RomanNumeral("I"),
    5    -> RomanNumeral("V"),
    10   -> RomanNumeral("X"),
    50   -> RomanNumeral("L"),
    100  -> RomanNumeral("C"),
    500  -> RomanNumeral("D"),
    1000 -> RomanNumeral("M")
  )

  val reverseMapping = mapping.map(_.swap)

  private def toRomanNumeral(number: Int): RomanNumeral = mapping(number)

  private def toInt(romanNumeral: RomanNumeral): Int = reverseMapping(romanNumeral)


  def apply(number: RomanNumeral): Int = {
    // if next number is less than then add to total
    // if next number is equal to then collect
    // if next number is > this, then flip sign on current collection then add to total

    number.value
      .map(x => RomanNumeral(x.toString))
      .map(NumberRomanMapper.toInt)
      .:+(0)
      .foldLeft((0, Seq.empty[Int]))({
        case ((total, acc), next) if acc.isEmpty || acc.last == next => (total, acc :+ next)
        case ((total, acc), next) if acc.last > next => (total + acc.sum, Seq(next))
        case ((total, acc), next) if acc.last < next => (total + acc.map(x => -x ).sum, Seq(next))
      })
      ._1
  }

  def apply(number: Int): RomanNumeral = {
    def convert(number: Int): String = ???

    @tailrec
    def loop(intNum: Int, romanNum: RomanNumeral, toDo: Seq[Int]): RomanNumeral = {
      if (intNum == 0 || toDo.isEmpty)
        romanNum
      else {
        val nextRoman = RomanNumeral(romanNum.value + convert(intNum / toDo.head))

        loop(intNum % toDo.head, nextRoman, toDo.tail)
      }
    }

    loop(number, RomanNumeral(""), mapping.keys.toSeq)
  }
}
