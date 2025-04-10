import java.util.*;

class Book {
    int id;
    String title;
    String author;
    boolean isIssued;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    void display() {
        System.out.println("ID: " + id + ", Title: " + title + ", Author: " + author + ", Issued: " + (isIssued ? "Yes" : "No"));
    }
}

public class LibraryManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static List<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addBook();
                case 2 -> viewBooks();
                case 3 -> issueBook();
                case 4 -> returnBook();
                case 5 -> System.out.println("📚 Exiting Library System...");
                default -> System.out.println("⚠️ Invalid choice!");
            }
        } while (choice != 5);
    }

    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));
        System.out.println("✅ Book added successfully!");
    }

    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("❌ No books in library.");
            return;
        }
        System.out.println("\n📖 Available Books:");
        for (Book book : books) {
            book.display();
        }
    }

    static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int id = sc.nextInt();
        for (Book book : books) {
            if (book.id == id) {
                if (book.isIssued) {
                    System.out.println("⚠️ Book is already issued.");
                } else {
                    book.isIssued = true;
                    System.out.println("✅ Book issued successfully!");
                }
                return;
            }
        }
        System.out.println("❌ Book not found!");
    }

    static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int id = sc.nextInt();
        for (Book book : books) {
            if (book.id == id) {
                if (!book.isIssued) {
                    System.out.println("⚠️ Book was not issued.");
                } else {
                    book.isIssued = false;
                    System.out.println("✅ Book returned successfully!");
                }
                return;
            }
        }
        System.out.println("❌ Book not found!");
    }
}
