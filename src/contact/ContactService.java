package contact;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContactService {

    // Create a map to store contacts
    private static final Map<String, Contact> contacts = new HashMap<>();

    // Method to add a contact to the contact list if there is space
    public static void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactID())) {
            throw new IllegalStateException("Contact already exists");
        }
        contacts.put(contact.getContactID(), contact);
    }

    // Method to change the first name of a contact by contact ID
    public static void updateContactFirstName(String contactID, String firstName) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalStateException("Contact not found");
        }
        contact.setFirstName(firstName);
    }

    // Method to change the last name of a contact by contact ID
    public static void updateLastName(String contactID, String lastName) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalStateException("Contact not found");
        }
        contact.setLastName(lastName);
    }

    // Method to change the phone number of a contact by contact ID
    public static void updatePhone(String contactID, String phone) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalStateException("Contact not found");
        }
        contact.setPhone(phone);
    }

    // Method to change the address of a contact by contact ID
    public static void updateAddress(String contactID, String address) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalStateException("Contact not found");
        }
        contact.setAddress(address);
    }

    // Method to remove a contact from the contact list by contact ID
    public static void removeContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalStateException("Contact not found");
        }
        contacts.remove(contactID);
    }

    public static Contact[] getContacts() {
        return contacts.values().toArray(new Contact[0]);
    }

    // This method resets the application to its initial state for testing purposes
    public static void resetContacts() {
        contacts.clear();
    }

    @Override
    public String toString() {
        return "ContactService{" +
                "contacts=" + Arrays.toString(getContacts()) +
                '}';
    }
}
