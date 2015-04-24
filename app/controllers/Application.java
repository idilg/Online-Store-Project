package controllers;

import static play.data.Form.form;

import java.util.ArrayList;
import java.util.List;

import models.User;
import play.*;
import play.data.Form;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    public static Result login() {
        return ok(login.render(form(Login.class))
        );
    }

    public static class Login {
	    public String email;
	    public String password;
	}
	
	public static Result authenticate() {
	    Form<Login> loginForm = form(Login.class).bindFromRequest();
	    if (loginForm.hasErrors()) {
	    	flash("error", "Login form has an error!");
	        return badRequest(login.render(loginForm));
	    } else {
	        session().clear();
	        List<User> userList = new ArrayList<User>();
	        userList = User.find.all();
	        for(int i=0; i<userList.size(); i++){
		        if(userList.get(i).email.equals(loginForm.get().email) && userList.get(i).password.equals(loginForm.get().password)){
		        	session("email", loginForm.get().email);
				    return ok(index.render("You are successfully logged in!"));
		        }
	        }
	        flash("error", "Invalid email or password!");
        	return badRequest(login.render(loginForm));
	    }
	}
}
