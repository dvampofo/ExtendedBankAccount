package eecs1022.lab5application;

/**
 * Created by davidampofo on 2018-03-12.
 */

public class TransactionTester {

    public static void main(String[] args)
    {
        Transaction ta1 = new Transaction("Deposit", 32);
        Transaction ta2 = new Transaction("Withdraw", 50);
        // Context object is ta1 and ta2

        System.out.println("Initial statements and values:");

        System.out.println(ta1.toString());
        System.out.println(ta2.toString());

        System.out.println(" ");
        System.out.println("__________________________");
        System.out.println(" ");

//        ta1.setService("Deposit");
//        ta1.setAmount(500);
//
//        ta2.setService("Withdraw");
//        ta2.setAmount(235);

        System.out.println(ta1.toString());
        System.out.println(ta2.toString());

    }
}
