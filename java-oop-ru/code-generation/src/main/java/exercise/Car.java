package exercise;

import lombok.SneakyThrows;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    @SneakyThrows
    public String serialize(Car car) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(car);
    }
    @SneakyThrows
    public static Car unserialize(String string) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(string), Car.class);
    }
    // END
}
