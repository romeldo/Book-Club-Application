/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
/**
 *
 * @author v1320
 */
public class AccountList {
    ArrayList<Account> AList = new ArrayList<Account>();

    public void addAccount(Account a){
        AList.add(a);
    }

    public void addAccount(long studID, String shipAddress, String billAddress, long credit, String user, String pw, String email){
        Account acc = new Account(studID, shipAddress, billAddress, credit, user, pw, email );
        AList.add(acc);
    }

    public Account removeAccount(int AccNum) {
        return AList.remove(AccNum);
    }

    public Account getAccount(int AccNum) {
        return AList.get(AccNum);
    }

    public int size() {
        return AList.size();
    }

    public boolean checkUser(String user) {
        for (int i = 0; i < AList.size(); i++) {
            if(AList.get(i).getUser().equals(user)){
                return true;
            }
        }
        return false;
    }

        @Override
    public String toString() {
        String returnString = "";
        for ( int i = 0; i < AList.size(); i++) {
            returnString = returnString+AList.get(i).toString()+"\n";
        }
        return returnString;
    }
}
