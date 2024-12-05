import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryManagementTest {
    private Transaction transaction;
    private Book book;
    private Member member;

    @Before
    public void setUp() throws Exception {
        transaction = Transaction.getTransaction();
        book = new Book(101, "Test Book");
        member = new Member(1, "John Doe");
    }

    @Test
    public void testBorrowReturn() {
        // Assert the book is initially available
        assertTrue(book.isAvailable());

        // Borrow the book
        boolean borrowSuccess = transaction.borrowBook(book, member);
        assertTrue(borrowSuccess); // Ensure borrowing was successful
        assertFalse(book.isAvailable()); // Ensure the book is now unavailable

        // Attempt to borrow the same book again
        boolean borrowAgainSuccess = transaction.borrowBook(book, member);
        assertFalse(borrowAgainSuccess); // Borrowing should fail since the book is unavailable

        // Return the book
        boolean returnSuccess = transaction.returnBook(book, member);
        assertTrue(returnSuccess); // Ensure returning was successful
        assertTrue(book.isAvailable()); // Ensure the book is now available

        // Attempt to return the same book again
        boolean returnAgainSuccess = transaction.returnBook(book, member);
        assertFalse(returnAgainSuccess); // Returning should fail as the book was not borrowed
    }
}
