package rs.ac.bg.fon.ai.milansusa.bookstore.model;

import java.util.HashSet;
import java.util.Set;

import rs.ac.bg.fon.ai.milansusa.bookstore.model.enums.Gender;

public class Author {

	private long id;
	private String firstName;
	private String lastName;
	private Gender gender;
	private Set<Book> books = new HashSet<>();

	public Author() {

	}

	public Author(long id, String firstName, String lastName, Gender gender) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", gender=" + gender + "]";
	}

}
