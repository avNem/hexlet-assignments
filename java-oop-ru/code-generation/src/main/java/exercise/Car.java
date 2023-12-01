package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.SneakyThrows;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

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

    public String serialize(Car car) throws JsonProcessingException {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(car);

    }

    public static Car unserialize(String string) throws IOException {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(new File(string), Car.class);
    }
    // END
}
