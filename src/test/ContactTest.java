package test;

import contact.Contact;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.Assert.*;

// Test constructor values are set correctly
public class ContactTest {
    @Test
    public void testContact() {
        // Confirm that the constructor sets the values as expected
        Contact contact = new Contact(
                "john.doe", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("1234567890", contact.getContactID());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testNullContactID() {
        // Confirm that the constructor throws an exception when given a null contactID
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    null, "John", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testLongContactID() {
        // Confirm that the constructor throws an exception when given a contactID that is too long
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "john.doe", "John", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testNullFirstName() {
        // Confirm that the constructor throws an exception when given a null firstName
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "john.doe", null, "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testLongFirstName() {
        // Confirm that the constructor throws an exception when given a firstName that is too long
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "john.doe", "John Roger Doe",
                    "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testNullLastName() {
        // Confirm that the constructor throws an exception when given a null lastName
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "john.doe", "John", null, "1234567890", "123 Main St");
        });
    }

    @Test
    public void testLongLastName() {
        // Confirm that the constructor throws an exception when given a lastName that is too long
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "john.doe", "John", "John Roger Doe",
                    "01234567890", "123 Main St");
        });
    }

    @Test
    public void testNullPhone() {
        // Confirm that the constructor throws an exception when given a null phone
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "john.doe", "John", "Doe", null, "123 Main St");
        });
    }

    @Test
    public void testLongPhone() {
        // Confirm that the constructor throws an exception when given a phone that is too long
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "john.doe", "John", "Doe", "012345678901", "123 Main St");
        });
    }

    @Test
    public void testNullAddress() {
        // Confirm that the constructor throws an exception when given a null address
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "john.doe", "John", "Doe", "1234567890", null);
        });
    }

    @Test
    public void testLongAddress() {
        // Confirm that the constructor throws an exception when given an address that is too long
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "john.doe", "John", "Doe",
                    "1234567890", "123 Main St                                                      ");
        });
    }
}
