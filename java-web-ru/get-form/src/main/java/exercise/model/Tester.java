package exercise.model;

import exercise.Data;

import java.util.List;

public class Tester {
    private static final List<User> USERS = Data.getUsers();
    public static void main(String[] args) {

        User user = USERS.stream()
                .filter(e -> e.getFirstName().equalsIgnoreCase("Bobbi"))
                .findAny()
                .orElse(null);
        System.out.println(user);
    }
}
