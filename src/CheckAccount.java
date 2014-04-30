/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author v1320
 */
public class CheckAccount {
    private AccountList AList;

    public CheckAccount(AccountList list) {
        AList = list;
    }

    public int isRegistered( String user, String pw) {
        for ( int i = 0; i< AList.size(); i++){
           if(AList.getAccount(i).getUser().equals(user)&& AList.getAccount(i).getPw().equals(pw)) {
               return i;
           }
        }
        return -1;
    }


}

