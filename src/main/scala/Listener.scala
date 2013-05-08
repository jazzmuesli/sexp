import akka.actor._
class Listener extends Actor {
	def receive = {
		case _ => System.out.println("unknown")
	}
}

object HelloWorld {
    def main(args: Array[String]) {
      println("Hello, world!")
	val system = ActorSystem("mySystem")
	val myActor = system.actorOf(Props[Listener], name="myactor")
	myActor ! "Doors"
    }
}
