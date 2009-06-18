import scala.actors.Actor
import scala.actors.Actor._
import scala.actors.Exit
import scala.actors.remote.RemoteActor._
import scala.actors.remote.Node


//expects to be passed a port to start on, peername and peer port
object RemotePingApp {
    def main(args: Array[String]) : Unit = {
        val port = args(0).toInt
        val peer = Node(args(1), args(2).toInt)
        val ping = new RemotePing(port, peer, 8)
        ping.start
    }
}

class RemotePing(port: Int, peer: Node, count: Int) extends Actor {
    trapExit = true	

    def act() {
    alive(port)		
    register('Ping, self) 

    val pong = select(peer, 'Pong) 
    link(pong)			   

    var pingsLeft = count - 1
    pong ! Ping    	
    loop {
      react {		
        case Pong =>
          Console.println("Ping: pong")
          if (pingsLeft > 0) {
            pong ! Ping
            pingsLeft -= 1
          } else {
            Console.println("Ping: start termination")
            pong ! Quit		
            // Terminate ping after Pong exited (by linking)
          }
        case Exit(pong, 'normal) =>	
            Console.println("Ping: stop")
            exit
      }
    }
  }
}

case object Ping
case object Pong
case object Quit