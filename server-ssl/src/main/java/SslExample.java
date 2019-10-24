import static spark.Spark.*;

import java.util.Date;

public class SslExample {

    // View example at https://localhost:4567/secureHello

    public static void main(String[] args) {
        port(getPort());
        secure("deploy/serverKeystore.jks", "yohanna", null, null);
        String date= new Date().toString();
        get("/secureHello", (req, res) -> date);
    }
    private static int getPort() {
        int port = 4567; //default port if heroku-port isn't set
        if (System.getenv("PORT") != null) {
            port = Integer.parseInt(System.getenv("PORT"));
        }
        return port;
    }

}
