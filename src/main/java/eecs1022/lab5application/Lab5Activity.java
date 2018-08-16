package eecs1022.lab5application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Lab5Activity extends AppCompatActivity {

    Bank bank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab5);
        bank = new Bank();
    }

    //                                    S  P  I  N  N  E  R

    /*
        First helper method. Changes the content of the output TextView
        Will display what the Transaction is in the GUI.

        Given the id (set in the View xml file) of a TextView
        we change its contents to 'newContents'
    */
    private void setContentsOfTextView(int id, String newContents)
    {
        View view = findViewById(id);
        TextView textView= (TextView) view;
        textView.setText(newContents);
    }

    /*
        This helper method will allow you to select the option in the
        the spinner.
    */
    private String getItemSelected(int id)
    {
        View view = findViewById(id);
        Spinner spinner = (Spinner) view;
        String string = spinner.getSelectedItem().toString();
        return string;
    }

    //                               C  O  N  T  R  O  L  L  E  R

    /*
        Helper method for retrieving contents from GUI.

        Given the id(set in the View xml file) of a TextView,
        we change its contents.
    */
    private String getInputOfTextField(int id)
    {
        View view = findViewById(id);
        EditText editText = (EditText) view;
        String input = editText.getText().toString();
        return input;
    }

    //                              B    U   T   T   O   N   S
    public void buttonCreateAccount(View view)
    {
        String client = getInputOfTextField(R.id.inputClient);
        String inputBalance = getInputOfTextField(R.id.inputBalance);

        if (!inputBalance.equals(""))
        {
            double balance = Double.parseDouble(inputBalance);
            this.bank.addClients(client, balance);
            setContentsOfTextView(R.id.labelAnswer, bank.toString());
        }
    }

    public void buttonTransaction (View view)
    {
        String fromClient = getInputOfTextField(R.id.inputFrom);
        String toClient = getInputOfTextField(R.id.inputTo);

        String inputAmount = getInputOfTextField(R.id.inputAmount);

        if(!inputAmount.equals(""))
        {
            double amount = Double.parseDouble(inputAmount);

            // Find the spinner service
            String spinnerState = getItemSelected(R.id.spinnerService);
            bank.serve(spinnerState, fromClient, toClient, amount);

            // Output shown to GUI
            setContentsOfTextView(R.id.labelAnswer, bank.toString());
        }
    }

    public void buttonOutput (View view)
    {
        String client = getInputOfTextField(R.id.inputNameClient);
        setContentsOfTextView(R.id.labelAnswer,  bank.show(client));
    }
}
