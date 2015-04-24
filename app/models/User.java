package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import play.data.validation.Constraints;
import play.db.ebean.*;

@Entity
public class User extends Model {

	private static final long serialVersionUID = 1L;
	
    @Id
    @Constraints.Required
    public String email;
    
    @Constraints.Required
    public String name;
    
    @Constraints.Required
    public String lastname;
    
    @Constraints.Required
    public String password;
    
    @Constraints.Required
    public String phonenumber;
    
    public String gender;
   
    @OneToMany(mappedBy = "user")
	public List<Address> address = new ArrayList<Address>();
  
    public static Model.Finder<String,User> find = new Model.Finder<String,User>(
        String.class, User.class
    ); 
}