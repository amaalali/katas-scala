package kata.tennis

import org.scalatest.{FlatSpec, Matchers}

class TennisGameSpec extends FlatSpec with Matchers {
  "Points" can "be added to each player" in {
    val victor = Player("Victor")
    val sarah = Player("Sarah")
    val game = new TennisGame(p1 = victor, p2 = sarah)

    game.winBall(victor)
    game.winBall(victor)
    game.winBall(sarah)
    game.winBall(victor)

    game.score_p1 should be (3)
    game.score_p2 should be (1)
  }

  "Love" should "be description for score 0" in {
    val victor = Player("Victor")
    val sarah = Player("Sarah")
    val game = new TennisGame(p1 = victor, p2 = sarah)

    game.score should be ("love, love")
  }

  "Fifteen" should "be description for score 1" in {
    val victor = Player("Victor")
    val sarah = Player("Sarah")
    val game = new TennisGame(victor, sarah)

    game.winBall(sarah)

    game.score should be ("love, fifteen")
  }

  "Thirty" should "be description for score 2" in {
    val victor = Player("Victor")
    val sarah = Player("Sarah")
    val game = new TennisGame(victor, sarah)

    game.winBall(victor)
    game.winBall(victor)
    game.winBall(sarah)

    game.score should be ("thirty, fifteen")
  }

  "Forty" should "be description for score 3" in {
    val victor = Player("Victor")
    val sarah = Player("Sarah")
    val game = new TennisGame(victor, sarah)

    game.winBall(victor)
    game.winBall(victor)
    game.winBall(victor)

    game.score should be ("forty, love")
  }

  "Advantage" should "describe when least three points have been scored by each side and a player has one more point than his opponent" in {
    val victor = Player("Victor")
    val sarah = Player("Sarah")
    val game = new TennisGame(victor, sarah)

    for ( _ <- 1 to 3) { game.winBall(victor) }
    for ( _ <- 1 to 4) { game.winBall(sarah) }

    game.score should be ("advantage Sarah")
  }

  "Deuce" should "be description when at least three points have been scored by each player and the scores are equal" in {
    val victor = Player("Victor")
    val sarah = Player("Sarah")
    val game = new TennisGame(victor, sarah)

    (1 to 3).foreach(_ => game.winBall(victor))
    (1 to 3).foreach(_ => game.winBall(sarah))

    game.score should be ("deuce")
    game.winBall(victor)
    game.score should not be "deuce"
    game.winBall(sarah)
    game.score should be ("deuce")
  }

  "Game" should "be won by the first player to have won at least four points in total and with at least two points more than the opponent" in {
    val victor = Player("Victor")
    val sarah = Player("Sarah")
    val game = new TennisGame(victor, sarah)

    (1 to 3).foreach(_ => game.winBall(victor))
    (1 to 5).foreach(_ => game.winBall(sarah))

    game.score should be ("Sarah won")
  }
}
