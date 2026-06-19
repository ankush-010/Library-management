import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private int    id;
    private String title;
    private String author;
    private String genre;
    private boolean available;

    public Book(int id, String title, String author, String genre) {
        this.id        = id;
        this.title     = title;
        this.author    = author;
        this.genre     = genre;
        this.available = true;
    }

    public int     getId()         { return id;        }
    public String  getTitle()      { return title;     }
    public String  getAuthor()     { return author;    }
    public String  getGenre()      { return genre;     }
    public boolean isAvailable()   { return available; }
    public void    setAvailable(boolean status) { this.available = status; }

    @Override
    public String toString() {
        String status = available ? "Available  " : "Borrowed   ";
        return String.format("  [ID:%03d] %-35s | Author: %-20s | Genre: %-15s | %s",
                id, title, author, genre, status);
    }
}

public class Librarymanagement {
    static ArrayList<Book> library = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int nextId = 1;

    public static void main(String[] args) {
        // Pre-load sample books
        addSampleBooks();

        System.out.println("=================================================");
        System.out.println("          Library Management System              ");
        System.out.println("=================================================");

        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Choose an option: ");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1": addBook();      break;
                case "2": viewBooks();    break;
                case "3": searchBook();   break;
                case "4": borrowBook();   break;
                case "5": returnBook();   break;
                case "6": viewAvailable(); break;
                case "7":
                    System.out.println("\nThank you for using Library Management System!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option! Please choose 1-7.");
            }
        }
        scanner.close();
    }

    static void printMenu() {
        System.out.println("\n-------------------------------------------------");
        System.out.println("  1. Add Book");
        System.out.println("  2. View All Books");
        System.out.println("  3. Search Book (by title or author)");
        System.out.println("  4. Borrow Book");
        System.out.println("  5. Return Book");
        System.out.println("  6. View Available Books");
        System.out.println("  7. Exit");
        System.out.println("-------------------------------------------------");
    }

    static void addBook() {
        System.out.println("\n--- Add New Book ---");
        System.out.print("Enter Title  : ");
        String title  = scanner.nextLine().trim();
        System.out.print("Enter Author : ");
        String author = scanner.nextLine().trim();
        System.out.print("Enter Genre  : ");
        String genre  = scanner.nextLine().trim();

        library.add(new Book(nextId++, title, author, genre));
        System.out.println("Book added successfully with ID: " + (nextId - 1));
    }

    static void viewBooks() {
        System.out.println("\n--- All Books (" + library.size() + " total) ---");
        if (library.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        for (Book book : library) {
            System.out.println(book);
        }
        long available = library.stream().filter(Book::isAvailable).count();
        System.out.println("-------------------------------------------------");
        System.out.println("  Available: " + available + "  |  Borrowed: " + (library.size() - available));
    }

    static void searchBook() {
        System.out.print("\nEnter title or author to search: ");
        String keyword = scanner.nextLine().trim().toLowerCase();
        boolean found  = false;

        System.out.println("--- Search Results ---");
        for (Book book : library) {
            if (book.getTitle().toLowerCase().contains(keyword) ||
                book.getAuthor().toLowerCase().contains(keyword)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) System.out.println("No books found matching: \"" + keyword + "\"");
    }

    static void borrowBook() {
        System.out.print("\nEnter Book ID to borrow: ");
        try {
            int id = Integer.parseInt(scanner.nextLine().trim());
            Book book = findById(id);

            if (book == null) {
                System.out.println("No book found with ID: " + id);
            } else if (!book.isAvailable()) {
                System.out.println("Sorry! \"" + book.getTitle() + "\" is already borrowed.");
            } else {
                book.setAvailable(false);
                System.out.println("You have borrowed: \"" + book.getTitle() + "\"");
                System.out.println("Please return it on time. Happy reading!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid book ID.");
        }
    }

    static void returnBook() {
        System.out.print("\nEnter Book ID to return: ");
        try {
            int id = Integer.parseInt(scanner.nextLine().trim());
            Book book = findById(id);

            if (book == null) {
                System.out.println("No book found with ID: " + id);
            } else if (book.isAvailable()) {
                System.out.println("\"" + book.getTitle() + "\" was not borrowed.");
            } else {
                book.setAvailable(true);
                System.out.println("Thank you for returning: \"" + book.getTitle() + "\"");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid book ID.");
        }
    }

    static void viewAvailable() {
        System.out.println("\n--- Available Books ---");
        boolean found = false;
        for (Book book : library) {
            if (book.isAvailable()) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) System.out.println("No books are currently available.");
    }

    static Book findById(int id) {
        for (Book book : library) {
            if (book.getId() == id) return book;
        }
        return null;
    }

    static void addSampleBooks() {
        library.add(new Book(nextId++, "The Alchemist",              "Paulo Coelho",    "Fiction"));
        library.add(new Book(nextId++, "Clean Code",                 "Robert C. Martin","Technology"));
        library.add(new Book(nextId++, "Atomic Habits",              "James Clear",     "Self-Help"));
        library.add(new Book(nextId++, "Harry Potter & Sorcerer's Stone", "J.K. Rowling","Fantasy"));
        library.add(new Book(nextId++, "Introduction to Algorithms", "CLRS",            "Technology"));
    }
}