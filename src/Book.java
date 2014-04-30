/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author v1320
 */
public class Book {
    private static int count = 0;
    private int bookNum;
    private String title;
    private double price;

    public Book( String title, double price) {
        this.bookNum = count;
        count++;
        this.title = title;
        this.price = price;
    }
/**
 *
 * @return Returns the title
 */
    public String getTitle() {
        return title;
    }
/**
 *
 * @return Returns the book number
 */

    public int getBookNum() {
        return bookNum;
    }

    /**
     *
     * @return Returns the price of the book
     */

    public double getPrice() {
        return price;
    }
/**
 * Sets the price of this object to the number from the parameter
 * @param price
 */
    public void setPrice(double price) {
        this.price = price;
    }
/**
 * Sets the title of this book to the parameter value
 * @param title
 */
    public void setTitle(String title) {
        this.title = title;
    }
/**
 *
 * @return Returns a string that includes the title and price of the book
 */
    @Override
    public String toString() {
        return " title = " + title + " price = " + price;
    }
    
}
