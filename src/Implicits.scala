//Adding methods to an exsisting library
class LongExtensions(wrappedLong: Long){
	def toBase36(){
		import java.lang.Long
		Long.toString(wrappedLong, 36)
	}
}

implicit def longExtensions(wrappedLong: Long) = new LongExtensions(wrappedLong)

3498083L.toBase36


//Examples from the docs
//Structural typing
class File(name: String) {
    def getName(): String = name
    def open() { /*..*/ }
    def close() { println("close file") }
}
def test(f: { def getName(): String }) { println(f.getName) }//Quack??

test(new File("test.txt"))
test(new java.io.File("test.txt"))


//View Bounds
def maxList[T <% Ordered[T]](elements: List[T]): T = elements match { 
	case List() => 
		throw new IllegalArgumentException("empty list!") 
	case List(x) => x 
	case x :: rest => 
		val maxRest = maxList(rest) // (orderer) is implicit 
		if (x > maxRest) x // orderer(x) is implicit 
		else maxRest 
} 

maxList(List(1,282,3,4,5,99))