package exercise;

import io.javalin.Javalin;
import java.util.List;
import exercise.model.User;
import exercise.dto.users.UsersPage;
import java.util.Collections;
import java.util.stream.Collectors;

import io.javalin.http.NotFoundResponse;
import org.apache.commons.lang3.StringUtils;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx->{
            var term = ctx.queryParam("term");
            if(term != null) {
                System.out.println(term);
                var user = USERS.stream()
                        .filter(e -> StringUtils.startsWithIgnoreCase(e.getFirstName(), term))
                        .toList();

                if (user == null) {
                    throw new NotFoundResponse("User not found");
                }
                var page = new UsersPage(user, term);
                ctx.render("users/index.jte", Collections.singletonMap("page", page));

            }else {
                ctx.json(USERS);
                var page = new UsersPage(USERS, term);
                ctx.render("users/index.jte", Collections.singletonMap("page", page));
            }

        });

        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
