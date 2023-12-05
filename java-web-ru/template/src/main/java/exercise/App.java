package exercise;

import io.javalin.Javalin;
import java.util.List;
import io.javalin.http.NotFoundResponse;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import java.util.Collections;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/users", ctx -> {
            var page = new UsersPage(USERS);
            ctx.render("users/index.jte", Collections.singletonMap("page", page));
        });

        app.get("/users/{id}", ctx -> {
            int id = ctx.pathParamAsClass("id", Integer.class).get();
            var us = USERS.stream()
                    .filter(e -> e.getId() == id)
                    .findFirst()
                    .orElse(null);
            if (us == null) {
                throw new NotFoundResponse("User not found");
            }
            var page = new UserPage(us);
            ctx.render("users/show.jte", Collections.singletonMap("page", page));
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
