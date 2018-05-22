package kata.tennis

object TennisScoreTranslator {
  private val POINT_MAP = Map(
    0 -> "love",
    1 -> "fifteen",
    2 -> "thirty",
    3 -> "forty"
  )

  def apply(p1: Int, p2: Int): String = {
    if (scoresGreaterThanMax(p1, p2)) {
      if (isDeuce(p1, p2))
        "deuce"
      else
        "bla"

    } else
      s"${POINT_MAP(p1)}, ${POINT_MAP(p2)}"
  }

  private def scoresGreaterThanMax(score1: Int, score2: Int): Boolean = {
    val MAX_SCORE = 3

    score1 >= MAX_SCORE && score2 >= MAX_SCORE
  }

  private def isDeuce(score1: Int, score2: Int): Boolean = {
    scoresGreaterThanMax(score1, score2) && score1 == score2
  }
}
