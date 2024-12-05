import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

    // Single instance of the class
    private static Transaction instance;

    // Private constructor to prevent instantiation
    private Transaction() {}

    // Public method to get the single instance of the class
    public static Transaction getTransaction() {
        if (instance == null) {
            instance = new Transaction();
        }
        return instance;
    }

    // Perform the borrowing of a book
    public boolean borrowBook(Book book, Member member) {
        if (book.isAvailable()) {
            book.borrowBook();
            member.borrowBook(book);
            String transactionDetails = getCurrentDateTime() + " - Borrowing: " + member.getName() + " borrowed " + book.getTitle();
            System.out.println(transactionDetails);
            saveTransaction(transactionDetails);
            return true;
        } else {
            System.out.println("The book is not available.");
            return false;
        }
    }

    // Perform the returning of a book
    public void returnBook(Book book, Member member) {
        if (member.getBorrowedBooks().contains(book)) {
            member.returnBook(book);
            book.returnBook();
            String transactionDetails = getCurrentDateTime() + " - Returning: " + member.getName() + " returned " + book.getTitle();
            System.out.println(transactionDetails);
            saveTransaction(transactionDetails);
        } else {
            System.out.println("This book was not borrowed by the member.");
        }
    }

    // Save transaction details to a file
    private void saveTransaction(String transactionDetails) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.txt", true))) {
            writer.write(transactionDetails);
            writer.newLine();
        } catch (IOException e) {
        	// Error out if the transaction couldn't save
            System.out.println("Error saving transaction: " + e.getMessage());
        }
    }

    // Display all transaction history
    public void displayTransactionHistory() {
        try (BufferedReader reader = new BufferedReader(new FileReader("transactions.txt"))) {
            System.out.println("Transaction History:");
            System.out.println("====================");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("No transaction history found or an error occurred: " + e.getMessage());
        }
    }
    
    // Get the current date and time in a readable format
    private String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}
