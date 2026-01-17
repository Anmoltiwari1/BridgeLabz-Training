package person;

import java.util.ArrayList;


public class AddressBook {
	private ArrayList<Person> contacts=new ArrayList<>();
	
	public void addContact(Person person) {
		contacts.add(person);
	}
	
	public Person findContactByName(String firstName,String lastName) {
		for(Person person:contacts) {
			if(person.getFirstName().equalsIgnoreCase(firstName) && person.getLastName().equalsIgnoreCase(lastName)) {
				return person;
			}
		}
		return null;
	}
	
	public void displayContacts() {
		for(Person person:contacts) {
			System.out.println(person.getFirstName()+" "+person.getLastName());
			System.out.println("Address : "+person.getAddress());
			System.out.println("State : "+person.getState());
			System.out.println("City :"+person.getCity());
			System.out.println("Code :"+person.getZip());
			System.out.println("PhoneNumber :"+person.getPhoneNumber());
			System.out.println("Email :"+person.getEmail());
			System.out.println("DOB :"+person.getDOB());
			System.out.println("--------------------------");
		}
	}
}
