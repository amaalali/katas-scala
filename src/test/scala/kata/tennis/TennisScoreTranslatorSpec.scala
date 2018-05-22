package kata.tennis

import org.scalatest.{WordSpec, Matchers}

class TennisScoreTranslatorSpec extends WordSpec with Matchers {
  "TennisScoreTranslator should translate values" when {
    "player one score is passed" in {
      TennisScoreTranslator(1,0) should equal ("fifteen, love")
      TennisScoreTranslator(2,0) should equal ("thirty, love")
      TennisScoreTranslator(3,0) should equal ("forty, love")
    }

    "player two score is passed" in {
      TennisScoreTranslator(0,0) should equal ("love, love")
      TennisScoreTranslator(0,1) should equal ("love, fifteen")
      TennisScoreTranslator(0,2) should equal ("love, thirty")
      TennisScoreTranslator(0,3) should equal ("love, forty")
    }
  }
}
