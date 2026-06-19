📚 Library Management System (Java)

A console-based Library Management System built in Java that allows users to manage books efficiently. The application supports adding books, viewing all books, searching books, borrowing and returning books, and viewing available books.

This project demonstrates Object-Oriented Programming (OOP) concepts, collections, user input handling, and basic inventory management.

✨ Features
📖 Add new books to the library
📋 View all books
🔍 Search books by title or author
📥 Borrow books
📤 Return borrowed books
✅ View available books
🆔 Unique Book ID generation
📊 Track book availability status
🎨 User-friendly menu-driven interface
📂 Project Structure
Librarymanagement.java
│
├── Book Class
│   ├── id
│   ├── title
│   ├── author
│   ├── genre
│   ├── availability status
│   └── getters/setters
│
└── Librarymanagement Class
    ├── Add Book
    ├── View Books
    ├── Search Books
    ├── Borrow Book
    ├── Return Book
    ├── View Available Books
    └── Exit
🚀 Getting Started
Prerequisites
Java JDK 8 or higher
VS Code, IntelliJ IDEA, Eclipse, or Command Prompt
Compile the Program
javac Librarymanagement.java
Run the Program
java Librarymanagement
📖 Menu Options
-------------------------------------------------
  1. Add Book
  2. View All Books
  3. Search Book (by title or author)
  4. Borrow Book
  5. Return Book
  6. View Available Books
  7. Exit
-------------------------------------------------
📚 Preloaded Sample Books

The application starts with some sample books:

ID	Title	Author	Genre
1	The Alchemist	Paulo Coelho	Fiction
2	Clean Code	Robert C. Martin	Technology
3	Atomic Habits	James Clear	Self-Help
4	Harry Potter & Sorcerer's Stone	J.K. Rowling	Fantasy
5	Introduction to Algorithms	CLRS	Technology
💻 Sample Output
View All Books
--- All Books (5 total) ---

[ID:001] The Alchemist
Author: Paulo Coelho
Genre: Fiction
Available

[ID:002] Clean Code
Author: Robert C. Martin
Genre: Technology
Available
Borrow a Book
Enter Book ID to borrow: 2

You have borrowed: "Clean Code"
Please return it on time. Happy reading!
Return a Book
Enter Book ID to return: 2

Thank you for returning: "Clean Code"
Search Books
Enter title or author to search: harry

--- Search Results ---

[ID:004] Harry Potter & Sorcerer's Stone
Author: J.K. Rowling
Genre: Fantasy
Available
🛠 Technologies Used
Java
Object-Oriented Programming (OOP)
ArrayList Collection Framework
Scanner Class
Streams API
Exception Handling
📚 Concepts Practiced
Classes and Objects
Encapsulation
Collections (ArrayList)
User Input Handling
Searching and Filtering
Exception Handling
Method Design
Inventory Management Logic
🎯 Learning Outcomes

This project helps you understand:

How to build a menu-driven application
Managing collections of objects
Implementing CRUD-like operations
Designing reusable classes
Tracking object states (Available/Borrowed)
Handling user input safely
🔮 Future Enhancements
💾 Save books to a file/database
✏️ Update book details
👤 Member management system
📅 Due date tracking
💰 Fine calculation for late returns
🔐 Admin login system
🖥 GUI version using Java Swing or JavaFX
🌐 Database integration with MySQL
