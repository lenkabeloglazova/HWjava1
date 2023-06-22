import java.util.HashMap;
import java.util.Map;

public class HW1 {

    public static void main(String[] args) {
        String sentence = "Россия идет вперед всей планеты. Планета — это не Россия.";
        String word = "Россия";
        int count = countWord(sentence, word);
        System.out.println(word + " - " + count);
    }
    
    public static int countWord(String sentence, String word) {
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = sentence.split("\\W+");
        
        for (String w : words) {
            String lowerCaseWord = w.toLowerCase();
            
            if (lowerCaseWord.equals(word.toLowerCase())) {
                if (wordCount.containsKey(lowerCaseWord)) {
                    wordCount.put(lowerCaseWord, wordCount.get(lowerCaseWord) + 1);
                } else {
                    wordCount.put(lowerCaseWord, 1);
                }
            }
        }
        
        return wordCount.getOrDefault(word.toLowerCase(), 0);
    }
}