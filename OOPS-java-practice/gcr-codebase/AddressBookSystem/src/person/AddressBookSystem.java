package person;

import java.util.HashMap;

public class AddressBookSystem {
	HashMap<String,AddressBook> BookName=new HashMap<>();
	
	public void addNewBook(String name,AddressBook addressbook) {
		BookName.put(name,addressbook);
	}
	
	public boolean searchBookName(String name) {
			if(BookName.containsKey(name))
				return true;
			else 
				return false;
		}
		
	public AddressBook getBook(String name) {
		return BookName.get(name);
	}

}
