package IteratorPattern.Solution;

// Book class representing individual books in a library
public class Book {
    private final String title;
    private final String author;
    private final String iSBN;
    private int price;

    public Book(String title, String author, String iSBN) {
        this.title = title;
        this.author = author;
        this.iSBN = iSBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return iSBN;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book [Title=" + title + ", Author=" + author + ", ISBN=" + iSBN + "]";
    }
}