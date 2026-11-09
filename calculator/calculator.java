package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText display;

    double value1 = 0, value2 = 0;
    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.etDisplay);

        int[] nums = {R.id.b0,R.id.b1,R.id.b2,R.id.b3,R.id.b4,
                R.id.b5,R.id.b6,R.id.b7,R.id.b8,R.id.b9,R.id.bDot};

        for(int id: nums){
            Button b = findViewById(id);
            b.setOnClickListener(v ->
                    display.append(((Button)v).getText().toString()));
        }

        findViewById(R.id.bClear).setOnClickListener(v ->
                display.setText(""));

        findViewById(R.id.bAdd).setOnClickListener(v -> setOperator("+"));
        findViewById(R.id.bSub).setOnClickListener(v -> setOperator("-"));
        findViewById(R.id.bMul).setOnClickListener(v -> setOperator("*"));
        findViewById(R.id.bDiv).setOnClickListener(v -> setOperator("/"));

        findViewById(R.id.bEqual).setOnClickListener(v -> {

            value2 = Double.parseDouble(display.getText().toString());
            double result = 0;

            switch(operator){
                case "+": result = value1 + value2; break;
                case "-": result = value1 - value2; break;
                case "*": result = value1 * value2; break;
                case "/": result = value1 / value2; break;
            }

            display.setText(String.valueOf(result));
        });
    }

    private void setOperator(String op){
        value1 = Double.parseDouble(display.getText().toString());
        operator = op;
        display.setText("");
    }
}
