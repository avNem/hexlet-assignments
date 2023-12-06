package exercise;

import exercise.model.User;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class Tester {
    private static final List<User> USERS = Data.getUsers();

    public static void main(String[] args) {

        var user = USERS.stream()
                .filter(e -> StringUtils.startsWithIgnoreCase(e.getFirstName(), "s"))
                .toList();

        System.out.println(user);
    }
}
