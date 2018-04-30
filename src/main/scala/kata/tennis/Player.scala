package kata.tennis

class Player(name: String) {
  private var player_score: Int = 0

  def score: Int = player_score

  def winBall: Unit = {
    player_score += 1
  }
}

object Player {
  def apply(name: String): Player = new Player(name)
}