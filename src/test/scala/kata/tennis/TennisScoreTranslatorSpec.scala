package kata.tennis

import org.scalatest.{WordSpec, Matchers}

class TennisScoreTranslatorSpec extends WordSpec with Matchers {
  "TennisScoreTranslator should translate score" when {
    "= 0" in {
      TennisScoreTranslator(0) should equal ("love")
    }
  }
}
