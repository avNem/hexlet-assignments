package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;


// BEGIN
public class App {
    public static void main(String[] args) {

    }


    public static void save(Path path, Car car) {
        try {

            Files.write(path, car.serialize(car).getBytes());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static Car extract(Path path) throws IOException {
        return Car.unserialize(path.toString());
    }
}
// END
