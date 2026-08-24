package contact;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

    private ContactService contactService;
    private Contact contact;

    @BeforeEach
    void setUp() {
        contactService = new ContactService();

        contact = new Contact(
                "10001",
                "Jade",
                "Craft",
                "5185551234",
                "10 Main Street");
    }

    @Test
    void testAddContact() {
        contactService.addContact(contact);

        assertEquals(1, contactService.getContactCount());
        assertEquals(contact, contactService.getContact("10001"));
    }

    @Test
    void testDuplicateContactId() {
        contactService.addContact(contact);

        Contact duplicate = new Contact(
                "10001",
                "Jane",
                "Smith",
                "9135559999",
                "20 Oak Avenue");

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(duplicate);
        });
    }

    @Test
    void testDeleteContact() {
        contactService.addContact(contact);
        contactService.deleteContact("10001");

        assertEquals(0, contactService.getContactCount());
    }

    @Test
    void testDeleteUnknownContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("99999");
        });
    }

    @Test
    void testUpdateFirstName() {
        contactService.addContact(contact);
        contactService.updateFirstName("10001", "Jane");

        assertEquals(
                "Jane",
                contactService.getContact("10001").getFirstName());
    }

    @Test
    void testUpdateLastName() {
        contactService.addContact(contact);
        contactService.updateLastName("10001", "Smith");

        assertEquals(
                "Smith",
                contactService.getContact("10001").getLastName());
    }

    @Test
    void testUpdatePhone() {
        contactService.addContact(contact);
        contactService.updatePhone("10001", "9135559999");

        assertEquals(
                "9135559999",
                contactService.getContact("10001").getPhone());
    }

    @Test
    void testUpdateAddress() {
        contactService.addContact(contact);
        contactService.updateAddress("10001", "20 Oak Avenue");

        assertEquals(
                "20 Oak Avenue",
                contactService.getContact("10001").getAddress());
    }

    @Test
    void testCannotUpdateUnknownContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateFirstName("99999", "Jane");
        });
    }
}