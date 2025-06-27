package LibraryManagementSystem;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Library {
    private final List<Book> books = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();
    private final AtomicInteger bookIdCounter = new AtomicInteger(1);
    private final AtomicInteger memberIdCounter = new AtomicInteger(1);

    public void addBook(String title, String author) {
        Book newBook = new Book(bookIdCounter.getAndIncrement(), title, author);
        books.add(newBook);
        System.out.println("SUCCESS: Added new book -> " + newBook);
    }

    public void addMember(String name) {
        Member newMember = new Member(memberIdCounter.getAndIncrement(), name);
        members.add(newMember);
        System.out.println("SUCCESS: Added new member -> " + newMember);
    }

    public void borrowBook(int memberId, int bookId) {
        Member member = findMemberById(memberId);
        Book book = findBookById(bookId);

        if (member == null) {
            System.out.println("ERROR: Member with ID " + memberId + " not found.");
            return;
        }
        if (book == null) {
            System.out.println("ERROR: Book with ID " + bookId + " not found.");
            return;
        }
        if (book.isBorrowed()) {
            System.out.println("ERROR: Book '" + book.getTitle() + "' is already borrowed.");
            return;
        }

        book.borrowBook();
        member.borrowBook(book);
        System.out.println("SUCCESS: " + member.getName() + " borrowed '" + book.getTitle() + "'.");
    }

    public void returnBook(int memberId, int bookId) {
        Member member = findMemberById(memberId);
        Book book = findBookById(bookId);

        if (member == null) {
            System.out.println("ERROR: Member with ID " + memberId + " not found.");
            return;
        }
        if (book == null) {
            System.out.println("ERROR: Book with ID " + bookId + " not found.");
            return;
        }
        if (!book.isBorrowed() || !member.getBorrowedBooks().contains(book)) {
            System.out.println("ERROR: This book was not borrowed by this member.");
            return;
        }

        book.returnBook();
        member.returnBook(book);
        System.out.println("SUCCESS: " + member.getName() + " returned '" + book.getTitle() + "'.");
    }

    public void listAvailableBooks() {
        System.out.println("\n--- Available Books ---");
        books.stream()
             .filter(book -> !book.isBorrowed())
             .forEach(System.out::println);
        System.out.println("-----------------------");
    }

    public void listMembers() {
        System.out.println("\n--- Library Members ---");
        members.forEach(System.out::println);
        System.out.println("-----------------------");
    }

    private Book findBookById(int id) {
        return books.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }

    private Member findMemberById(int id) {
        return members.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
    }
}