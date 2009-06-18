//In Java
class MyJavaClass { 
	private int position; 
	private String name; 
	private String who;
	
	public MyJavaClass(int position, String name) { 
		this.position = position; 
		this.name = name; 
	}	 
	
	public String getWho(){
	 return who;
	}
	
	public void setWho(String who){
	  this.who = who;
	}
}

//In Scala
class MyScalaClass(index: Int, name: String, var who: String) {
}


//Java Usage
MyJavaClass myGreatClass = new MyJavaClass(1, "Shawn");
myGreatClass.setWho("You");
String whoIs = myGrmyGreatClass.getWho();



//In Scala
val myScalaClass = new MyScalaClass(1, "Shawn")
myScalaClass.who = "You"
val whoIs = myScalaClass.who


object HelloWorld {
  def main(args: Array[String]) = {
    val greeting = "Hello "
    args.foreach(arg => println(greeting + arg))
  }
}

HelloWorld.main(Array("Shawn", "Amber"))



//cribbed from the scala docs
trait Similarity {
  def isSimilar(x: Any): Boolean
  def isNotSimilar(x: Any): Boolean = !isSimilar(x)
}

class Point(xc: Int, yc: Int) extends Similarity {
  var x: Int = xc
  var y: Int = yc
  def isSimilar(obj: Any) =
    obj.isInstanceOf[Point] &&
    obj.asInstanceOf[Point].x == x
}



