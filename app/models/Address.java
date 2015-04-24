package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints;
import play.db.ebean.Model;
@Entity
public class Address {
private static final long serialVersionUID = 1L;
	
	@Id
    public long id;
	
	@Constraints.Required
    public String address;
    
    @ManyToOne
	public User user;
    
    public static Model.Finder<Long,Address> find = new Model.Finder<Long,Address>(Long.class, Address.class);

}
