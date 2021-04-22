package mobile;

public class Contact {

  private static final String START = "START";
  private static final String START_NUM = "1234567890";
  private String contactId;
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String streetAddress;

  public Contact() {
	this.contactId = START;
	this.firstName = START;
	this.lastName = START;
	this.phoneNumber = START_NUM;
	this.streetAddress = START;
  }

  public Contact(String contactId) {
    updateContactId(contactId);
    this.firstName = START;
    this.lastName = START;
    this.phoneNumber = START_NUM;
    this.streetAddress = START;
  }

  public Contact(String contactId, String firstName) {
    updateContactId(contactId);
    updateFirstName(firstName);
    this.lastName = START;
    this.phoneNumber = START_NUM;
    this.streetAddress = START;
  }

  public Contact(String contactId, String firstName, String lastName) {
    updateContactId(contactId);
    updateFirstName(firstName);
    updateLastName(lastName);
    this.phoneNumber = START_NUM;
    this.streetAddress = START;
  }

  public Contact(String contactId, String firstName, String lastName, String phoneNumber) {
    updateContactId(contactId);
    updateFirstName(firstName);
    updateLastName(lastName);
    updatePhoneNumber(phoneNumber);
    this.streetAddress = START;
  }

  public Contact(String contactId, String firstName, String lastName, String phoneNumber, String streetAddress) {
    updateContactId(contactId);
    updateFirstName(firstName);
    updateLastName(lastName);
    updatePhoneNumber(phoneNumber);
    updateAddress(streetAddress);
  }

  public String getContactId() { 
	 return contactId;
  }

  public String getFirstName() {
	 return firstName;
  }

  public String getLastName() {
	 return lastName;
  }

  public String getPhoneNumber() {
	 return phoneNumber;
   }

  public String getAddress() {
	  return streetAddress;
  }

  public void updateContactId(String contactId) {
      if (contactId == null || contactId.length() > 10 ) {
	     throw new IllegalArgumentException("Invalid contact ID");
	  } else {
	     this.contactId = contactId;
	  }
  }
  
  public void updateFirstName(String firstName) {
    if (firstName == null || firstName.length()>10) {
      throw new IllegalArgumentException("Invalid first name");
    } else {
      this.firstName = firstName;
    }
  }

  public void updateLastName(String lastName) {
    if (lastName == null || lastName.length() > 10) {
      throw new IllegalArgumentException("Invalid last name");
    } else {
      this.lastName = lastName;
    }
  }

  public void updatePhoneNumber(String phoneNumber) {
	    String numeric = "[0-9]+";
	    if (phoneNumber == null || phoneNumber.length() != 10 ||
	    		!phoneNumber.matches(numeric)) {
	      throw new IllegalArgumentException("Invalid phone number");
	    } else {
	      this.phoneNumber = phoneNumber;
	    }
	  }

  public void updateAddress(String streetAddress) {
    if (streetAddress == null || streetAddress.length() > 30) {
      throw new IllegalArgumentException("Invalid address");
    } else {
      this.streetAddress = streetAddress;
    }
  }
}