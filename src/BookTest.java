import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    public class BookTest {

        @Test
        public void testSetDueDate() {
            // Setup
            Book book = new Book("1984", "George Orwell");
            book.checkOut(7); // Ensure the book is checked out

            // Act
            LocalDate dueDate = LocalDate.now().plusDays(7);
            book.setDueDate(dueDate);

            // Assert
            assertEquals(dueDate, book.getDueDate(), "The due date should be set correctly.");
        }

        @Test
        public void testSetDueDateWhenNotCheckedOut() {
            // Setup
            Book book = new Book("1984", "George Orwell");

            // Act & Assert
            assertThrows(IllegalStateException.class, () -> {
                book.setDueDate(LocalDate.now().plusDays(7));
            }, "Setting a due date for a book that is not checked out should throw an exception.");
        }

        @Test
        public void testSetCheckedOut() {
            // Setup
            Book book = new Book("1984", "George Orwell");

            // Act
            book.checkOut(7);

            // Assert
            assertTrue(book.isCheckedOut(), "The book should be marked as checked out.");
            assertNotNull(book.getDueDate(), "The due date should be set when the book is checked out.");
        }

        @Test
        public void testReturnBook() {
            // Setup
            Book book = new Book("1984", "George Orwell");
            book.checkOut(7);

            // Act
            book.returnBook();

            // Assert
            assertFalse(book.isCheckedOut(), "The book should be marked as not checked out.");
            assertNull(book.getDueDate(), "The due date should be cleared when the book is returned.");
        }

        @Test
        public void testSetCheckedOutFalse() {
            // Setup
            Book book = new Book("1984", "George Orwell");
            book.checkOut(7);

            // Act
            book.returnBook();

            // Assert
            assertFalse(book.isCheckedOut(), "The book should be marked as not checked out.");
        }
    }
        book.setCheckedOut(true);

        // Assert
        assertTrue(book.isCheckedOut(), "The book should be marked as checked out.");
    }

    @Test
    public void testSetCheckedOutFalse() {
        // Setup
        Book book = new Book("1984", "George Orwell");
        book.setCheckedOut(true);

        // Act
        book.setCheckedOut(false);

        // Assert
        assertFalse(book.isCheckedOut(), "The book should be marked as not checked out.");
    }
}