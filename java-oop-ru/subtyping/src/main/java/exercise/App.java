package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static void main(String[] args) {
        KeyValueStorage storage = new InMemoryKV(Map.of("key", "value", "key2", "value2"));
        App.swapKeyValue(storage);
        System.out.println(storage.get("key", "default")); // "default"
        System.out.println(storage.get("value", "default")); // "key"

        System.out.println(storage.toMap()); // => {value=key, value2=key2}
    }
    public static void swapKeyValue(KeyValueStorage map) {
        Map<String, String> data = map.toMap();
        Set<Entry<String, String>> entries = data.entrySet();
        entries.forEach(entry -> map.unset(entry.getKey()));
        entries.forEach(entry -> map.set(entry.getValue(), entry.getKey()));
    }
}
// END