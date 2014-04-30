/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
/**
 *
 * @author v1320
 */
public class BookList {
    protected ArrayList<Book> bookList = new ArrayList<Book>();

    public void addBook(Book b) {
        bookList.add(b);
    }

    public void addBook( String title, double price) {
        Book b = new Book(title, price);
        bookList.add(b);
    }

    public Book removeBook(int bookNum) {
        return bookList.remove(bookNum);
    }

    public int size() {
        return bookList.size();
    }

    public boolean isEmpty() {
        return bookList.isEmpty();
    }

    public Book getBook(int index) {
        return bookList.get(index);
    }

    public void clear() {
        bookList.clear();
    }

    @Override
    public String toString() {
        String returnString = "";
        for ( int i = 0; i < bookList.size(); i++) {
            returnString = returnString+ "("+ i+ ") "+bookList.get(i).toString()+"\n";
        }
        return returnString;
    }

}
