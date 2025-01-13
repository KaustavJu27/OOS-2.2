import java.util.ArrayList;

// Abstract class Publication
abstract class Publication {
    private int noOfPages;
    private double price;
    private String publisherName;

    // Constructor
    public Publication(int noOfPages, double price, String publisherName) {
        this.noOfPages = noOfPages;
        this.price = price;
        this.publisherName = publisherName;
    }

    // Getter and Setter methods
    public int getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    // Abstract method to display details
    public abstract void displayDetails();
}

// Book class (subclass of Publication)
class Book extends Publication {
    private String author;

    // Constructor
    public Book(int noOfPages, double price, String publisherName, String author) {
        super(noOfPages, price, publisherName);
        this.author = author;
    }

    // Getter and Setter for author
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Implementing the abstract method
    public void displayDetails() {
        System.out.println("Book: ");
        System.out.println("Author: " + author);
        System.out.println("Pages: " + getNoOfPages());
        System.out.println("Price: " + getPrice());
        System.out.println("Publisher: " + getPublisherName());
        System.out.println();
    }
}

// Journal class (subclass of Publication)
class Journal extends Publication {
    private int issueNumber;

    // Constructor
    public Journal(int noOfPages, double price, String publisherName, int issueNumber) {
        super(noOfPages, price, publisherName);
        this.issueNumber = issueNumber;
    }

    // Getter and Setter for issueNumber
    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    // Implementing the abstract method
    public void displayDetails() {
        System.out.println("Journal: ");
        System.out.println("Issue Number: " + issueNumber);
        System.out.println("Pages: " + getNoOfPages());
        System.out.println("Price: " + getPrice());
        System.out.println("Publisher: " + getPublisherName());
        System.out.println();
    }
}

// Library class to store and display publications
class Library {
    private ArrayList<Publication> publications = new ArrayList<>();

    // Method to add a publication to the library
    public void addPublication(Publication publication) {
        publications.add(publication);
    }

    // Method to display all publications in the library
    public void displayAllPublications() {
        for (Publication publication : publications) {
            publication.displayDetails();
        }
    }
}

// Main class to execute the program
public class Main {
    public static void main(String[] args) {
        // Create instances of Book and Journal
        Book book1 = new Book(250, 19.99, "Publisher A", "Author A");
        Book book2 = new Book(300, 24.99, "Publisher B", "Author B");
        Book book3 = new Book(150, 9.99, "Publisher C", "Author C");

        Journal journal1 = new Journal(50, 5.99, "Publisher X", 101);
        Journal journal2 = new Journal(60, 6.99, "Publisher Y", 102);

        // Create an instance of Library
        Library library = new Library();

        // Add publications to the library
        library.addPublication(book1);
        library.addPublication(book2);
        library.addPublication(book3);
        library.addPublication(journal1);
        library.addPublication(journal2);

        // Display all publications
        library.displayAllPublications();
    }
}
