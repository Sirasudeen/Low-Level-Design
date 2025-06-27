package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private final int id;
    private final String name;
    private final List<Book> borrowedBooks;

    public Member(int id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }
    public void borrowBook(Book book) { borrowedBooks.add(book); }
    public void returnBook(Book book) { borrowedBooks.remove(book); }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: '" + name + "', Books Borrowed: " + borrowedBooks.size();
    }
}