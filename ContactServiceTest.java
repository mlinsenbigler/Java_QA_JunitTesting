package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mobile.ContactService;

public class ContactServiceTest {
  protected String testId, testFirstName, testLastName, testPhoneNumber,
      testAddress;
  protected String testTooLongId, testTooLongFirstName, testTooLongLastName,
      testTooLongPhoneNumber, testTooShortPhoneNumber, testTooLongAddress;

  @BeforeEach
  void setUp() {
	  testId = "987654321";
	  testFirstName = "Michael";
	  testLastName = "Bigler";
	  testPhoneNumber = "4125559192";
	  testAddress = "123 Sesame St Pgh PA 12345";
	  testTooLongId = "12345678901234567890";
	  testTooLongFirstName = "MrMichaelDl";
	  testTooLongLastName = "Linsenbigler";
	  testTooLongPhoneNumber = "14125559192";
	  testTooShortPhoneNumber = "412555919";
	  testTooLongAddress = "123 Sesame Stovertheriverandthroughthewoods Pgh PA 12345";
  }

  @Test
  void newContactTest() {
    ContactService service = new ContactService();
    service.newContact();
    assertAll(
        "service",
        ()
            -> assertNotNull(service.getContactList().get(0).getContactId()),
        ()
            -> assertEquals("START",
                            service.getContactList().get(0).getFirstName()),
        ()
            -> assertEquals("START",
                            service.getContactList().get(0).getLastName()),
        ()
            -> assertEquals("1234567890",
                            service.getContactList().get(0).getPhoneNumber()),
        ()
            -> assertEquals("START",
                            service.getContactList().get(0).getAddress()));
    service.newContact(testFirstName);
    assertAll(
        "service",
        ()
            -> assertNotNull(service.getContactList().get(1).getContactId()),
        ()
            -> assertEquals(testFirstName,
                            service.getContactList().get(1).getFirstName()),
        ()
            -> assertEquals("START",
                            service.getContactList().get(1).getLastName()),
        ()
            -> assertEquals("1234567890",
                            service.getContactList().get(1).getPhoneNumber()),
        ()
            -> assertEquals("START",
                            service.getContactList().get(1).getAddress()));
    service.newContact(testFirstName, testLastName);
    assertAll(
        "service",
        ()
            -> assertNotNull(service.getContactList().get(2).getContactId()),
        ()
            -> assertEquals(testFirstName,
                            service.getContactList().get(2).getFirstName()),
        ()
            -> assertEquals(testLastName,
                            service.getContactList().get(2).getLastName()),
        ()
            -> assertEquals("1234567890",
                            service.getContactList().get(2).getPhoneNumber()),
        ()
            -> assertEquals("START",
                            service.getContactList().get(2).getAddress()));
    service.newContact(testFirstName, testLastName, testPhoneNumber);
    assertAll(
        "service",
        ()
            -> assertNotNull(service.getContactList().get(3).getContactId()),
        ()
            -> assertEquals(testFirstName,
                            service.getContactList().get(3).getFirstName()),
        ()
            -> assertEquals(testLastName,
                            service.getContactList().get(3).getLastName()),
        ()
            -> assertEquals(testPhoneNumber,
                            service.getContactList().get(3).getPhoneNumber()),
        ()
            -> assertEquals("START",
                            service.getContactList().get(3).getAddress()));
    service.newContact(testFirstName, testLastName, testPhoneNumber,
                       testAddress);
    assertAll(
        "service",
        ()
            -> assertNotNull(service.getContactList().get(4).getContactId()),
        ()
            -> assertEquals(testFirstName,
                            service.getContactList().get(4).getFirstName()),
        ()
            -> assertEquals(testLastName,
                            service.getContactList().get(4).getLastName()),
        ()
            -> assertEquals(testPhoneNumber,
                            service.getContactList().get(4).getPhoneNumber()),
        ()
            -> assertEquals(testAddress,
                            service.getContactList().get(4).getAddress()));
  }

  @Test
  void deleteContactTest() {
    ContactService service = new ContactService();
    service.newContact();
    assertThrows(Exception.class, () -> service.deleteContact(testId));
    assertAll(()
                  -> service.deleteContact(
                      service.getContactList().get(0).getContactId()));
  }

  @Test
  void updateFirstNameTest() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.updateFirstName(service.getContactList().get(0).getContactId(),
                            testFirstName);
    assertEquals(testFirstName, service.getContactList().get(0).getFirstName());
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateFirstName(
                         service.getContactList().get(0).getContactId(),
                         testTooLongFirstName));
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateFirstName(
                         service.getContactList().get(0).getContactId(), null));
    assertThrows(Exception.class,
                 () -> service.updateFirstName(testId, testFirstName));
  }

  @Test
  void updateLastNameTest() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.updateLastName(service.getContactList().get(0).getContactId(),
                           testLastName);
    assertEquals(testLastName, service.getContactList().get(0).getLastName());
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateLastName(
                         service.getContactList().get(0).getContactId(),
                         testTooLongLastName));
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateLastName(
                         service.getContactList().get(0).getContactId(), null));
    assertThrows(Exception.class,
                 () -> service.updateLastName(testId, testLastName));
  }

  @Test
  void updatePhoneNumberTest() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.updatePhoneNumber(service.getContactList().get(0).getContactId(),
                              testPhoneNumber);
    assertEquals(testPhoneNumber,
                 service.getContactList().get(0).getPhoneNumber());
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updatePhoneNumber(
                         service.getContactList().get(0).getContactId(),
                         testTooLongPhoneNumber));
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updatePhoneNumber(
                         service.getContactList().get(0).getContactId(),
                         testTooShortPhoneNumber));
    assertThrows(
        IllegalArgumentException.class,
        ()
            -> service.updatePhoneNumber(
                service.getContactList().get(0).getContactId(), testId));
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updatePhoneNumber(
                         service.getContactList().get(0).getContactId(), null));
    assertThrows(Exception.class,
                 () -> service.updatePhoneNumber(testId, testLastName));
  }

  @Test
  void updateAddressTest() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.updateAddress(service.getContactList().get(0).getContactId(),
                          testAddress);
    assertEquals(testAddress, service.getContactList().get(0).getAddress());
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateAddress(
                         service.getContactList().get(0).getContactId(),
                         testTooLongAddress));
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateAddress(
                         service.getContactList().get(0).getContactId(), null));
    assertThrows(Exception.class,
                 () -> service.updateAddress(testId, testAddress));
  }
}