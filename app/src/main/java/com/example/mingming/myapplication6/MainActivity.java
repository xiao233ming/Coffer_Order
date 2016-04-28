package com.example.mingming.myapplication6;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view) {
        if (quantity < 1) {
            quantity = 0;
        } else {
            quantity = quantity - 1;
            display(quantity);
        }
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    public void submitOrder(View view) {
        EditText text = (EditText) findViewById(R.id.name_field);
        String value = text.getText().toString();

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        //Log.v(TAG,"Has whipped cream" + hasWhippedCream);

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int price = calculatePrice(hasWhippedCream,hasChocolate);
        String priceMessgae = createOrderSummary(value,price,hasWhippedCream,hasChocolate);
        displayMessage(priceMessgae);
    }

    private String createOrderSummary(String name,int price,boolean addWhippedCream,boolean addchocolateCheckBox) {
        String priceMessage = "Name:"+name;
        priceMessage +="\nAdd whipped cream?" + addWhippedCream;
        priceMessage +="\nAdd chocolate CheckBox?" + addchocolateCheckBox;
        priceMessage += "\nQuantity:" + quantity;
        priceMessage += "\nTotal:$" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    private int calculatePrice(boolean addWhippedCream,boolean addChocolate) {
        int basePrice = 5;
        if (addWhippedCream){
            basePrice = basePrice + 1;
        }
        if (addChocolate){
            basePrice = basePrice + 2;
        }
        return quantity * basePrice;
    }

}
