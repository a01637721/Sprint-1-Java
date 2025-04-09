
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class PatronTest {

    @Test
    public void testAddBook() {
        // Setup
        Patron patron = new Patron("Alice Smith");
        Book book = new Book("1984", "George Orwell");

        // Act
        patron.addBook(book);

        // Assert
        assertTrue(patron.getCheckedOutBooks().contains(book), "The book should be added to the patron's checked-out books.");
    }

    @Test
    public void testRemoveBook() {
        // Setup
        Patron patron = new Patron("Alice Smith");
        Book book = new Book("1984", "George Orwell");
        patron.addBook(book);

        // Act
        patron.removeBook(book);

        // Assert
        assertFalse(patron.getCheckedOutBooks().contains(book), "The book should be removed from the patron's checked-out books.");
    }

    public class LibraryTest {

        @Test
        public void testAddDuplicateBooks() {
            // Setup
            Library library = new Library();
            Book book = new Book("1984", "George Orwell");
            library.addBook(book);

            // Act
            boolean result = library.addBook(book);

            // Assert
            assertFalse(result, "The library should not allow adding duplicate books.");
        }

        @Test
        public void testNonexistentBookCheckout() {
            // Setup
            Library library = new Library();
            Patron patron = new Patron("Alice Smith");
            Book book = new Book("1984", "George Orwell");

            // Act
            boolean result = library.checkOutBook(book, patron);

            // Assert
            assertFalse(result, "The library should not allow checkout of a nonexistent book.");
        }

        @Test
        public void testFineCalculation() {
            // Setup
            Patron patron = new Patron("Alice Smith");
            patron.setFine(0);

            // Act
            patron.setFine(5.00); // Simulate overdue fine calculation

            // Assert
            assertEquals(5.00, patron.getFine(), "The fine should be calculated correctly.");
        }

        @Test
        public void testListBooksAndPatrons() {
            // Setup
            Library library = new Library();
            Book book1 = new Book("1984", "George Orwell");
            Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");
            Patron patron1 = new Patron("Alice Smith");
            Patron patron2 = new Patron("Bob Johnson");

            library.addBook(book1);
            library.addBook(book2);
            library.addPatron(patron1);
            library.addPatron(patron2);

            // Act
            List<Book> books = library.listAvailableBooks();
            List<Patron> patrons = library.listPatrons();

            // Assert
            assertTrue(books.contains(book1) && books.contains(book2), "The list of books should reflect the current state of the library.");
            assertTrue(patrons.contains(patron1) && patrons.contains(patron2), "The list of patrons should reflect the current state of the library.");
        }
    }
        assertEquals(0, patron.getFine(), "The fine should be cleared.");
    }
}