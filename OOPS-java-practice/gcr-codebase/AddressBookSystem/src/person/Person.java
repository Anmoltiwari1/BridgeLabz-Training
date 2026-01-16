package person;

public class Person {
	private String FirstName;
	private String LastName;
	String address;
	String city;
	String state;
	String zip;
	String phoneNumber;
	String email;
	
	
	public String getFirstName() {
		return FirstName;
	}


	public void setFirstName(String firstName) {
		FirstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	public Person(String firstName, String lastName, String address, String city, String state, String zip,
			String phoneNumber, String email) {
		super();
		FirstName = firstName;
		LastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	
}
