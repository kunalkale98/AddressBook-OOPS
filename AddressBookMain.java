import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class AddressBook{

    public String firstName;
    public String lastName;
    public String address;
    public String city;
    public String state;
    public String zip;
    public String phoneNo;
    public String email;

    public AddressBook(String firstName, String lastName, String address, String city,
                       String state, String zip, String phoneNo, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNo = phoneNo;
        this.email = email;
    }
}

class AddNewContact {

    public static void acceptData(Scanner sc, HashMap<String,List<String>> addressBook){
        List<String> contact = new ArrayList<String>();
        System.out.print("First Name: ");
        String firstName = sc.next();
        System.out.print("Last Name: ");
        String lastName = sc.next();
        System.out.print("Address: ");
        String address = sc.next();
        System.out.print("City: ");
        String city = sc.next();
        System.out.print("State: ");
        String state = sc.next();
        System.out.print("Zip: ");
        String zip = sc.next();
        System.out.print("Phone No: ");
        String phoneNo = sc.next();
        System.out.print("Email: ");
        String email = sc.next();
        AddressBook ab = new AddressBook(firstName, lastName, address, city, state, zip, phoneNo, email);
        contact.add(ab.firstName);
        contact.add(ab.lastName);
        contact.add(ab.address);
        contact.add(ab.city);
        contact.add(ab.state);
        contact.add(ab.zip);
        contact.add(ab.phoneNo);
        contact.add(ab.email);
        addressBook.put(firstName,contact);
    }
}

class EditContact {
    public void editContactDetail(Scanner sc, AddressBookMain adm, HashMap<String,List<String>> addressBook) {
        System.out.print("Enter first name to edit: ");
        String editName = sc.next();
        List<String> list = addressBook.get(editName);
        int index = 0;
        while (true) {
            System.out.println("1. LastName \n2. Address \n3. City \n4. State \n5. Zip \n6. PhoneNo \n7. Email");
            System.out.print("Enter Index of the detail you want to edit: ");
            index = sc.nextInt();
            switch (index) {
                case 1:
                    System.out.print("Enter new LastName: ");
                    String newLastName = sc.next();
                    list.remove(1);
                    list.add(1, newLastName);
                    break;
                case 2:
                    System.out.print("Enter new Address: ");
                    String newAddress = sc.next();
                    list.remove(2);
                    list.add(2, newAddress);
                    break;
                case 3:
                    System.out.print("Enter new City: ");
                    String newCity = sc.next();
                    list.remove(3);
                    list.add(3, newCity);
                    break;
                case 4:
                    System.out.print("Enter new State: ");
                    String newState = sc.next();
                    list.remove(4);
                    list.add(4, newState);
                    break;
                case 5:
                    System.out.print("Enter new Zip: ");
                    String newZip = sc.next();
                    list.remove(5);
                    list.add(5, newZip);
                    break;
                case 6:
                    System.out.print("Enter new PhoneNo: ");
                    String newPhoneNo = sc.next();
                    list.remove(6);
                    list.add(6, newPhoneNo);
                    break;
                case 7:
                    System.out.print("Enter new Email: ");
                    String newEmail = sc.next();
                    list.remove(7);
                    list.add(7, newEmail);
                    break;
                default:
                    System.out.print("Please Enter Valid Index");
                    break;
            }
            System.out.print("Would you like to continue Y/N:");
            String input = sc.next();
            if(input.equals("n") || input.equals("N") || input.equals("No") || input.equals("no"))
                break;
        }
        addressBook.replace(editName,list);
        System.out.println("Updated Address Book");
        adm.toPrint(addressBook);
    }
}

public class AddressBookMain {
    static Scanner sc = new Scanner(System.in);

    public static void addContact(Scanner sc, AddNewContact addNew, HashMap<String,List<String>> addressBook){
        addNew.acceptData(sc,addressBook);
        toPrint(addressBook);
    }

   public static void editContact(Scanner sc, AddressBookMain adm, EditContact editContact, HashMap<String,List<String>> addressBook) {
      editContact.editContactDetail(sc, adm, addressBook);
   }

	public static void deleteContact(Scanner sc, HashMap<String,List<String>> addressBook){
       System.out.print("Enter first name to delete contact: ");
       String deleteContact = sc.next();
       addressBook.remove(deleteContact);
       System.out.println("Contact Successfully Deleted");
       toPrint(addressBook);
   }

    public static void toPrint(HashMap<String,List<String>> addressBook) {
        for (Map.Entry m : addressBook.entrySet()){
            System.out.println(m.getValue());
        }
    }

    public static void forChoice(Scanner sc, AddNewContact addNew, AddressBookMain adm, EditContact editContact, HashMap<String,List<String>> addressBook){
        while(true) {
            System.out.println("1. Add Contact \n2. Edit Contact \n3. Delete Contact \n4. Print AddressBook");
            System.out.print("Enter Index for operation to perform: ");
            int choice = sc.nextInt();
           	switch (choice) {
					 case 1:
                    addContact(sc, addNew, addressBook);
                    break;
					 case 2:
                    editContact(sc, adm, editContact, addressBook);
                    break;
					 case 3:
                    deleteContact(sc, addressBook);
                    break;
					 case 4:
                    toPrint(addressBook);
                    break;
					 default:
                    System.out.println("Please Enter Valid Input");
                    break;
            }
            System.out.print("Do you want to continue Y/N:");
            String ans = sc.next();
            if (ans.equals("No") || ans.equals("no") || ans.equals("N") || ans.equals("n"))
                break;
        }
    }

    public static void main(String args[]){
        AddressBookMain adm = new AddressBookMain();
        AddNewContact addNew = new AddNewContact();
        EditContact editContact = new EditContact();
        HashMap<String,List<String>> addressBook = new HashMap<String, List<String>>();
        addContact(sc,addNew,addressBook);
        forChoice(sc,addNew, adm, editContact,addressBook);
    }
}
