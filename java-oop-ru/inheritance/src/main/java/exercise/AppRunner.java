package exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AppRunner {
    public static void main(String[] args) {
        Tag img = new SingleTag("img", Map.of("class", "v-10", "id", "wop"));
        System.out.println(img); // "<img class="v-10" id="wop">



//        Tag p = new PairedTag("p", Map.of("id", "abc"), "Text paragraph", new ArrayList<Tag>());
//
//        System.out.println(p);
//
//        Tag div = new PairedTag(
//                "div",
//                Map.of("class", "y-5"),
//                "",
//                List.of(
//                        new SingleTag("br", Map.of("id", "s")),
//                        new SingleTag("hr", Map.of("class", "a-5"))
//                )
//        );
//
//        System.out.println(div.toString());
    }
}
