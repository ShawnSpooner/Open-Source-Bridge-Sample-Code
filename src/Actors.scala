import scala.actors.Actor
import scala.actors.Actor._

case class Rectangle(width: Double, height: Double)
case class Circle(radius: Double)
case class AreaResult(result: String)

val areaCalculator: Actor = actor {
		receive { 
			case Circle(radius) => 
				println(3.14159 * radius * radius) 
			case Rectangle(width, height) => 
				println(width * height) 
		}
}

areaCalculator start

areaCalculator ! Circle(5)

areaCalculator ! Rectangle( 2, 4)




case class Rectangle(width: Double, height: Double, actor: Actor)
case class Circle(radius: Double, actor: Actor)
case class AreaResult(result: Double)

val areaCalculator: Actor = actor {
  loop {
		react { 
			case Circle(radius, from) => 
				from ! AreaResult(3.14159 * radius * radius) 
			case Rectangle(width, height, from) => 
				from ! AreaResult(width * height) 
		}
  }
}

areaCalculator start

areaCalculator ! Circle(5, self)
self.receive { case x => x } 

areaCalculator ! Rectangle( 2, 4, self)
self.receive { case x => x } 

