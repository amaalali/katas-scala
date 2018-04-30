package kata.tennis

object TennisScoreTranslator {
  def apply(score: Int): String = {
    score match {
      case x if x==0 => "love"
    }
  }
}
