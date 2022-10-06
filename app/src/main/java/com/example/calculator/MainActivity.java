package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText inputEditText1, inputEditText2;
    Button addButton, subButton, multButton, divButton;
    TextView resultTextView;;
    Double number1, number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);
        addButton = findViewById(R.id.add_btn);
        subButton = findViewById(R.id.sub_btn);
        multButton = findViewById(R.id.mul_btn);
        divButton = findViewById(R.id.div_btn);
        inputEditText1 = findViewById(R.id.input_1);
        inputEditText2 = findViewById(R.id.input_2);
        resultTextView = findViewById(R.id.btn_res);
        ClickListner();
    }
    public void ClickListner(){
            addButton.setOnClickListener(new View.OnClickListener() { // Addition task
                @Override
                public void onClick(View v) {
                    if (validateFields())
                    {
                        Toast.makeText(getApplicationContext(),"Please Enter All Values", Toast.LENGTH_LONG).show();
                    }else{
                        parseFields();
                        Double result = number1 + number2 ;
                        displayResult(result);
                    }
                }
            });

            subButton.setOnClickListener(new View.OnClickListener() { // Subtraction task
                @Override
                public void onClick(View v) {
                    if(validateFields())
                    {
                        Toast.makeText(getApplicationContext(),"Please Enter All Values", Toast.LENGTH_LONG).show();
                    }else {
                        parseFields();
                        Double result = number1 - number2;
                        displayResult(result);
                    }
                }
            });

        multButton.setOnClickListener(new View.OnClickListener() { // Multiplication task
            @Override
            public void onClick(View v) {
                if(validateFields())
                {
                    Toast.makeText(getApplicationContext(),"Please Enter All Values", Toast.LENGTH_LONG).show();
                }else {
                    parseFields();
                    Double result = number1 * number2;
                    displayResult(result);
                }
            }
        });
        divButton.setOnClickListener(new View.OnClickListener() { // Divide task
            @Override
            public void onClick(View v) {
                if(validateFields())
                {
                    Toast.makeText(getApplicationContext(),"Please Enter All Values", Toast.LENGTH_LONG).show();
                }else {
                    parseFields();
                    if (number2 == 0) {
                        resultTextView.setText("Math Error!");
                    } else {
                        Double result = number1 / number2;
                        displayResult(result);
                    }
                }
            }
        });
    }
    protected boolean validateFields()
    {
        return (inputEditText1.getText().toString()).equals("") || (inputEditText2.getText().toString()).equals("");
    }
    protected void parseFields()
    {
        number1 = Double.parseDouble(inputEditText1.getText().toString());
        number2 = Double.parseDouble(inputEditText2.getText().toString());
    }
    protected void displayResult(Double result)
    {
        DecimalFormat df = new DecimalFormat("#.##########");
        String results = df.format(result);
        resultTextView.setText(results);
    }

}