package person;

import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        boolean run = true;

        while (run) {
            System.out.println("\n===== ADDRESS BOOK MENU =====");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Display Contacts");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    // ADD CONTACT (UC2)
                    System.out.println("\nEnter contact details");

                    System.out.print("First Name: ");
                    String firstName = sc.nextLine();

                    System.out.print("Last Name: ");
                    String lastName = sc.nextLine();

                    System.out.print("Address: ");
                    String address = sc.nextLine();

                    System.out.print("City: ");
                    String city = sc.nextLine();

                    System.out.print("State: ");
                    String state = sc.nextLine();

                    System.out.print("Zip: ");
                    String zip = sc.nextLine();

                    System.out.print("Phone Number: ");
                    String phoneNumber = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("DOB: ");
                    String dob = sc.nextLine();

                    Person person = new Person(
                            firstName, lastName, address,
                            city, state, zip, phoneNumber, email
                    );
                    person.setDOB(dob);

                    addressBook.addContact(person);
                    System.out.println("Contact added successfully.");
                    break;

                case 2:
                    // EDIT CONTACT (UC3)
                    System.out.print("\nEnter First Name to edit: ");
                    String editFirstName = sc.nextLine();

                    System.out.print("Enter Last Name to edit: ");
                    String editLastName = sc.nextLine();

                    Person existingPerson =
                            addressBook.findContactByName(editFirstName, editLastName);

                    if (existingPerson == null) {
                        System.out.println("Contact not found.");
                    } else {
                        System.out.println("Enter new details");

                        System.out.print("New Address: ");
                        existingPerson.setAddress(sc.nextLine());

                        System.out.print("New City: ");
                        existingPerson.setCity(sc.nextLine());

                        System.out.print("New State: ");
                        existingPerson.setState(sc.nextLine());

                        System.out.print("New Zip: ");
                        existingPerson.setZip(sc.nextLine());

                        System.out.print("New Phone Number: ");
                        existingPerson.setPhoneNumber(sc.nextLine());

                        System.out.print("New Email: ");
                        existingPerson.setEmail(sc.nextLine());

                        System.out.print("New DOB: ");
                        existingPerson.setDOB(sc.nextLine());

                        System.out.println("Contact updated successfully.");
                    }
                    break;

                case 3:
                    // DISPLAY CONTACTS
                    addressBook.displayContacts();
                    break;
                    
                case 4:
                	//Delete the Contact
                	System.out.println("Enter the first name");
                	String firstName=sc.nextLine();
                	
                	System.out.println("Enter the last name");
                	String lastName=sc.nextLine();
                	
                	
                case 5:
                    // EXIT
                    run = false;
                    System.out.println("Exiting Address Book.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }
}
