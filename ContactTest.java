package contact;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ContactTest {

    @Test
    void testContactCreation() {
        Contact contact = new Contact(
                "10001",
                "Jade",
                "Craft",
                "5185551234",
                "10 Main Street");

        assertEquals("10001", contact.getContactId());
        assertEquals("Jade", contact.getFirstName());
        assertEquals("Craft", contact.getLastName());
        assertEquals("5185551234", contact.getPhone());
        assertEquals("10 Main Street", contact.getAddress());
    }

    @Test
    void testContactIdCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    null,
                    "Jade",
                    "Craft",
                    "5185551234",
                    "10 Main Street");
        });
    }

    @Test
    void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345678901",
                    "Jade",
                    "Craft",
                    "5185551234",
                    "10 Main Street");
        });
    }

    @Test
    void testFirstNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "10001",
                    null,
                    "Craft",
                    "5185551234",
                    "10 Main Street");
        });
    }

    @Test
    void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "10001",
                    "FirstName11",
                    "Craft",
                    "5185551234",
                    "10 Main Street");
        });
    }

    @Test
    void testLastNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "10001",
                    "Jade",
                    null,
                    "5185551234",
                    "10 Main Street");
        });
    }

    @Test
    void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "10001",
                    "Jade",
                    "LastName111",
                    "5185551234",
                    "10 Main Street");
        });
    }

    @Test
    void testPhoneCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "10001",
                    "Jade",
                    "Craft",
                    null,
                    "10 Main Street");
        });
    }

    @Test
    void testPhoneMustBeTenDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "10001",
                    "Jade",
                    "Craft",
                    "12345",
                    "10 Main Street");
        });
    }

    @Test
    void testPhoneMustContainOnlyDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "10001",
                    "Jade",
                    "Craft",
                    "51855A1234",
                    "10 Main Street");
        });
    }

    @Test
    void testAddressCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "10001",
                    "Jade",
                    "Craft",
                    "5185551234",
                    null);
        });
    }

    @Test
    void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "10001",
                    "Jade",
                    "Craft",
                    "5185551234",
                    "1234567890123456789012345678901");
        });
    }
}