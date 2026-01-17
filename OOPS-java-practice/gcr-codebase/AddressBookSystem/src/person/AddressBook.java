package person;

import java.util.ArrayList;


public class AddressBook {
	private ArrayList<Person> contacts=new ArrayList<>();
	
	public void addContact(Person person) {
		contacts.add(person);
	}
	
	public void displayContacts() {
		for(Person person:contacts) {
			System.out.println(person.getFirstName()+" "+person.getLastName());
		}
	}
}
