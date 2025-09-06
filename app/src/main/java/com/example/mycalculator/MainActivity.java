package com.example.mycalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
                                            //OnClickListener implemented for the buttons functions

    // Object declaration for Inputs, Buttons, and the Calculated Result
    Button buttonAdd, buttonSub, buttonMul, buttonDiv; //button objects
    EditText editTextN1, editTextN2; //input objects
    TextView textView; //result object
    int num1, num2; //number variables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instantiation of Objects with the Id from the activity_main.xml
        buttonAdd = findViewById(R.id.btn_add);
        buttonSub = findViewById(R.id.btn_sub);
        buttonMul = findViewById(R.id.btn_mul);
        buttonDiv = findViewById(R.id.btn_div);

        editTextN1 = findViewById(R.id.number1);
        editTextN2 = findViewById(R.id.number2);

        textView = findViewById(R.id.answer);

        //applying On Click Listener for the operation buttons
        buttonAdd.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);


    }

    //function to get the number from the editText input
    public int getIntFromEditText(EditText editText){
        if(editText.getText().toString().isEmpty()){
            Toast.makeText( this, "Enter a number", Toast.LENGTH_SHORT).show();
            return 0;
        } else
            return Integer.parseInt(editText.getText().toString());
            // return the input number
    }

    @Override
    public void onClick(View view) {
        // input numbers will get stored in these variables
        num1 = getIntFromEditText(editTextN1);
        num2 = getIntFromEditText(editTextN2);

        // calculation for the two numbers when a specific button is clicked
        if (view.getId() == R.id.btn_add)
            textView.setText("Answer = " + (num1 + num2));

        else if (view.getId() == R.id.btn_sub)
            textView.setText("Answer = " + (num1 - num2));

        else if (view.getId() == R.id.btn_mul)
            textView.setText("Answer = " + (num1 * num2));

        else if (view.getId() == R.id.btn_div)
            textView.setText("Answer = " + ((float)num1 / (float)num2));
    }
}