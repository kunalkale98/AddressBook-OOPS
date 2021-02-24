import java.util.Scanner;

class AddressBook{

	private final String firstName;
	private final String lastName;
	private final String city;
	private final String state;
	private final int zip;
	private final long phoneNo;
	//private final String email;

	public AddressBook(String firstName, String lastName, String city,
								String state, int zip, long phoneNo){
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNo = phoneNo;
		//this.email = email;
	}

	public void toString(String firstName, String lastName, String city,
                        String state, int zip, long phoneNo){
		System.out.println(firstName+" , "+lastName+" , "+city+" , "+state+" , "
					+zip+" , "+phoneNo);
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
      System.out.print("First Name: ");
      String fn = sc.nextLine();
      System.out.print("Last Name: ");
      String ln = sc.nextLine();
      System.out.print("City: ");
      String city = sc.nextLine();
      System.out.print("State: ");
      String state = sc.nextLine();
      System.out.print("Zip: ");
      int zip = sc.nextInt();
      //System.out.print("Email: ");
      //String eml = sc.nextLine();
		System.out.print("Phone No: ");
      long pn = sc.nextLong();
		AddressBook ab = new AddressBook(fn,ln,city,state,zip,pn);
		ab.toString(ab.firstName,ab.lastName,ab.city,ab.state,ab.zip,ab.phoneNo);
	}
}
