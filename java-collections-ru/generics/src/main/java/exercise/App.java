package exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

// BEGIN
public class App {
    public static void main(String[] args) {
        List<Map<String, String>> books = List.of(
                Map.of("title", "Cymbeline", "author", "Shakespeare", "year", "1611"),
                Map.of("title", "Book of Fooos", "author", "FooBar", "year", "1111"),
                Map.of("title", "The Tempest", "author", "Shakespeare", "year", "1611"),
                Map.of("title", "Book of Foos Barrrs", "author", "FooBar", "year", "2222"),
                Map.of("title", "Still foooing", "author", "FooBar", "year", "3333"),
                Map.of("title", "Happy Foo", "author", "FooBar", "year", "4444")
        );


        Map<String, String> where = new HashMap<>(Map.of(
                "title", "Still foooing",
                "author", "FooBar",
                "year", "4444"));
        List<Map<String, String>> result = App.findWhere(books, where);

        System.out.println(result);
        System.out.println(result.size());
    }
    public static List<Map<String,String>> findWhere(List<Map<String,String>> books, Map<String,String> where) {
        List<Map<String,String>> resultList = new ArrayList<>();

        if((where.size()) < 3) {
            for(Map<String,String> elem : books) {
                if (where.get("author").equals(elem.get("author")) && where.get("year").equals(elem.get("year"))){
                    resultList.add(elem);
                }
            }
            return resultList;
        }else {
            for(Map<String,String> elem : books) {
                if (where.get("author").equals(elem.get("author")) && where.get("year").equals(elem.get("year")) && where.get("title").equals(elem.get("title"))){
                    resultList.add(elem);
                }
            }
            return resultList;
        }
    }
}
//END
