package com.example.sukrins.tipcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText amount, tax, tip;
    TextView totalCost;
    Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amount = (EditText) findViewById(R.id.MealCostEdit);
        tax = (EditText) findViewById(R.id.TaxPerEdit);
        tip = (EditText) findViewById(R.id.TipPerEdit);
        totalCost = (TextView) findViewById(R.id.TotalCostView);
        myButton = (Button) findViewById(R.id.CalcButton);

        Button calc = (Button) findViewById(R.id.CalcButton);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double mealPrice = new Double(amount.getText().toString());
                double taxP = new Double(tax.getText().toString());
                double tax = (mealPrice * taxP) / 100;
                double tipP = new Double(tip.getText().toString());
                double tip = (mealPrice * tipP) / 100;
                double total = mealPrice + tax + tip;
                totalCost.setText(Double.toString(total));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
