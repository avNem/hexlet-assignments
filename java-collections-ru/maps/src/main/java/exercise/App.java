package exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static void main(String[] args) {
        String sentence = "the java is the best programming language java";
        Map wordsCount = App.getWordCount(sentence);
        String result = App.toString(wordsCount);
        System.out.println(result);

        Map wordsCount2 = App.getWordCount("");
        String result2 = App.toString(wordsCount2);
        System.out.println(result2); // => {}
    }

    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> result = new HashMap<>();
        if (sentence.isEmpty()) return result;
        String[] stringArray = sentence.split(" ");
        for(int i = 0; i < stringArray.length; i++) {
            int countWord = 1;
            for(int j = i + 1; j < stringArray.length; j++) {
                if(stringArray[i].equals(stringArray[j])) {
                    countWord++;
                }
            }
            if(!result.containsKey(stringArray[i])) {
                result.put(stringArray[i], countWord);
            }
        }
        return result;
    }

    public static String toString(Map<String, Integer> map) {
        StringBuilder stringBuilder = new StringBuilder();
        if (map.isEmpty()) return stringBuilder.append("{}").toString();
        stringBuilder.append("{\n");
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            stringBuilder.append("  " + entry.getKey() + ": " + entry.getValue() + "\n");
        }

        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
//END
