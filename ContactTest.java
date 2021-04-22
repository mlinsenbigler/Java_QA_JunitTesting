package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mobile.Contact;

public class ContactTest {
  protected String testId, testFirstName, testLastName, testNumber,
      testAddress;
  protected String testTooLongId, testTooLongFirstName, testTooLongLastName,
      testTooLongNumber, testTooShortNumber, testTooLongAddress;

  @BeforeEach
  void setUp() {
    testId = "987654321";
    testFirstName = "Michael";
    testLastName = "Bigler";
    testNumber = "4125559192";
    testAddress = "123 Sesame St Pgh PA 12345";
    testTooLongId = "12345678901234567890";
    testTooLongFirstName = "MrMichaelDl";
    testTooLongLastName = "Linsenbigler";
    testTooLongNumber = "14125559192";
    testTooShortNumber = "412555919";
    testTooLongAddress = "123 Sesame Stovertheriverandthroughthewoods Pgh PA 12345";
  }

  @Test
  void contactTest() {
    Contact contact = new Contact();
    assertAll("constructor",
              ()
                  -> assertNotNull(contact.getContactId()),
              ()
                  -> assertNotNull(contact.getFirstName()),
              ()
                  -> assertNotNull(contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void contactIdConstructorTest() {
    Contact contact = new Contact(testId);
    assertAll("constructor one",
              ()
                  -> assertEquals(testId, contact.getContactId()),
              ()
                  -> assertNotNull(contact.getFirstName()),
              ()
                  -> assertNotNull(contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void contactIdAndFirstNameConstructorTest() {
    Contact contact = new Contact(testId, testFirstName);
    assertAll("constructor two",
              ()
                  -> assertEquals(testId, contact.getContactId()),
              ()
                  -> assertEquals(testFirstName, contact.getFirstName()),
              ()
                  -> assertNotNull(contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void contactIdAndFullNameConstructorTest() {
    Contact contact = new Contact(testId, testFirstName, testLastName);
    assertAll("constructor three",
              ()
                  -> assertEquals(testId, contact.getContactId()),
              ()
                  -> assertEquals(testFirstName, contact.getFirstName()),
              ()
                  -> assertEquals(testLastName, contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void contactIdFullNamePhoneNumberConstructorTest() {
    Contact contact =
        new Contact(testId, testFirstName, testLastName, testNumber);
    assertAll("constructor four",
              ()
                  -> assertEquals(testId, contact.getContactId()),
              ()
                  -> assertEquals(testFirstName, contact.getFirstName()),
              ()
                  -> assertEquals(testLastName, contact.getLastName()),
              ()
                  -> assertEquals(testNumber, contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void everythingConstructorTest() {
    Contact contact = new Contact(testId, testFirstName, testLastName, testNumber, testAddress);
    assertAll("constructor all",
              ()
                  -> assertEquals(testId, contact.getContactId()),
              ()
                  -> assertEquals(testFirstName, contact.getFirstName()),
              ()
                  -> assertEquals(testLastName, contact.getLastName()),
              ()
                  -> assertEquals(testNumber, contact.getPhoneNumber()),
              () -> assertEquals(testAddress, contact.getAddress()));
  }

  @Test
  void updateFirstNameTest() {
    Contact contact = new Contact();
    contact.updateFirstName(testFirstName);
    assertAll(
        "first name",
        ()
            -> assertEquals(testFirstName, contact.getFirstName()),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateFirstName(null)),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateFirstName(testTooLongFirstName)));
  }

  @Test
  void updateLastNameTest() {
    Contact contact = new Contact();
    contact.updateLastName(testLastName);
    assertAll(
        "last name",
        ()
            -> assertEquals(testLastName, contact.getLastName()),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateLastName(null)),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateLastName(testTooLongFirstName)));
  }

  @Test
  void updatePhoneNumberTest() {
    Contact contact = new Contact();
    contact.updatePhoneNumber(testNumber);
    assertAll("phone number",
              ()
                  -> assertEquals(testNumber, contact.getPhoneNumber()),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                                  () -> contact.updatePhoneNumber(null)),
              ()
                  -> assertThrows(
                      IllegalArgumentException.class,
                      () -> contact.updatePhoneNumber(testTooLongNumber)),
              ()
                  -> assertThrows(
                      IllegalArgumentException.class,
                      () -> contact.updatePhoneNumber(testTooShortNumber)),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                                  () -> contact.updatePhoneNumber(testId)));
  }

  @Test
  void updateAddressTest() {
    Contact contact = new Contact();
    contact.updateAddress(testAddress);
    assertAll("address",
              ()
                  -> assertEquals(testAddress, contact.getAddress()),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                                  () -> contact.updateAddress(null)),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                                  () -> contact.updateAddress(testTooLongAddress)));
  }

  @Test
  void updateContactIdTest() {
    Contact contact = new Contact();
    contact.updateContactId(testId);
    assertAll(
        "contact ID",
        ()
            -> assertEquals(testId, contact.getContactId()),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateContactId(null)),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateContactId(testTooLongId)));
  }
}