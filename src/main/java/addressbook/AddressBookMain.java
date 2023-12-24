package addressbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {
   public static void main(String[] args) {
        Map<String, AddressBook> addressBooks = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Address Book System Menu:");
            System.out.println("1. Create a new Address Book");
            System.out.println("2. Select an existing Address Book");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the new Address Book: ");
                    String newAddressBookName = scanner.nextLine();
                    AddressBook newAddressBook = new AddressBook();
                    addressBooks.put(newAddressBookName, newAddressBook);
                    System.out.println("Address Book '" + newAddressBookName + "' created successfully!");
                    break;
                case 2:
                    System.out.print("Enter the name of the Address Book to select: ");
                    String selectedAddressBookName = scanner.nextLine();
                    AddressBook selectedAddressBook = addressBooks.get(selectedAddressBookName);
                    if (selectedAddressBook != null) {
                        operateOnAddressBook(selectedAddressBook, scanner);
                    } else {
                        System.out.println("Address Book '" + selectedAddressBookName + "' not found.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting the Address Book System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void operateOnAddressBook(AddressBook addressBook, Scanner scanner) {
        while (true) {
            System.out.println("Address Book Menu:");
            System.out.println("1. Add a new contact");
            System.out.println("2. Edit an existing contact");
            System.out.println("3. Delete a contact");
            System.out.println("4. Display all contacts");
            System.out.println("5. Back to Address Book System Menu");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addressBook.addContact(scanner);
                    break;
                case 2:
                    System.out.print("Enter the first name of the contact to edit: ");
                    String firstNameToEdit = scanner.nextLine();
                    addressBook.editContact(firstNameToEdit, scanner);
                    break;
                case 3:
                    System.out.print("Enter the first name of the contact to delete: ");
                    String firstNameToDelete = scanner.nextLine();
                    addressBook.deleteContact(firstNameToDelete, scanner);
                    break;
                case 4:
                    addressBook.displayContacts();
                    break;
                case 5:
                    return; // Back to Address Book System Menu
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
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

    public void addContact(Scanner scanner) {

        while (true) {
            System.out.print("Enter first name (or type 'done' to finish): ");
            String firstName = scanner.nextLine();

            if (firstName.equalsIgnoreCase("done")) {
                break;
            }

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
        }
    }

public void editContact(String firstNameToEdit, Scanner scanner) {
    for (ContactPerson contact : contacts) {
        if (contact.getFirstName().equalsIgnoreCase(firstNameToEdit)) {

            System.out.println("1. Edit Address");
            System.out.println("2. Edit City");
            System.out.println("3. Edit State");
            System.out.println("4. Edit ZIP");
            System.out.println("5. Edit Phone number");
            System.out.println("6. Edit Email");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter new address: ");
                    String newAddress = scanner.nextLine();
                    contact.setAddress(newAddress);
                    break;
                case 2:
                    System.out.print("Enter new city: ");
                    String newCity = scanner.nextLine();
                    contact.setCity(newCity);
                    break;
                case 3:
                    System.out.print("Enter new state: ");
                    String newState = scanner.nextLine();
                    contact.setState(newState);
                    break;
                case 4:
                    System.out.print("Enter new ZIP: ");
                    String newZip = scanner.nextLine();
                    contact.setZip(newZip);
                    break;
                case 5:
                    System.out.print("Enter new phone number: ");
                    String newPhoneNumber = scanner.nextLine();
                    contact.setPhoneNumber(newPhoneNumber);
                    break;
                case 6:
                    System.out.print("Enter new email: ");
                    String newEmail = scanner.nextLine();
                    contact.setEmail(newEmail);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

            System.out.println("Contact updated successfully!");
            return;
        }
    }

    System.out.println("Contact not found.");
}


    public void deleteContact(String firstNameToDelete,Scanner scanner) {
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
