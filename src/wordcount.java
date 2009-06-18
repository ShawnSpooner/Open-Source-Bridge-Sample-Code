import java.util.Map;

public Map<String, Integer> countWords(List<String> lines){
	Map<String, Integer> count = new Map<String, Integer>();
  for(String line: lines){
		for(String word : line.split("\\W+|\\d+")){
			String lowerWord = word.toLowerCase().trim();
			if(counts.containsKey(lowerWord))
	      counts.get(lowerWord) += 1;
	    else
	      counts.put(lowerWord, 0);
		}
	}
}