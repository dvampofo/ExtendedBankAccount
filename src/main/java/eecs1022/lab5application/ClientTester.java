package eecs1022.lab5application;

/**
 * Created by davidampofo on 2018-03-12.
 */

public class ClientTester {

    public static void main(String[] args)
    {
        // Array Type 02
        // VERSION 1: Explicitly creating TA objects
        Transaction t1 = new Transaction("Deposit", 40.564);
        Transaction t2 = new Transaction("Withdraw", 65.923);
        Transaction t3 = new Transaction("Transfer", 900.459);

        Client c1 = new Client("Emily", 100);
        c1.addHistoryRecord(t1);
        c1.addHistoryRecord(t2);
        c1.addHistoryRecord(t3);
        System.out.println(c1.toString());
        System.out.println("");


        Client c2 = new Client("Jack", 45);
        c2.addHistoryRecord(t2);
        c2.addHistoryRecord(t3);
        System.out.println(c2.toString());

        // Array Type 04 - Refactoring addHistory(String service, double tr)
        System.out.println("_________________________");
        System.out.println("\nAfter adding the third course (position 2): \n");
        c1.addHistoryRecord("Transfer", 50.2344);
//        c2.addHistoryRecord("Deposit", 50.2344);
        System.out.println(c1.toString());

        // System.out.println("After setting marks of the third object (position 2): ");

        //   !!!!!!!!!!!!!!!!!!!
        // UPDATE: Works now
        // ERROR HERE! Wont show the changed balance!
//        c2.history[2].setAmount(3982.3454); // .setAmount in Transaction
//        c2.setAmount("Deposit",4000.3454);
        System.out.println(c2.toString());
        //   !!!!!!!!!!!!!!!!!!!
        System.out.println("_________________________");


        // Array Type 05 - Aliasing
        System.out.println("\nQuick test on aliasing");
        System.out.println("t and c1.history[0] point to the same object: " + (t1 == c1.history[0]));
        System.out.println("t2 and c1.history[0] point to the different object: " + (t2 != c1.history[0]));

        System.out.println("t3 and c1.history[1] point to the same object: " + (t3 == c1.history[1]));
        System.out.println("t2 and c1.history[0] point to the different object: " + (t2 != c1.history[0]));
        System.out.println(" ");

        // Array Type 06 - getHistory
        // Better used for finding Clients ???
//        System.out.println("Emily deposited: " + String.format("%.2f", c1.getHistory("Deposit")));
//        System.out.println("Emily deposited: " + String.format("%.2f", c1.getHistory("Withdraw")));
//        System.out.println("Emily transferred: " + String.format("%.2f", c1.getHistory("Transfer")));
//        System.out.println("Emily transferred: " + String.format("%.2f", c1.getHistory("Food"))); // -1
//        System.out.println(" ");

        //             !!!!!!!!!!!!!!!!!!!
        // UPDATE: WORKS NOW
        // ERROR HERE! Wont show the changed balance due to setAmount issue!
        System.out.println("After changing the Clients deposit");
//        c2.setAmount("Deposit", 5023.342);     // e.g. c1.deposit("Jim", 2023.34)
        System.out.println(c2.toString());
        //             !!!!!!!!!!!!!!!!!!!
        System.out.println(" ");

        // Array Type 06 - Refactoring
        // Refactor to find index of Clients in Bank array instead of services!
//        System.out.println("Index of Deposit: "  + c1.indexOfHistory("Deposit"));  // 0
//        System.out.println("Index of Withdraw: " + c1.indexOfHistory("Withdraw")); // 1
//        System.out.println("Index of Transfer: " + c1.indexOfHistory("Transfer")); // 2
//        System.out.println("Index of Food: "     + c1.indexOfHistory("Food"));     // -1
        System.out.println(" ");

        // Array Type 08 - Balance Sum
//        System.out.println("Balance Sum " + c1.getBalanceSum());
//        System.out.println(" ");

        //Array Type 09 - Error Messaging
        System.out.println("Adding a new service with clashing title: Deposit");
        c1.addHistoryRecord("Deposit", 30);
        System.out.println(c1.toString());
        System.out.println(" ");

//        System.out.println("Amount of non-existing service: " + c1.getHistory("Testing"));; // -1


    }
}
