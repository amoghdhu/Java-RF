package CH1.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LibraryRunner {
    public static void main(String[] args) throws IOException {

        //Library
        System.out.print("__________________________________\n");
        System.out.print("Welcome to the Belmont Library!\n");

        //Fiction
        List<Book> fictionList = new ArrayList<>();
        Book fiction1 = new Book("JK Rowling", "Harry Potter");
        fictionList.add(fiction1);
        Rack fictionRack = new Rack("Fiction", fictionList);
        fictionRack.addBook(new Book("Margaret Atwood", "The Handmaid's Tale: The Graphic Novel"));
        //fictionRack.pickUpBook(fiction1);
        //fictionRack.returnBook(fiction1);

        //Non-fiction
        List<Book> nonfictionList = new ArrayList<>();
        Book nonfiction1 = new Book("Bonnie Worth", "Learning About Sharks");
        nonfictionList.add(nonfiction1);
        Rack nonfictionRack = new Rack("Non Fiction", nonfictionList);
        nonfictionRack.addBook(new Book("Mark O'Shea", "Reptiles and Amphibians"));
        //nonfictionRack.returnBook(nonfiction1);

        //Comic
        List<Book> comicList = new ArrayList<>();
        Book comic1 = new Book("Kibuishi", "Amulet");
        comicList.add(comic1);
        Rack comicRack = new Rack("Comic", comicList);
        comicRack.addBook(new Book("Jonathan Hickman", "House Of X/Powers Of X"));
        //comicRack.pickUpBook(comic1);

        List<Rack> racksList = new ArrayList<>();
        racksList.add(fictionRack);
        racksList.add(nonfictionRack);
        racksList.add(comicRack);
        Library belmontLibrary = new Library("Belmont",racksList);
        //USER INPUT
        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(
                    "Pick between the following options: \n" +
                            "1: Show all available books\n" +
                            "2: Pick up book\n" +
                            "3: Return book\n" +
                            "4: Leave \n");
            int n = Integer.parseInt(br.readLine());
            if (n == 1) {
                System.out.print("__________________________________\n");
                System.out.print(belmontLibrary + "\n");
                System.out.print("\n__________________________________\n");
            } else if (n == 2) {
                System.out.print("__________________________________\n");
                System.out.print("Title of book you would like to be checked out: \n");
                String bookToBECheckoutTitle = br.readLine();
                System.out.print("Author of the book you would like to be checked out: \n");
                String author  = br.readLine();
                Book bookTBC = new Book(bookToBECheckoutTitle, author);
                List<Rack> myRAckList = belmontLibrary.getRackList();

                for (Rack rack : myRAckList) {
                    for(Book book : rack.getBookList()){
                        if(book.getTitle().equals(bookToBECheckoutTitle) && book.getBookAuthor().equals(author)){
                            if (rack.pickUpBook(book)) {
                                System.out.println("You have successfully picked up " + book.getTitle() + "\n");
                            }
                            else{
                                System.out.println("Sorry this book is currently unavailable.");
                            }
                        }
                    }
                }


            } else if (n == 3) {
                System.out.print("__________________________________\n");
                System.out.print("This is not a valid option at the moment. (Return book)\n");
                System.out.print("__________________________________\n");
            } else if (n == 4) {
                System.out.print("__________________________________\n");
                System.out.print("Hope you have enjoyed your visit at Belmont Library!\n");
                System.out.print("__________________________________\n");
                System.exit(0);
            } else {
                System.out.print("__________________________________\n");
                System.out.print("Invalid option, sorry.\n");
                System.out.print("__________________________________\n");
            }
        }
    }
}
