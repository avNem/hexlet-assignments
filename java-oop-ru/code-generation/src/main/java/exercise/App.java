package exercise;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void main(String[] args) {
        Path path2 = Paths.get("/Users/lewade/Hexlet/hexlet-assignments/java-oop-ru/code-generation/src/test/resources/v1.json");
        Car car2 = App.extract(path2); // Возвращает инстанс класса Car
        System.out.println(car2.getModel());
    }


    public static void save(Path path, Car car) {
        try {
            Files.write(path, car.serialize(car).getBytes());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static Car extract(Path path) {
        return Car.unserialize(path.toString());
    }
}
// END
