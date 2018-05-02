package kata.tennis

class TennisGame(p1: Player, p2: Player) {
  def score: String = {
    val p1Score: String = TennisScoreTranslator(p1.score)
    val p2Score: String = TennisScoreTranslator(p2.score)

    s"$p1Score, $p2Score"
  }
}
