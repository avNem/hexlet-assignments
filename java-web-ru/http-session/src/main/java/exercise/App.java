package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            if(ctx.queryParamMap().size() == 0) {
                ctx.json(USERS.subList(0,5));
            }else{
                int page = ctx.queryParamAsClass("page", Integer.class).get(); //номер страницы
                int per = ctx.queryParamAsClass("per", Integer.class).get(); //кол-во записей
                ctx.json(USERS.subList((page * per) - per, page * per));
            }
        });
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
