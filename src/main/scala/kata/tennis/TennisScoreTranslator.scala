package kata.tennis

object TennisScoreTranslator {
  private val POINT_MAP = Map(
    0 -> "love",
    1 -> "fifteen",
    2 -> "thirty",
    3 -> "forty"
  )

  def apply(score: Int): String = POINT_MAP(score)
}
