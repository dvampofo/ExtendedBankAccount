package eecs1022.lab5application;

/**
 * Created by davidampofo on 2018-03-12.
 */

public class Client {

    // Array Type 02
    String name;
    double balance;
    /*
         Declaring an array of Transaction addresses. Square brackets means we're going to collect
         all such objects/addresses as an array.

         We declare a reference variable courses being an array.
         Each element in this array is conceptually a reference variable

         E.g. history[0], history[1], ... history[history.length - 1] are reference variables each,
         of which storing the address of some Transaction object.

         It's as if we explicitly declared a list of reference variables:
            Transaction bank_0
            Transaction bank_1
            Transaction bank_2
            ...
     */

    // Array Type 02
    // Declaring array of Transaction record addresses
    Transaction[] history;

    /*
        This not (number of transactions) integer counter has 2 purposes:
            1. It indicates how many bank transaction objects have been added to the records array
            2. It indicates which position /index of the transaction array should store the NEXT transaction
             object
     */

    // Array Type 02
    // Number of transactions
    int not;

    // Array Type 02
    // Upper limit of transactions we can add. Fixed value tells us that once we hit the number 11, this is an error.
    final int MAX_NUM_TRANSACTION = 10;

    // Array Type 02
    Client(String name, double balance)
    {
        this.name = name;
        this.balance = balance;
        history = new Transaction[MAX_NUM_TRANSACTION];
        not = 0;
    }

    // Array Type 04
    // VERSION 3 Mutator - User has to create the Transaction object itself
    // Mutator: adding records to the Client course array
    // Serves as helper method to VERSION 3
    void addHistoryRecord(Transaction ta)
    {
        // this is a reference assignment which creates a new occurrence of aliasing
        // If less than 10 Transactions add to the History array, else do nothing.
        if(not < 10)
        {
            this.history[not] = ta;
            not++;
        }
    }
    // VERSION 3 Mutator:
    void addHistoryRecord(String service, double tr)
    {
        // new Transaction object's address is stored in a local variable `ta` and is only visible
        //  within this method
        Transaction ta = new Transaction(service, tr);

        // Array Type 04
        // VERSION 3 - calling another version of the mutator method as a helper method
        // User just has to provide the information (e.g. amount) for this method to create a new Transactio object
        this.addHistoryRecord(ta);
    }

    void deposit(double amount)
    {
        this.balance += amount;
    }

    void withdraw(double amount)
    {
        this.balance -= amount;
    }


    // void transfer(double amount)
//    {
        // Transferring between clients handled in Bank class.
//    }

    @Override
    public String toString() {

        String s = "";
        s += "Statement of client " + this.name + " (current balance $" + String.format("%.2f", this.balance) + "): \n";

        // For loop will print out entire content of the array
        for (int i = 0; i < this.history.length; i++)
        {
            if(this.history[i] == null)
            {
                s += "";
            }
            else
            {
                s +=  " Transaction " + this.history[i].service + " of $" + String.format("%.2f", this.history[i].amount) + ": \n";
            }
        }
        return s;
    }
}
