package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static void main(String[] args) {
        System.out.println(App.scrabble("begsdhhtsexoult", "Hexlet")); // true
        System.out.println(App.scrabble("thlxertwq", "hexlet")); // false
        System.out.println(App.scrabble("avjafff", "JaVa")); // true
        System.out.println(App.scrabble("", "hexlet")); // false

    }
    public static boolean scrabble(String string, String word) {
        int search = 0;
        int checkSumWord = word.length();
        List<String> strings = new ArrayList<>(Arrays.asList(string.split("")));
        List<String> words = new ArrayList<>(Arrays.asList(word.split("")));

        for(int i = 0; i < words.size();i++) {
            for(int j = 0; j < strings.size(); j++) {
                if(words.get(i).equalsIgnoreCase(strings.get(j))) {
                    search++;
                    words.remove(words.get(i));
                    strings.remove(strings.get(j));
                    i--;
                    break;
                }
            }
        }
        return search == checkSumWord;
    }
}
//    public static boolean scrabble(String string, String word) {
//        int search = 0;
//        int checkSumWord = word.length();
//        List<String> strings = new ArrayList<>(Arrays.asList(string.split("")));
//
//        for(int i = 0; i < strings.size(); i++) {
//            if(word.toLowerCase().contains(strings.get(i).toLowerCase())) {
//                search++;
//                strings.remove(i);
//                i--;
//            }
//        }
//        return search == checkSumWord;
//    }
//}
//END
