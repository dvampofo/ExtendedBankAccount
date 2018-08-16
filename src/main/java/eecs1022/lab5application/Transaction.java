package eecs1022.lab5application;

/**
 * Created by davidampofo on 2018-03-12.
 */

public class Transaction {

    // Array Type 01
    double amount;
    String service;

    /*
        The point of the Constructor is to
            1. create the object of Transaction
            2. and initialize a list of attributes which can be empty
     */

    // Array Type 01
    Transaction(String service, double amount)
    {
        this.service = service;
        this.amount  = amount;
    }

    @Override
    public String toString()
    {
        // Array Type 01
        return "Transaction " + this.service + ": $" + String.format("%.2f", this.amount) + "\n\t";
    }
}
