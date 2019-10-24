import static spark.Spark.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import model.model.User;
import model.persistence.impl.UserPersistenceImpl;
import spark.Request;
import spark.Response;

public class SslExample {

    // View example at https://localhost:4567/secureHello
    private static UserPersistenceImpl usp = new UserPersistenceImpl();

    public static void main(String[] args) {
        port(getPort());
        secure("deploy/clientKeystore.jks", "yohanna", null, null);
        get("/", (req, res) -> signinForm(req, res));
        post("/profile", (req, res) -> signIn(req, res));
        get("/signup", (req, res) -> signupForm(req, res));
        post("/signup", (req, res) -> signUp(req, res));
    }

    private static String getDate() {
        String date;
        try {
            URL url = new URL("https://localhost:4567/sercureServer");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            date = br.readLine();

        } catch (Exception e) {
            date = "conection fail";
        }
        return date;

    }
    private static String signUp(Request req, Response res){
        System.out.println("hi");
        String email = req.queryParams("email");
        String name=req.queryParams("name");
        String pass= req.queryParams("password");
        usp.create(new User(name,email,pass));
       res.redirect("/");
       return "done";
    }
    private static String signIn(Request req,Response res){

        String email = req.queryParams("email");
        String password = req.queryParams("password");
        User tmp= usp.getUserByemail(email);
       if (!(email.equals(tmp.getEmail()) && password.equals(tmp.getPassword()))){
           res.redirect("/");
           return "bad credentials";
       }

        return "<!DOCTYPE html>" + "<html lang=\"en\">" + "<head>" + "    <meta charset=\"UTF-8\">"
        + "    <title>User Profile</title>" +"<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">" +"</head>" + "<body>" 
        +"<div class=\"card container\">"+"<h1>Yohanna Toro</h1>"+
        "<p class=\"title\">Front end Developer, Example</p>"+
        "<p>Escuela Colmbiana de ingenieria julo Garavito</p>"+
        "<a href=\"#\"><i class=\"fa fa-dribbble\"></i></a>"
        +"<a href=\"#\"><i class=\"fa fa-twitter\"></i></a>"+"<p><button>Contact</button></p>"
        +"<img src=\"https://www.drupal.org/files/user-pictures/picture-553728-1528379956.png\" alt=\"John\" style=\"width:100%\">"
        +"</div>" 
        + "</body>" + "</html>";
    }
    private static String  signupForm(Request req, Response res){
         
        return "<!DOCTYPE html>" + "<html lang=\"en\">" + "<head>" + "    <meta charset=\"UTF-8\">"
        + "    <title>Sign up</title>" + "</head>" + "<body>" + "    <form action=\"/signup\" method=\"POST\">"
        + "        name<br>" + "        <input type=\"text\" name=\"name\"><br>"
        + "        email<br>" + "        <input type=\"text\" name=\"email\"><br>" + "        password<br>"
        + "        <input type=\"password\" name=\"password\" ><br><br>"
        + "        <button type=\"/submit\">Sign up</button>" + " <label>"
        + " <input type=\"checkbox\" checked=\"checked\" name=\"remember\"> Remember me" + "</label>"
        + "    </form><br><br>" + "  <div class=\"container\" style=\"background-color:#f1f1f1\">"
        +"<span >Forgot <a href=\"/signup\">password?</a></span>"
        + "</div>" + "</body>" + "</html>";
    }
    private static int getPort() {
        int port = 4567; // default port if heroku-port isn't set
        if (System.getenv("PORT") != null) {
            port = Integer.parseInt(System.getenv("PORT"));
        }
        return port;
    }

    private static String signinForm(Request req, Response res) {

        return "<!DOCTYPE html>" + "<html lang=\"en\">" + "<head>" + "    <meta charset=\"UTF-8\">"
                + "    <title>Sign up</title>" + "</head>" + "<body>" + "    <form action=\"/profile\" method=\"POST\">"
                + "        email<br>" + "        <input type=\"text\" name=\"email\"><br>" + "        password<br>"
                + "        <input type=\"password\" name=\"password\" ><br><br>"
                + "        <button type=\"/submit\">Login</button>" + " <label>"
                + " <input type=\"checkbox\" checked=\"checked\" name=\"remember\"> Remember me" + "</label>"
                + "    </form><br><br>" + "  <div class=\"container\" style=\"background-color:#f1f1f1\">"
                + "<button type=\"button\">Register</button>" + "<span >not a  <a href=\"/signup\">member?</a></span>"
                + "</div>" + "</body>" + "</html>";

    }

}
