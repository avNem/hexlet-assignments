package exercise.dto.users;

import exercise.model.User;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

// BEGIN
public class UsersPage {
    private List<User> users;
    private String term;

    public UsersPage(List<User> users, String term) {
        this.term = term;
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public String getTerm() {
        return term;
    }
}
// END
