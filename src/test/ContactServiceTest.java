package test;

import contact.Contact;
import contact.ContactService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.*;

public class ContactServiceTest {

    Contact contact1 = new Contact(
            "john.doe", "John", "Doe", "1234567890", "123 Main St");
    Contact contact2 = new Contact(
            "jane.doe", "Jane", "Doe", "0987654321", "123 Main St");

    @BeforeEach
    public void setUp() {
        ContactService.resetContacts();
        ContactService.addContact(contact1);
        ContactService.addContact(contact2);
    }
    @Test
    public void testAddContact() {
        setUp();

        // Create to contacts and confirm that their position matches their contactID
        assertEquals("john.doe", ContactService.getContacts()[1].getContactID());
        assertEquals("jane.doe", ContactService.getContacts()[0].getContactID());
    }

    @Test
    public void testAddContactAlreadyExists() {
        setUp();

        // Add a contact then try to add it again and confirm the exception is thrown
        Assertions.assertThrows(IllegalStateException.class, () -> {
            ContactService.addContact(contact1);
        });
    }

    @Test
    public void testUpdateContactFirstName() {
        setUp();

        // Add a contact then update its first name and confirm the change
        ContactService.updateContactFirstName("john.doe", "Johnathan");
        assertEquals("Johnathan", ContactService.getContacts()[1].getFirstName());
    }

    @Test
    public void testUpdateContactLastName() {
        setUp();

        // Add a contact then update its last name and confirm the change
        ContactService.updateLastName("john.doe", "Doeman");
        assertEquals("Doeman", ContactService.getContacts()[1].getLastName());
    }

    @Test
    public void testUpdateContactPhone() {
        setUp();

        // Add a contact then update its phone number and confirm the change
        ContactService.updatePhone("john.doe", "0987654321");
        assertEquals("0987654321", ContactService.getContacts()[0].getPhone());
    }

    @Test
    public void testUpdateContactAddress() {
        setUp();

        // Add a contact then update its address and confirm the change
        ContactService.updateAddress("john.doe", "123 Main St");
        assertEquals("123 Main St", ContactService.getContacts()[0].getAddress());
    }

    @Test
    public void testUpdateContactNotFound() {
        setUp();

        // Add a contact then try to update a contact that doesn't exist and confirm the exception is thrown
        Assertions.assertThrows(IllegalStateException.class, () -> {
            ContactService.updateContactFirstName("james.dawson", "James");
        });
    }

    @Test
    public void testRemoveContact() {
        setUp();

        // Add two contacts then remove the first and confirm its position is null
        ContactService.removeContact("john.doe");
        // Assert length of map is 1
        assertEquals(1, ContactService.getContacts().length);
    }

    @Test
    public void testRemoveContactNotFound() {
        setUp();

        // Add two contacts then try to remove a contact that doesn't exist and confirm the exception is thrown
        Assertions.assertThrows(IllegalStateException.class, () -> {
            ContactService.removeContact("james.dawson");
        });
    }

    @Test
    public void testResetContacts() {
        setUp();

        // Add two contacts then reset the contact list and confirm the list is empty
        ContactService.resetContacts();
        assertEquals(0, ContactService.getContacts().length);
    }
}
