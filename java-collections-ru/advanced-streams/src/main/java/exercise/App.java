package exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
public class App {

    public static void main(String[] args) throws IOException {
        String content = Files.readString(Path.of("/resources/s.conf"));
        String result = getForwardedVariables(content);
        System.out.println(result);
    }

    public static String getForwardedVariables(String string) {

        return Arrays.stream(string.split("\n"))
                .map(x -> x.split(","))
                .flatMap(Arrays::stream)
                .filter(x -> x.contains("X_FORWARDED_") && (!x.contains("command")))
                .map(x -> x.substring(x.indexOf("X_FORWARDED_")).replace("X_FORWARDED_","").replace("\"", ""))
                .collect(Collectors.joining(","));
    }
}
//END
