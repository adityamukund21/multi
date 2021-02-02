/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.coffeeshop;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int i=1,s=0;
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whic=(CheckBox)findViewById(R.id.whipcream);
        CheckBox choco=(CheckBox)findViewById(R.id.choco);
        EditText name =(EditText)findViewById(R.id.namefield);
        String s=name.getText().toString();
        int  cost=5;
        if(whic.isChecked())
            cost+=1;
        if(choco.isChecked())
            cost+=2;
        String kk="NAME: "+s+"\nTotal: $."+(i*cost);
        if(whic.isChecked())
            kk+="\nWhipped Cream- Yes";
                    else
            kk+="\nWhipped Cream- No";
        if(choco.isChecked())
            kk+="\nChocolate- Yes"+"\nThank YOU!";
        else
            kk+="\nChocolate- No"+"\nThank You!";
        Intent in=new Intent(Intent.ACTION_SEND);
        in.setType("text/plain");
        in.putExtra(Intent.EXTRA_TEXT,kk);
        startActivity(in);
    }
    public void plus(View view) {
        if(i<100)
        i++;
        display(i);
    }
    public void minus(View view) {
        if(i>0) {
            i--;
            display(i);
        }
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

}