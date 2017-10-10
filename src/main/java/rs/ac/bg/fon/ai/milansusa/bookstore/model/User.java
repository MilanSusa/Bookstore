package rs.ac.bg.fon.ai.milansusa.bookstore.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String password;
	private boolean active;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private Set<Role> roles;

	public User() {
		roles = new HashSet<>();
	}

	public User(int id, String name, String password, String email, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.active = active;
	}

	public User(User user) {
		super();
		this.id = user.getId();
		this.name = user.getName();
		this.password = user.getPassword();
		this.active = user.isActive();
		this.roles = user.getRoles();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
