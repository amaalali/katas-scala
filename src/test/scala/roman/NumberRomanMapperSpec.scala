package roman

import org.scalatest.{FreeSpec, MustMatchers}

class NumberRomanMapperSpec extends FreeSpec with MustMatchers {

  implicit val bla: String => RomanNumeral = RomanNumeral.apply

  "Roman numeral to Number" - {
    "Converts for numbers <= than 3" in {

      NumberRomanMapper("I") mustBe 1
      NumberRomanMapper("II") mustBe 2
      NumberRomanMapper("III") mustBe 3

    }

    "Converts for numbers <= than 5" in {

      NumberRomanMapper("IV") mustBe 4
      NumberRomanMapper("V") mustBe 5

    }

    "Converts for numbers <= than 10" in {

      NumberRomanMapper("VI") mustBe 6
      NumberRomanMapper("VII") mustBe 7
      NumberRomanMapper("VIII") mustBe 8

    }

    "Arbitrarily large numbers" in {
      NumberRomanMapper("CCCXLVIII") mustBe 348
      NumberRomanMapper("CDXLVI") mustBe 446

    }
  }

  "Number to Roman numeral" ignore {
    "Converts for numbers <= than 3" in {

       1 mustBe NumberRomanMapper("I")
//       2 mustBe NumberRomanMapper("II")
//       3 mustBe NumberRomanMapper("III")

    }

  }
}
