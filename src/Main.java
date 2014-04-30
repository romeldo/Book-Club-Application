/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

/**
 *
 * @author Ka Yeung Tsang & Kai-Loen Wong
 */

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static BookList bl = new BookList();
    private static AccountList al = new AccountList();
    private static ShoppingCart offerSc = new ShoppingCart();
    private static ShoppingCart sc = new ShoppingCart();
    private static String input;

    public static void main(String[] args) {
        CheckAccount chkAcc = new CheckAccount(al);
        al.addAccount(500113212, "1324 Ryerson Avenue", "21 Bay Street", 123344304304l, "Student", "password", "student@hotmail.com");
        al.addAccount(500113212, "432 Tsang Avenue", "22 Tsang Street", 784123337878l, "Student2", "password", "student2@mail.com");
        al.getAccount(0).setMembership(false);
        bl.addBook("bored", 100);
        bl.addBook("bored 2 bored harder", 200);
        bl.addBook("bored 3 bored bored harder", 300);
        bl.addBook("bored 4 bored bored bored harder", 400);

        System.out.println("Available accounts");
        System.out.println("User name: Student Password: password");
        System.out.println("User name: Student2 Password: password");
        System.out.println("Welcome to the Student Book Club");
        System.out.println("Do you have an account? (Y/N)");
        input = scanner.next();
        
        
        if (input.equalsIgnoreCase("y")) {
            System.out.println("Enter username and password seperated by a space");
            input = scanner.next();
            String password = scanner.next();
            int accountIndex = chkAcc.isRegistered(input, password);
            while (accountIndex < 0) {
                System.out.println("Please enter vaild username and password");
                input = scanner.next();
                password = scanner.next();
                accountIndex = chkAcc.isRegistered(input, password);
            }
            mainMenu(accountIndex);
        } else if (input.equalsIgnoreCase("n")) {
            System.out.println("Do you want to make an account? (Y/N)");
            input = scanner.next();
            if (input.equalsIgnoreCase("y")) {
                System.out.println("Do you live in Canada? (Y/N)");
                input = scanner.next();
                if (input.equalsIgnoreCase("y")) {
                    System.out.println("Enter Student ID");
                    input = scanner.next();
                    long studID = Long.parseLong(input);
                    System.out.println("Enter user name");
                    input = scanner.next();
                    while (al.checkUser(input)) {
                        System.out.println("User name not available please enter a new one");
                        input = scanner.next();
                    }
                    String userName = input;
                    System.out.println("Please enter a password");
                    input = scanner.next();
                    String password = input;
                    System.out.println("Please enter email");
                    input = scanner.next();
                    String email = input;
                    System.out.println("Please enter credit card number");
                    input = scanner.next();
                    long credit = Long.parseLong(input);
                    System.out.println("Please enter Shipping address");
                    input = scanner.next();
                    String address = input;
                    System.out.println("Please enter Billing address");
                    input = scanner.next();
                    String bill = input;
                    al.addAccount(studID, address, bill, credit, userName, password, email);

                    mainMenu(al.size() - 1);
                } else if (input.equalsIgnoreCase("n")) {
                    System.out.println("BYE!");
                }
            } else if (input.equalsIgnoreCase("n")) {
                System.out.println("Bye!");
            }
        }
    }
/**
 *
 * @param a
 */
    public static void offerMenu(Account a) {

        int bookNum;
        listBooks();
        System.out.println("To add book to shopping cart input book number(top book is 0 and ++1 every line down). Please enter three numbers for the three selections (separated by space).");
        for (int i = 0; i < 3; i++) {
            input = scanner.next();
            bookNum = Integer.parseInt(input);

            offerSc.addBook(bl.getBook(bookNum).getTitle(), bl.getBook(bookNum).getPrice());
            offerSc.getBook(i).setPrice(25);
            System.out.println("Added"+bl.getBook(bookNum).getTitle());
        }
        a.setIntroOffer(false);
        System.out.println(offerSc.toString());
        System.out.println("The books have been added to your shopping cart.");
        System.out.println("Would you like to continue shopping? (y/n)");
        input = scanner.next();
        if (input.equalsIgnoreCase("y")) {
            addMenu(a);
        }
    }
/**
 *
 * @param a
 */
    public static void addMenu(Account a) {//add book
        int bookSel = -1;
        listBooks();
        System.out.println("To add book to shopping cart input book number. Enter -1 to finish.");
        bookSel = scanner.nextInt();
        while (bookSel != -1) {
            sc.addBook(bl.getBook(bookSel).getTitle(), bl.getBook(bookSel).getPrice() * a.getDiscount());
            System.out.println("Added " + bl.getBook(bookSel).getTitle());

            if (!offerSc.isEmpty()) {
                System.out.println("Offer Cart");
                System.out.println(offerSc.toString());
                System.out.println("Shopping Cart");
                System.out.println(sc.toString());
            } else {
                if (!sc.isEmpty()) {
                    System.out.println("Shopping Cart");
                    System.out.println(sc.toString());
                }
            }
            bookSel = scanner.nextInt();
        }
    }
/**
 *
 * @param a
 */
    public static void removeMenu(Account a) {

        if (!sc.isEmpty()) {
            input = "-2";
            System.out.println("Enter index of book to remove enter -1 to finish");
            while (!input.equals("-1")) {
                System.out.println("Shopping Cart");
                System.out.println(sc.toString());
                input = scanner.next();
                if( input.equals("-1")){
                    break;
                }
                sc.removeBook(Integer.parseInt(input));
            }
        } else {
            System.out.println("Nothing in shopping cart");
        }
    }
/**
 *
 */
    public static void checkout() {

        double total = 0;

        if (!offerSc.isEmpty()) {
            offerSc.setTotal(75);
            total = 0;
            total = total + offerSc.getTotal();
            System.out.println("Your total from your offer cart is "+ offerSc.getTotal());

        }
        if (!sc.isEmpty()) {
            total = total + sc.getTotal();
            System.out.println("Your total from your shopping cart is "+ sc.getTotal());
        }
        if(offerSc.isEmpty() && sc.isEmpty()) {
            System.out.println("Your shopping cart is empty.");
        }
        else {
            System.out.println("Do you want to check out?");
            input = scanner.next();
            if (input.equalsIgnoreCase("y")) {
                sc.clear();
                offerSc.clear();
                System.out.println("Checkout confirmed.");
            }
        }
    }
/**
 *
 * @param accountNumIndex
 */
    public static void mainMenu(int accountNumIndex) {
        int accountIndex = accountNumIndex;
        Account a = al.getAccount(accountIndex);
        if (a.isMembership()) {
            a.setDiscount(0.9);
        } else {
            a.setDiscount(1);
        }
        if (a.isMembership()) {
            if (a.isIntroOffer()) {
                System.out.println("You have an intoductory offer to purchase 3 books for $75 including shipping and handling");
                System.out.println("You have not used the offer. Want to use it?(Y/N)");
                input = scanner.next();
                if (input.equalsIgnoreCase("y")) {
                    offerMenu(al.getAccount(accountIndex));
                }
            }
        } else {
            System.out.println("You are currently not a member do you want a membership? (y/n)");
            input = scanner.next();
            if (input.equalsIgnoreCase("y")) {
                a.setMembership(true);
                a.setDiscount(0.9);
                System.out.println("You are now a member");
            }
        }
        while (true) {
            System.out.println("Welcome to the Main Menu of our Book Club!");
            System.out.println("Please select an option");
            System.out.println("1. Look at book list");
            System.out.println("2. Review Account Information");
            System.out.println("3. Edit shopping cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            input = scanner.next();

            if (input.equals("1")) {
                listBooks();
            }
            if (input.equals("2")) {
                System.out.println(a.toString());
            }

            if (input.equals("3")) {
                shoppingCartM(a);
            }

            if (input.equals("4")) {
                checkout();
            }
            if(input.equals("5")){
                System.out.println("Good bye!");
                Email.sendEmail();
                break;
            }
        }
    }
/**
 *
 */
    public static void listBooks() {
        int arraylistsize = bl.size();
        for (int i = 0; i < arraylistsize; i++) {
            System.out.println("(" + i + ") " + bl.getBook(i));
        }
    }
/**
 *
 * @param a
 */
    public static void shoppingCartM(Account a) {
        input = "-2";
        while (true) {
            System.out.println("Welcome to the shopping cart menu!");
            if ( sc.isEmpty()){
                System.out.println("Your shopping cart is currently empty.");
            }
            else {
                System.out.println("Your shopping cart items:");
                System.out.println(sc.toString());
            }
            System.out.println("Enter option number");
            System.out.println("(1) To add books to shopping cart");
            System.out.println("(2) To remove books from shopping cart");
            System.out.println("(3) To return to main menu");
            input = scanner.next();
            if (input.equals("1")) {
                addMenu(a);
            } else if (input.equals("2")) {
                removeMenu(a);
            } else if (input.equals("3")) {
                //Does nothing to end this method and return to Main Menu
                break;
            } else {
                System.out.println("Please enter an option number");
                input = "-2";
            }
        }
    }
}
