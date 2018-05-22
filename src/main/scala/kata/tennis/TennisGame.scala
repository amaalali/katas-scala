package kata.tennis

class TennisGame(p1: Player, p2: Player) {
  private var gameScore = (0,0)

  private val POINT_MAP = Map(
    0 -> "love",
    1 -> "fifteen",
    2 -> "thirty",
    3 -> "forty"
  )

  private val MAX_SCORE = 3


  def score: String = {
    (translateScore.tupled)(gameScore)
  }

  def winBall(winner: Player): Unit = {
    gameScore = winner match {
      case _ if winner == p1 => (gameScore._1 + 1, gameScore._2)
      case _ if winner == p2=> (gameScore._1, gameScore._2 + 1)
    }
  }

  def winBall_p1: Unit = {
    if (!isGameOver(gameScore._1: Int, gameScore._1: Int)) {
      gameScore = (gameScore._1 + 1, gameScore._2)
    }
  }

  def winBall_p2: Unit = {
    if (!isGameOver(gameScore._1: Int, gameScore._1: Int)) {
      gameScore = (gameScore._1, gameScore._2 + 1)
    }
  }

  def score_p1: Int = gameScore._1

  def score_p2: Int = gameScore._2

  val translateScore: (Int, Int) => String = (s1: Int, s2: Int) => {
    if (isGameOver(s1, s2)) {
      if (s1 > s2) {
        s"${p1.name} won"
      } else {
        s"${p2.name} won"
      }
    } else if (isDeuce(s1, s2)) {
      "deuce"
    } else if (s1 > MAX_SCORE || s2 > MAX_SCORE) {
        if (s1 > s2) {
          s"advantage ${p1.name}"
        } else {
          s"advantage ${p2.name}"
        }
    } else
      s"${POINT_MAP(s1)}, ${POINT_MAP(s2)}"
  }

  private def isDeuce(score1: Int, score2: Int): Boolean = {
    score1 >= MAX_SCORE && score2 >= MAX_SCORE && score1 == score2
  }

  private def isGameOver(score1: Int, score2: Int): Boolean = {
    def differnceGD2(s1: Int, s2: Int): Boolean = Math.abs(s1 - s2) >= 2

    (score1 > MAX_SCORE || score2 > MAX_SCORE) && differnceGD2(score1, score2)
  }
}
