/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Calendar;
/**
 *
 * @author v1320
 */

public class Account {
    private long studID;
    private String shipAddress;
    private String billAddress;
    private long credit;
    private String pw;
    private String user;
    private String email;
    private String joinDate;
    private String inactiveTime;
    private boolean introOffer = true;
    private int booksBrought;
    private double discount = 0.9;
    private static int count = 0;
    private int accNum;
    private boolean membership = true;


    public Account(long studID, String shipAddress, String billAddress, long credit, String user, String pw, String email) {
        /*
         * @param studID
         */
        this.studID = studID;
        this.shipAddress = shipAddress;
        this.billAddress = billAddress;
        this.credit = credit;
        this.user = user;
        this.pw = pw;
        this.email = email;
        this.accNum = count;
        this.joinDate = "";
        this.inactiveTime = "";
        this.booksBrought = 0;
        count++;
    }

    public String getBillAddress() {
        return billAddress;
    }

    public void setBillAddress(String billAddress) {
        this.billAddress = billAddress;
    }

    public int getBooksBrought() {
        return booksBrought;
    }

    public void setBooksBrought(int booksBrought) {
        this.booksBrought = booksBrought;
    }

    public long getCredit() {
        return credit;
    }

    public void setCredit(long credit) {
        this.credit = credit;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInactiveTime() {
        return inactiveTime;
    }

    public void setInactiveTime(String inactiveTime) {
        this.inactiveTime = inactiveTime;
    }

    public boolean isIntroOffer() {
        return introOffer;
    }

    public void setIntroOffer(boolean introOffer) {
        this.introOffer = introOffer;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public long getStudID() {
        return studID;
    }

    public void setStudID(long studID) {
        this.studID = studID;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isMembership() {
        return membership;
    }

    public void setMembership(boolean membership) {
        this.membership = membership;
    }

    @Override
    public String toString() {
        return "Account{" + "studID = " + studID + "\nshipAddress = " + shipAddress + "\nbillAddress = " + billAddress + "\ncredit = " + credit + "\npw = " + pw + "\nuser = " + user + "\nemail = " + email + "\njoinDate = " + joinDate + "\ninactiveTime = " + inactiveTime + "\nintroOffer = " + introOffer + "\nbooksBrought = " + booksBrought + "\ndiscount = " + discount + "\naccNum = " + accNum + '}';
    }



}
