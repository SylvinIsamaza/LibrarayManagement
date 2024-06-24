package  com.library;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public Book borrowBook(String userId, String ISBN, Map<String, Member> members) {
        Member member = members.get(userId);
        Book book = books.get(ISBN);

        if (member != null && book != null && !book.isBorrowed()) {
            if (member.getBorrowedBooks().size() < 5) {
                book.setBorrowed(true);
                member.borrowBook(book);
                System.out.println(member.getName() + " borrowed " + book.getTitle());
                return book;
            } else {
                System.out.println("Cannot borrow book. Maximum limit of 5 borrowed books reached.");
                return null;
            }

        }
        else if(book==null){
            System.out.println("Cannot borrow book. Book not found.");
        }
        else if(member==null){
            System.out.println("Cannot borrow book. Member not found.");
        }
        else {
            System.out.println("Cannot borrow book.");
            return null;
        }
        return null;
    }

    public Book returnBook(String userId, String ISBN, Map<String, Member> members) {
        Member member = members.get(userId);
        Book book = books.get(ISBN);

        if (member != null && book != null && book.isBorrowed()) {
            book.setBorrowed(false);
            member.returnBook(book);
            System.out.println(member.getName() + " returned " + book.getTitle());
            return book;
        } else {
            System.out.println("Cannot return book.");
            return null;
        }
    }

    public List<Book> displayAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books.values()) {
            if (!book.isBorrowed()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
    public List<Book> displayBorrowedBooks() {
        List<Book> borrowedBooks = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.isBorrowed()) {
                borrowedBooks.add(book);
            }
        }
        return borrowedBooks;
    }

}
