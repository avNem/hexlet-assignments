package exercise;

import static exercise.App.take;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppTest {
    List<Integer> numbers;

    @BeforeEach
    void initList() {
        this.numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

    }


    @Test
    void testTake() {
        // BEGIN
        int expected = 2;
        Assertions.assertEquals(expected, take(numbers,2).size());
        // END
    }

}
