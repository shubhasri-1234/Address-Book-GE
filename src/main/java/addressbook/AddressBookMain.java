package addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Address Book Menu:");
            System.out.println("1. Add a new contact");
            System.out.println("2. Edit an existing contact");
            System.out.println("3. Delete a contact");
            System.out.println("4. Display all contacts");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addressBook.addContact();
                    break;
                case 2:
                    System.out.print("Enter the first name of the contact to edit: ");
                    String firstNameToEdit = scanner.nextLine();
                    addressBook.editContact(firstNameToEdit);
                    break;
                case 3:
                    System.out.print("Enter the first name of the contact to delete: ");
                    String firstNameToDelete = scanner.nextLine();
                    addressBook.deleteContact(firstNameToDelete);
                    break;
                case 4:
                    addressBook.displayContacts();
                    break;
                case 5:
                    System.out.println("Exiting the Address Book. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
            scanner.close();
        }
        
    }
}

class ContactPerson {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    // Constructor
    public ContactPerson(String firstName, String lastName, String address, String city,
                         String state, String zip, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getter methods
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    // Setter methods
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName +
               "\nAddress: " + address +
               "\nCity: " + city +
               "\nState: " + state +
               "\nZIP: " + zip +
               "\nPhone Number: " + phoneNumber +
               "\nEmail: " + email;
    }
}


class AddressBook {
    private ArrayList<ContactPerson> contacts = new ArrayList<>();

    public void addContact() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter city: ");
        String city = scanner.nextLine();
        System.out.print("Enter state: ");
        String state = scanner.nextLine();
        System.out.print("Enter ZIP: ");
        String zip = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        ContactPerson newContact = new ContactPerson(firstName, lastName, address, city,
                                                     state, zip, phoneNumber, email);

        contacts.add(newContact);
        System.out.println("Contact added successfully!");
        scanner.close();
    }

    public void editContact(String firstNameToEdit) {
        for (ContactPerson contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstNameToEdit)) {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Enter new address: ");
                String newAddress = scanner.nextLine();
                System.out.print("Enter new city: ");
                String newCity = scanner.nextLine();
                System.out.print("Enter new state: ");
                String newState = scanner.nextLine();
                System.out.print("Enter new ZIP: ");
                String newZip = scanner.nextLine();
                System.out.print("Enter new phone number: ");
                String newPhoneNumber = scanner.nextLine();
                System.out.print("Enter new email: ");
                String newEmail = scanner.nextLine();

                // Update the contact details
                contact.setAddress(newAddress);
                contact.setCity(newCity);
                contact.setState(newState);
                contact.setZip(newZip);
                contact.setPhoneNumber(newPhoneNumber);
                contact.setEmail(newEmail);

                System.out.println("Contact updated successfully!");
                scanner.close();
                return;

            }
        }

        System.out.println("Contact not found.");
    }

    public void deleteContact(String firstNameToDelete) {
        for (ContactPerson contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstNameToDelete)) {
                contacts.remove(contact);
                System.out.println("Contact deleted successfully!");
                return;
            }
        }

        System.out.println("Contact not found.");
    }

    public void displayContacts() {
        System.out.println("\nContacts in Address Book:");
        for (ContactPerson contact : contacts) {
            System.out.println(contact);
            System.out.println("------------------------");
        }
        System.out.println();
    }
}
