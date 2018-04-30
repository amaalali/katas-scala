package kata.tennis

import org.scalatest.{FlatSpec, Matchers}

class PlayerSpec extends FlatSpec with Matchers {
  "Player intial score" should "be zero" in {
    val player: Player = Player("test_name")
    player.score should equal (0)
  }

  it should "increase when player wins ball" in {
    val player: Player = Player("test_name")
    player.winBall
    player.score should equal (1)
  }
}
