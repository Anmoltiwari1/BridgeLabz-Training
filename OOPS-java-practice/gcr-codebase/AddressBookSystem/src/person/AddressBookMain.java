package person;

import java.util.*;
 // uc2 completed
public class AddressBookMain {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		AddressBook addressBook=new AddressBook();
		
		System.out.println("Enter the first name");
		String firstName=sc.nextLine();
		
		System.out.println("Enter the last name");
		String lastName=sc.nextLine();
		
		System.out.println("Enter the address");
		String address=sc.nextLine();
		
		System.out.println("Enter the state");
		String state=sc.nextLine();
		
		System.out.println("Enter the city");
		String city=sc.nextLine();
		
		System.out.println("Enter the zip");
		String zip=sc.nextLine();
		
		System.out.println("Enter the phone number");
		String phoneNumber=sc.nextLine();
		
		System.out.println("Enter the email");
		String email=sc.nextLine();
		
		System.out.println("Enter the DOB");
		String DOB=sc.nextLine();
		
		Person person=new Person(firstName,lastName,address,city,state,zip,phoneNumber,email);
		
		addressBook.addContact(person);
		
		System.out.println("Contact added successfully");
	}
}
