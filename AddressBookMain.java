import java.util.ArrayList;
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

    public static void acceptData(Scanner sc, int i, List<AddressBook> list){
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
        AddressBook contact = new AddressBook(firstName, lastName, address, city, state, zip, phoneNo, email);
        list.add(i,contact);
    }

    public void toPrint(List<AddressBook> list) {
        for (AddressBook ad: list){
            System.out.println(ad.firstName+" "+ad.lastName+" "+ad.address+" "+ad.city+" "+ad.state+" "+ad.zip+" "+ad.phoneNo+" "+ad.email);
        }
    }
}

class AddressBookMain {
    static Scanner sc = new Scanner(System.in);

    public static void addContact(Scanner sc, AddNewContact addnew, List<AddressBook> list){
        System.out.print("No of Contacts to add:");
        int noOfContact = sc.nextInt();
        for(int i=0; i<noOfContact; i++) {
            addnew.acceptData(sc,i,list);
        }
        addnew.toPrint(list);
    }

    public static void main(String args[]){
        AddNewContact addnew = new AddNewContact();
        List<AddressBook> list = new ArrayList<AddressBook>();
        addContact(sc,addnew,list);
    }
}
