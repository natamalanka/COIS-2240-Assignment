import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryManagementTest {
    private Transaction transaction;
    private Book book;
    private Member member;

    
    // Task 3 Step 1
//    @Test
//    public void testBookId() {
//        try {
//            // Test valid boundary cases
//            Book validBook1 = new Book(100, "Valid Book 1");
//            assertEquals(100, validBook1.getId());
//            assertEquals("Valid Book 1", validBook1.getTitle());
//
//            Book validBook2 = new Book(999, "Valid Book 2");
//            assertEquals(999, validBook2.getId());
//            assertEquals("Valid Book 2", validBook2.getTitle());
//
//            // Test invalid ID less than 100
//            try {
//                new Book(99, "Invalid Book 1");
//                fail("Expected an Exception to be thrown for ID less than 100.");
//            } catch (Exception e) {
//                assertEquals("Invalid Book ID: 99. ID must be between 100 and 999.", e.getMessage());
//            }
//
//            // Test invalid ID greater than 999
//            try {
//                new Book(1000, "Invalid Book 2");
//                fail("Expected an Exception to be thrown for ID greater than 999.");
//            } catch (Exception e) {
//                assertEquals("Invalid Book ID: 1000. ID must be between 100 and 999.", e.getMessage());
//            }
//
//        } catch (Exception e) {
//            fail("Unexpected exception: " + e.getMessage());
//        }
//    }
    
	 // Task 3 Step 2
//    @Before
//    public void setUp() throws Exception {
//        transaction = Transaction.getTransaction();
//        book = new Book(101, "Test Book");
//        member = new Member(1, "John Doe");
//    }

    
    // Task 3 Step 2
//    @Test
//    public void testBorrowReturn() {
//        // Assert the book is initially available
//        assertTrue(book.isAvailable());
//
//        // Borrow the book
//        boolean borrowSuccess = transaction.borrowBook(book, member);
//        assertTrue(borrowSuccess); // Ensure borrowing was successful
//        assertFalse(book.isAvailable()); // Ensure the book is now unavailable
//
//        // Attempt to borrow the same book again
//        boolean borrowAgainSuccess = transaction.borrowBook(book, member);
//        assertFalse(borrowAgainSuccess); // Borrowing should fail since the book is unavailable
//
//        // Return the book
//        boolean returnSuccess = transaction.returnBook(book, member);
//        assertTrue(returnSuccess); // Ensure returning was successful
//        assertTrue(book.isAvailable()); // Ensure the book is now available
//
//        // Attempt to return the same book again
//        boolean returnAgainSuccess = transaction.returnBook(book, member);
//        assertFalse(returnAgainSuccess); // Returning should fail as the book was not borrowed
//    }
  
}
