package LibraryManagementSystem;
import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
                Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Pre-populate with some data
        library.addBook("The Hobbit", "J.R.R. Tolkien");
        library.addBook("1984", "George Orwell");
        library.addMember("Alice");
        library.addMember("Bob");

        while (running) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add a new Book");
            System.out.println("2. Add a new Member");
            System.out.println("3. Borrow a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. List Available Books");
            System.out.println("6. List Members");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    break;
                case 2:
                    System.out.print("Enter member name: ");
                    String name = scanner.nextLine();
                    library.addMember(name);
                    break;
                case 3:
                    System.out.print("Enter your Member ID: ");
                    int memberIdBorrow = scanner.nextInt();
                    System.out.print("Enter the Book ID you want to borrow: ");
                    int bookIdBorrow = scanner.nextInt();
                    library.borrowBook(memberIdBorrow, bookIdBorrow);
                    break;
                case 4:
                    System.out.print("Enter your Member ID: ");
                    int memberIdReturn = scanner.nextInt();
                    System.out.print("Enter the Book ID you are returning: ");
                    int bookIdReturn = scanner.nextInt();
                    library.returnBook(memberIdReturn, bookIdReturn);
                    break;
                case 5:
                    library.listAvailableBooks();
                    break;
                case 6:
                    library.listMembers();
                    break;
                case 7:
                    running = false;
                    System.out.println("Thank you for using the Library Management System!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}