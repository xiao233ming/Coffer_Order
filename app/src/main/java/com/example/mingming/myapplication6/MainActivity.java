package com.example.mingming.myapplication6;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends Activity {

    int quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view){
        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view){
        if (quantity < 1) {
            quantity = 0;
        }else {
            quantity = quantity - 1;
            display(quantity);
        }
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    public void submitOrder(View view){
        display(quantity);
        displayPrice(quantity*5);
    }
}
