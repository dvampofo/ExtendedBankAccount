package eecs1022.lab5application;

/**
 * Created by davidampofo on 2018-03-21.
 */

public class BankTester {

    public static void main(String[] args)
    {
        // Array Type 10
        // To be added to Client 1
//        Transaction ta1 = new Transaction("DEPOSIT", 100.345);
//        Transaction ta2 = new Transaction("WITHDRAW", 200.946);
//        Transaction ta3 = new Transaction("TRANSFER", 300.354);

        // To be added to Client 2
//        Transaction ta4 = new Transaction("Withdraw", 400.354);
//        Transaction ta5 = new Transaction("Deposit", 500.724);

        Client c1 = new Client("Emily", 5000.565);
        Client c2 = new Client("Jane", 10000.424);

        System.out.println("After creating the 2 Client objects (without adding any transactions yet): ");
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println("");

        System.out.println("___________________________\n");

        System.out.println("After adding transaction to Clients: ");
//        c1.addHistoryRecord(ta1);
//        c1.addHistoryRecord(ta2);
//        c1.addHistoryRecord(ta3);

//        c2.addHistoryRecord(ta4);
//        c2.addHistoryRecord(ta5);

        System.out.println(c1.toString());
        System.out.println(c2.toString());

        System.out.println("___________________________\n");


        Bank b = new Bank();

        // Array Type 11
        b.addClients(c1);
        b.addClients(c2);
        System.out.println("After adding clients to bank: ");
        System.out.println(b.toString());
        System.out.println("");

        System.out.println("Testing dot notation and aliasing ");
        System.out.println("c1 and b.clients[0] point to the same object: " + (c1 == b.clients[0]));
        System.out.println(" ");

        System.out.println("_______DEPOSIT_____");

//        b.deposit("Emily", 100000);
        System.out.println(b.toString());
        System.out.println("");

        System.out.println(c1.toString());
        System.out.println("");


        System.out.println("_______DEPOSIT, WITHDRAW & TRANSFER_____\n");

//        b.deposit("Jane", 20000000);
//        b.withdraw("MARCUS", -1000000); // DOESNT EXIST AS CLIENT
//        b.transfer("Emily", "Jane", 6000);

        System.out.println(b.toString());
        System.out.println("");

        System.out.println("_________________S E R V E_________________\n");

//        b.serve("DEPOSIT", "", "Jane", 5000);
//        b.serve("DEPOSIT", "", "Emily", 5000);
        b.serve("WITHDRAW", "Emily", "", -600);
//        b.serve("TRANSFER", "Emily", "Jane", 5000);

        System.out.println(b.toString());
        System.out.println(c1.toString());
        System.out.println(c2.toString());

//        b.addClients("A", 34);
//        b.addClients("B", 456);
//        b.addClients("C", 456);
//        b.addClients("D", 456);
//        b.addClients("E", 456);
        System.out.println("");
//        System.out.println(b.toString());


    }
}
