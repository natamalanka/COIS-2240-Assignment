import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryManagementTest {
    @Test
    public void testBookId() {
        try {
            // Test valid boundary cases
            Book validBook1 = new Book(100, "Valid Book 1");
            assertEquals(100, validBook1.getId());
            assertEquals("Valid Book 1", validBook1.getTitle());

            Book validBook2 = new Book(999, "Valid Book 2");
            assertEquals(999, validBook2.getId());
            assertEquals("Valid Book 2", validBook2.getTitle());

            // Test invalid ID less than 100
            try {
                new Book(99, "Invalid Book 1");
                fail("Expected an Exception to be thrown for ID less than 100.");
            } catch (Exception e) {
                assertEquals("Invalid Book ID: 99. ID must be between 100 and 999.", e.getMessage());
            }

            // Test invalid ID greater than 999
            try {
                new Book(1000, "Invalid Book 2");
                fail("Expected an Exception to be thrown for ID greater than 999.");
            } catch (Exception e) {
                assertEquals("Invalid Book ID: 1000. ID must be between 100 and 999.", e.getMessage());
            }

        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
}
