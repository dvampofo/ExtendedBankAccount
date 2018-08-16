package eecs1022.lab5application;

/**
 * A bank management system stores a collection of Clients.
 */

public class Bank {

    Client[] clients;

    /*
        Two purposes of this counter
        1. Indicates number of clients added to the Bank so far
        2. Indicates where to store a new Bank object address in the Bank array.

        You will normally use this counter value as the upper bound of loop counters
     */
    int noc; // number of clients

    final int MAX_NUM_CLIENTS = 6;

    boolean error;
    String errorMsg;

    // Array Type 10
    Bank() {
        clients = new Client[MAX_NUM_CLIENTS];
        noc = 0;

        // Error messaging components
        error = false;
        errorMsg = "";
    }

    //                       A    D    D       C    L   I   E   N   T   S
    // Array Type 10
    void addClients(Client c)
    {
         int index = indexOfClients(c.name);

         if (index >= 0) // Client exists
         {
            setError("Error: Client " + c.name + " already exists.");
         }
         else if(c.balance <= 0) // ADDED THIS
         {
             setError("Error: Non-Positive Initial Balance.");
         }
         else if (this.noc == MAX_NUM_CLIENTS)
         {
             setError("Error: Maximum Number of Clients Reached.");
         }
         else {
             resetError();
             this.clients[noc] = c;
             noc++;
         }
    }
    // Array Type 10
    void addClients(String name, double balance) {
        Client c = new Client(name, balance);
        this.addClients(c);
    }

    //                                 E    R    R   O    R
    // Array Types 09 and 15
    void setError(String errorMsg) {
        this.error = true;
        this.errorMsg = errorMsg;
    }

    void resetError() {
        this.error = false;
        this.errorMsg = "";
    }

    //                       A   D   D   H   I   S   T   O   R   Y
    // Array Type 12
    // Given the name of a Client, add a HistoryRecord ta to that Client's history
    void addHistoryRecord(String name, Transaction ta)
    {
        int index = this.indexOfClients(name);
        this.clients[index].addHistoryRecord(ta);
    }

    void addHistoryRecord(String name, double amount)
    {
        Transaction ta = new Transaction(name, amount);
        this.addHistoryRecord(name, ta);
    }

    //                  I   N   D   E   X   C   L   I   E   N   T   S
    // Array Type 12
    // Helper method for locating where the Client is in the Bank array
    int indexOfClients(String name) {

        int index = -1;
        for (int i = 0; i < this.noc; i++) {
            if (clients[i].name.equals(name)) {
                index = i;
            }
        }
        return index;
    }

    //                              S    E   R   V   E
    void serve(String service, String from, String to, double amount) {
        // If I cant use if-else in Controller, change the `double amount` to `String amount`
//        if (!amount.equals(""))
//        {
//            // Then put ALL of the stuff below into this if statement
//        }

        resetError();
        int indexTo = indexOfClients(to);
        int indexFrom = indexOfClients(from);

        Transaction ta = new Transaction(service, amount);

        //                       D   E   P   O   S   I   T
        if(service.equals("DEPOSIT"))
        {
            // ERROR CHECKING
            if (indexTo < 0)
            {
                setError("ERROR: To-Client " + to + " does not exist.");
            }

            else
            {
                if (amount <= 0) {
                    setError("Error: Non-Positive Amount. ");
                }
                else {
                    this.clients[indexTo].deposit(amount);
                    this.clients[indexTo].addHistoryRecord(ta);
                    // Alternative for ta:  this.clients[indexTo].addHistoryRecord(new Transaction("DEPOSIT"), amount);
                }
            }
        }

        //                      W   I   T   H   D   R   A   W
        else if (service.equals("WITHDRAW"))
        {
            // ERROR CHECKING
            if (indexFrom < 0)
            {
                setError("ERROR: From-Client " + from + " does not exist.");
            }
            else
            {
                if (amount <= 0) {
                    setError("Error: Non-Positive Amount. ");
                }
                else if (this.clients[indexFrom].balance < amount)
                {
                    setError("Error: Amount too large to withdraw.");
                }
                else  // (this.clients[indexFrom].balance > amount)
                {
                    this.clients[indexFrom].withdraw(amount);
                    this.clients[indexFrom].addHistoryRecord(ta);
                }
            }
        }

        //                     T   R   A   N   S   F   E   R
        else
        {
            // ERROR CHECKING
            if (indexFrom < 0 )
            {
                setError("From-Client " + from + " does not exist.");
            }
            else if (indexTo < 0)
            {
                setError("To-Client " + to + " does not exist.");
            }
            else
            {
                    if (amount <= 0) {
                        setError(" Error: Non-Positive Amount.");
                    }
                    else if (this.clients[indexFrom].balance < amount) {

//                        setError("Error: client balance is not enough. ");
                        setError("Error: Amount too large to transfer.");

                    }
                    else
                    {
                        resetError();
                        this.clients[indexFrom].withdraw(amount);
                        this.clients[indexTo].deposit(amount);

                        this.clients[indexFrom].addHistoryRecord(new Transaction("WITHDRAW", amount));
                        this.clients[indexTo].addHistoryRecord(new Transaction("DEPOSIT", amount));
                    }
                }
            }
        }

    //               O   U   T   P   U   T      S    T    A    T    E    M    E    N    T
    // Show will print out all of the Client's history to the GUI
    String show(String name)
    {
        int index = indexOfClients(name);
        if (index < 0)
        {
            setError("Error: Client " + name + " does not exist");
            return errorMsg;
        }
        else
        {
            Client c = this.clients[index];

            String result = " ";

            result += "Statement of client " + c.name + " (current balance $" + String.format("%.2f", c.balance) + "):\n\t";

            for (int i = 0; i < c.not; i++)
            {
                result += c.history[i].toString();
            }
            return result;
        }
    }

    @Override
    public String toString() {
        String s = "";

        if (error) // Array Type 09: If statement for Error checking
        {
            s += this.errorMsg;

        } else {
            s += "Updated balances of Clients: \n";

            // For loop will print out entire content of the array
            for (int i = 0; i < this.noc; i++) {
                if (this.clients[i] == null) {
                    s += "null ";
                } else {
                    s += this.clients[i].name + ": $" + String.format("%.2f", this.clients[i].balance) + "\n";
                }
            }
        }
        return s;
    }
}