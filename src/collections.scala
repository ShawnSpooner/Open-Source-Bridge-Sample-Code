
//Sampling of List
val list1 = 1 :: 2 :: 3 :: 4 :: 5 :: 6 ::7 ::8 :: 9 :: Nil
val list2 = List(10, 11, 12, 13, 14, 15, 16, 17, 18, 19)

val doubled = list1 map(_ * 2)// can also be written as list.map( val => val * 2)

val evens = list1 filter( _ % 2 == 0)

val sum: Int =  (sum /: list2) { _ + _ }

val (evens, odds) = list1 partition (_ % 2 == 0) //returns a tuple of successe and failure lists

val zipped = list1 zip list2//(1,10),(2,11)...

val first = list1(0)
val a :: b : rest = list1 //pattern match to deconstruct a list
val head = list1.head
val tail = list1.tail

val intersection = list1 intersect list2
val listunion = list1 union list2
val concatList = list1 ::: list2//list concat 


//Sampling of Tuples
val tuple = (1, "Shawn")
val count = tuple._1
val name = tuple._2
val (count, name) = tuple



//map and option type
val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo") 

val paris = capitals get "France" 
 
val none = capitals get "North Pole" 

capitals + ("Colorado" -> "Denver")
capitals ++ List("Oregon" -> "Salem", "Kansas" -> "Topeka" )
capitals - ("Kansas")

def matchOption(x: Option[String]) = x match { 
  case Some(s) => s 
  case None => "?" 
} 

matchOption(capitals get "Japan")
