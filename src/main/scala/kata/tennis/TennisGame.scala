package kata.tennis

class TennisGame(p1: Player, p2: Player) {
  def score: (String, String) = (s"${p1.score}", s"${p2.score}")
}
