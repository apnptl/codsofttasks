package com.example.calculatorapp;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private String currentNumber = "";
    private String operator = "";
    private double firstNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);
    }

    public void onNumberClick(View view) {
        // Handle number button clicks
        Button button = (Button) view;
        currentNumber += button.getText().toString();
        resultTextView.setText(currentNumber);
    }

    public void onOperatorClick(View view) {
        // Handle operator button clicks
        Button button = (Button) view;
        operator = button.getText().toString();
        firstNumber = Double.parseDouble(currentNumber);
        currentNumber = "";
    }

    public void onEqualClick(View view) {
        // Handle equals button click
        if (!currentNumber.isEmpty()) {
            double secondNumber = Double.parseDouble(currentNumber);
            double result = performCalculation(firstNumber, secondNumber, operator);
            resultTextView.setText(String.valueOf(result));
            currentNumber = String.valueOf(result);
        }
    }

    public void onClearClick(View view) {
        // Handle clear button click
        currentNumber = "";
        operator = "";
        firstNumber = 0;
        resultTextView.setText("0");
    }

    private double performCalculation(double num1, double num2, String op) {
        switch (op) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    return Double.NaN; // Division by zero
                }
                return num1 / num2;
            default:
                return num2;
        }
    }
}
