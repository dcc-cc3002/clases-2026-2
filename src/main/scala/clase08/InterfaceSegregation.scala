package clase08

trait PlayerView:
  def hp: Int

trait IPlayer extends PlayerView:
  def hp_=(hp: Int): Unit

class Player extends IPlayer:
  private var _hp = 0
  def hp = _hp
  def hp_=(hp: Int): Unit = _hp = hp

class Controller(private val player: IPlayer):
  def hit(): Unit =
    player.hp = Math.max(0, player.hp - 10)

  def getCurrentPlayer: PlayerView = player

class Hacker(c: Controller):
  val p = c.getCurrentPlayer
  // p.hp = 100000000 //no compila!
