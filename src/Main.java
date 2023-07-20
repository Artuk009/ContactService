/*
 * Author: Brent Artuch
 * Date: 2023-07-20
 * Section: CS-320-X6136
 */

import contact.Contact;
import contact.ContactService;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        // Create a new contact to add to the contact list
        Contact contact1 = new Contact(
                "john.doe", "John", "Doe",
                "1234567890", "123 Main St");
        System.out.println("New Contact: " + contact1);

        // Add the new contact to the contact list
        ContactService.addContact(contact1);

        // Print the contact list
        System.out.println("Contact List: ");
        System.out.println(Arrays.toString(ContactService.getContacts()));

        // Try to add a new contact to the contact list
        Contact contact2 = new Contact(
                "jane.doe", "Jane", "Doe",
                "0987654321", "123 Main St");

        // Add the new contact to the contact list
        ContactService.addContact(contact2);

        // Update the first name of the first contact
        ContactService.updateContactFirstName("john.doe", "Johnathan");

        // Update the last name of the first contact
        ContactService.updateLastName("john.doe", "Doeman");

        // Update the phone number of the first contact
        ContactService.updatePhone("john.doe", "0987654321");

        // Update the address of the first contact
        ContactService.updateAddress("john.doe", "123 Main St");

        System.out.println("Contact List: ");
        System.out.println(Arrays.toString(ContactService.getContacts()));

        // Try to remove a contact from the contact list
        ContactService.removeContact("john.doe");

        System.out.println("Contact List: ");
        System.out.println(Arrays.toString(ContactService.getContacts()));


    }
}