import scala.actors.Actor
import scala.actors.Actor._
import scala.actors.remote.RemoteActor._

case object Ping
case object Pong
case object Quit

object RemotePongApp {
    def main(args: Array[String]) : Unit = {
        val port = args(0).toInt
        val pong = new RemotePong(port)
        pong.start
        println("Started Pong")
    }
}
class RemotePong(port: Int) extends Actor {
def act() {
    alive(port)
    register('Pong, self)

    loop {
      react {
        case Ping =>
          Console.println("Pong: ping")
          sender ! Pong
        case Quit =>
          Console.println("Pong: stop")
          exit 	
      }
    }
  }
}