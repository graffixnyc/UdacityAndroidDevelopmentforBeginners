package com.graffixnyc.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView quantityTextView;
    TextView orderSummaryTextView;
    CheckBox hasWhippedCream;
    CheckBox hasChocolate;
    EditText customerName;
    int quantity=0;
    String custName,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quantityTextView=(TextView) findViewById(R.id.quantity_text_view);
        orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        hasWhippedCream=(CheckBox)findViewById(R.id.chkWhippedCream);
        hasChocolate=(CheckBox)findViewById(R.id.chkChocolate);
        customerName=(EditText) findViewById(R.id.etName);

    }
    public void submitOrder(View view){
        String orderSummary=createOrderSummary();
        //displayMessage(orderSummary);
        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.setData(Uri.parse("mailto:"));
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Just Java Order For " + name);
        sendIntent.putExtra(Intent.EXTRA_TEXT, orderSummary);
        if (sendIntent.resolveActivity(getPackageManager())!=null) {
            startActivity(sendIntent);
        }
    }
    private void displayQuantity(int numberOfCoffees){
        quantityTextView.setText("" + numberOfCoffees);
    }
    private void displayMessage(String message) {
        orderSummaryTextView.setText(message);
    }
    public void increment(View view){

        if (quantity==100){

        }
        else{
            quantity++;
        }
        displayQuantity(quantity);
    }
    public void decrement(View view){
        if (quantity==0){
        }else {
            quantity--;
            displayQuantity(quantity);
        }
    }
    private int calculatePrice() {
        int pricePerCup;
        pricePerCup=5;
        int toppings=0;
        if (hasWhippedCream.isChecked()){
            pricePerCup+=1;
        }
        if (hasChocolate.isChecked()){
            pricePerCup+=2;
        }

        int price = quantity * pricePerCup;
        return price;
    }
    private String createOrderSummary(){

        custName=customerName.getText().toString();
        if (!custName.matches(""))
        {
             name="Name: " + customerName.getText();
        }
        else{
             name="Name: Joe Momma Bitch";
        }
        String whippedCream="Add Whipped Cream? ";
        String chocolate= "Add Chocolate? ";
        if (hasWhippedCream.isChecked()){
            whippedCream+="Yes";
        }
        else{
            whippedCream+="No";
        }
        if (hasChocolate.isChecked()){
            chocolate+="Yes";
        }
        else{
            chocolate+="No";
        }
        return name +"\n" + whippedCream + "\n"+ chocolate+ "\nQuantity: " + quantity + "\nTotal: $" + calculatePrice()
                +"\nThank you!";

    }
}
