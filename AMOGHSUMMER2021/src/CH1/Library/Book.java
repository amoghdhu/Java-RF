package CH1.Library;

public class Book {
    private String bookAuthor;
    private String bookTitle;

    public Book(String author, String title) {
        this.bookAuthor = author;
        this.bookTitle = title;

    }
    public String getCategory() {
        return bookAuthor;
    }

    public String getTitle() {
        return this.bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    @Override
    public String toString(){
        return  "\n\tTitle: " + this.bookTitle + "\n\tAuthor: " + this.bookAuthor+ "\n";
    }
}
