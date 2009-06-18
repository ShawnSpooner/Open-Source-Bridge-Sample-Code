//simple pattern match
case object OsBridge

def describe(x: Any) = x match { 
	case 8 => "eight" 
	case false => "false" 
	case "greetings" => "hello" 
	case Nil => "an empty list" 
	case OsBridge => "welcome to OsBridge"
	case (1, x, y) if x == y => "found a tuple starting with one where the next two elements are equal"
	case m: Map[_, _] => "got a map"
	case List(8, _, _) => "found list starting with 8, with 3 elements"//to get arbitary length you would use _*
	case everythingElse => "Fell through: "+ everythingElse
//	case _ => "everything else"//patterns are tried in the order they are declared
} 

describe(8)

describe(OsBridge)

describe("SomeOtherThing")



//Simple functions
val double = (x: Int) => x * 2

double(4)

val sum = (x :Int, y :Int, z :Int) => x + y + z

sum(1,2,3)
//partially applied functions
val asum = sum _ //create an alias for sum
asum(1,2,3)


val partsum = sum(1, _: Int, 3) 
partsum(2)

//Merge Sort
def msort[T](less: (T, T) => Boolean) (xs: List[T]): List[T] = { 
	def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match { 
			case (Nil, _) => ys 
			case (_, Nil) => xs 
			case (x :: xs1, y :: ys1) => 
				if (less(x, y)) x :: merge(xs1, ys) 
				else y :: merge(xs, ys1) 
		} 
		val n = xs.length / 2 
		if (n == 0) xs 
		else { 
			val (ys, zs) = xs splitAt n 
				merge(msort(less)(ys), msort(less)(zs)) 
		} 
} 

msort((x: Int, y: Int) => x < y)(List(5, 7, 1, 3)) 

val sortAscending = msort( x: Int, y: Int) => x < y) _
sortAscending(List(3,8,9,1,0))
