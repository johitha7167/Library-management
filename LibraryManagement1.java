package Com.MainApp;

import java.util.*;

class Book {
    private String title;
    private String author;
    private String category;
    private boolean available;

    public Book(String title, String author, String category) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Library {
    private List<Book> books;
    private Map<String, User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new HashMap<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void removeBook(Book book) {
        if (books.remove(book)) {
            System.out.println("Book removed successfully!");
        } else {
            System.out.println("Book not found!");
        }
    }

    public Book searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        System.out.println("Book not found!");
        return null;
    }

    public void issueBook(Book book, User user) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Book '" + book.getTitle() + "' issued to " + user.getName());
        } else {
            System.out.println("Book '" + book.getTitle() + "' is not available");
        }
    }

    public void returnBook(Book book, User user) {
        if (!book.isAvailable()) {
            book.setAvailable(true);
            System.out.println("Book '" + book.getTitle() + "' returned by " + user.getName());
        } else {
            System.out.println("Book '" + book.getTitle() + "' is already available");
        }
    }

    public void addUser(User user) {
        users.put(user.getName(), user);
    }

    public void showAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
    }
}

public class LibraryManagement1 {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Show Available Books");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book category: ");
                    String category = scanner.nextLine();
                    library.addBook(new Book(title, author, category));
                    break;
                case 2:
                    System.out.print("Enter book title to remove: ");
                    String titleToRemove = scanner.nextLine();
                    Book bookToRemove = library.searchBook(titleToRemove);
                    if (bookToRemove != null) {
                        library.removeBook(bookToRemove);
                    }
                    break;
                case 3:
                    System.out.print("Enter book title to search: ");
                    String searchTitle = scanner.nextLine();
                    library.searchBook(searchTitle);
                    break;
                case 4:
                    System.out.print("Enter book title to issue: ");
                    String issueTitle = scanner.nextLine();
                    Book issueBook = library.searchBook(issueTitle);
                    if (issueBook != null) {
                        System.out.print("Enter user name: ");
                        String userName = scanner.nextLine();
                        library.issueBook(issueBook, new User(userName));
                    }
                    break;
                case 5:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = scanner.nextLine();
                    Book returnBook = library.searchBook(returnTitle);
                    if (returnBook != null) {
                        System.out.print("Enter user name: ");
                        String userName = scanner.nextLine();
                        library.returnBook(returnBook, new User(userName));
                    }
                    break;
                case 6:
                    library.showAvailableBooks();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 7);

        scanner.close();
    }
}
