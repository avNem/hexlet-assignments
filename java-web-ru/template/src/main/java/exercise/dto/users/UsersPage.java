package exercise.dto.users;

import exercise.model.User;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

// BEGIN
public class UsersPage {
    public UsersPage(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    private List<User> users;
}
// END
