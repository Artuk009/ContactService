package contact;

import java.util.Arrays;
import java.util.Objects;

public class ContactService {

    private static final Contact[] contacts = new Contact[10];

    // Method to add a contact to the contact list if there is space
    public static void addContact(Contact contact) {
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] == null) {
                contacts[i] = contact;
                return;
            }
            if (Objects.equals(contacts[i].getContactID(), contact.getContactID())) {
                throw new IllegalStateException("Contact already exists");
            }
        }
        throw new IllegalStateException("Contact list is full");
    }

    // Method to change the first name of a contact by contact ID
    public static void updateContactFirstName(String contactID, String firstName) {
        for (Contact contact : contacts) {
            if (contact != null && contact.getContactID().equals(contactID)) {
                contact.setFirstName(firstName);
                return;
            }
        }
        throw new IllegalStateException("Contact not found");
    }

    // Method to change the last name of a contact by contact ID
    public static void updateLastName(String contactID, String lastName) {
        for (Contact contact : contacts) {
            if (contact != null && contact.getContactID().equals(contactID)) {
                contact.setLastName(lastName);
                return;
            }
        }
        throw new IllegalStateException("Contact not found");
    }

    // Method to change the phone number of a contact by contact ID
    public static void updatePhone(String contactID, String phone) {
        for (Contact contact : contacts) {
            if (contact != null && contact.getContactID().equals(contactID)) {
                contact.setPhone(phone);
                return;
            }
        }
        throw new IllegalStateException("Contact not found");
    }

    // Method to change the address of a contact by contact ID
    public static void updateAddress(String contactID, String address) {
        for (Contact contact : contacts) {
            if (contact != null && contact.getContactID().equals(contactID)) {
                contact.setAddress(address);
                return;
            }
        }
        throw new IllegalStateException("Contact not found");
    }

    // Method to remove a contact from the contact list by contact ID
    public static void removeContact(String contactID) {
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] != null && contacts[i].getContactID().equals(contactID)) {
                contacts[i] = null;
                return;
            }
        }
        throw new IllegalStateException("Contact not found");
    }

    public static Contact[] getContacts() {
        return contacts;
    }

    // This method resets the application to its initial state for testing purposes
    public static void resetContacts() {
        for (int i = 0; i < contacts.length; i++) {
            contacts[i] = null;
        }
    }

    @Override
    public String toString() {
        return "ContactService{" + "contacts=" + Arrays.toString(contacts) + '}';
    }
}
