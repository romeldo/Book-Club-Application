/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author v1320
 */
public class ShoppingCart extends BookList {
    private double total = 0;

    public double getTotal() {
        total = 0;
        for (int i= 0; i < bookList.size(); i++){
            total = total + bookList.get(i).getPrice();
        }
        return total;
    }


    public void setTotal ( double total) {
        this.total = total;
    }


}
