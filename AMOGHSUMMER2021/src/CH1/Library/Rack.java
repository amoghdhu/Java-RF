package CH1.Library;

import java.util.List;

public class Rack {
    private String genreName;
    private List<Book> bookList;

    public Rack(String genreName, List<Book> bookList){
        this.genreName = genreName;
        this.bookList = bookList;
    }

    public String getGenreName(){
        return this.getGenreName();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public boolean addBook(Book bookName){
        if (bookList.contains(bookName)){
            return false;
        }
        else{
            return bookList.add(bookName);
        }
    }

    public boolean pickUpBook(Book bookName){
        if (bookList.contains(bookName)){
            return bookList.remove(bookName);
        }
        else{
            System.out.println("Sorry the book you requested is currently unavailable");
            return false;
        }
    }

    public boolean returnBook(Book bookName){
        if (bookList.contains(bookName)){
            return false;
        }
        else{
            return bookList.add(bookName);
        }
    }


    @Override
    public String toString() {
        return genreName + " Rack Details: " +
                "\nBook List " + bookList;
    }
}
