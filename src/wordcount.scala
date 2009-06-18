def countWords(lines: List[String]):  Map[String, Int] = {
    val words = for { line <- lines 
	 		word  <- line.split("\\W+|\\d+")
    } yield word.toLowerCase.trim
 
    val emptyMap: Map[String, Int] = Map.empty.withDefaultValue(0)
    (emptyMap /: words) { case (map, word) =>  map(word) += 1  }
  }

//usage
val counts = countWords(List("This is a word count example for Open Source Bridge", "Yet another sample for Open Source Bridge"))