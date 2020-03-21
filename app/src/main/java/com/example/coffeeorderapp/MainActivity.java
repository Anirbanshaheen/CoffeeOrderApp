package com.example.coffeeorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    Button buttonPlus, buttonMinus;
    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
    }

    public void increment(View view) {

        if(quantity == 100){
            Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view) {

        if(quantity == 1){
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        display(quantity);
    }

    public void processOrder(View view) {
//        display(quantity);
//        displayPrice(quantity * 5);

        int price = quantity * 5;
        String priceMessage = "Total : $" + price;
        priceMessage = priceMessage + "\nThank You";
        displayMessage(priceMessage);

    }

    private void displayPrice(int number) {

        TextView textViewPrice = findViewById(R.id.textViewPriceNumber);
        textViewPrice.setText(NumberFormat.getCurrencyInstance().format(number));

    }

    private void display(int number) {

        TextView textView = findViewById(R.id.textViewQuantityNumber);
        textView.setText("" + number);
    }

    private void displayMessage(String message){
        TextView textView = findViewById(R.id.textViewPriceNumber);
        textView.setText(message);
    }
}
