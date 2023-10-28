package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
class App {
    public static void main(String[] args) {

    }

    public static long getCountOfFreeEmails(List<String> list) {
        return list.stream()
                .filter(elem -> elem.contains("@gmail.com") || elem.contains("@yandex.ru") || elem.contains("@hotmail.com"))
                .count();
    }
}
// END
