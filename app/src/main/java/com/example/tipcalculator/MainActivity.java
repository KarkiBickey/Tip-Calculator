package com.example.tipcalculator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextBillAmount;
    RadioGroup radioGroupTipPercentage;
    Switch switchRoundOff;
    Button buttonCalculate;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextBillAmount = findViewById(R.id.editTextBillAmount);
        radioGroupTipPercentage = findViewById(R.id.radioGroupTipPercentage);
        switchRoundOff = findViewById(R.id.switchRoundOff);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTip();
            }
        });
    }

    private void calculateTip() {
        double billAmount = Double.parseDouble(editTextBillAmount.getText().toString());

        int selectedId = radioGroupTipPercentage.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedId);
        double tipPercentage = Double.parseDouble(selectedRadioButton.getText().toString().replace("%", "")) / 100.0;

        boolean roundOffEnabled = switchRoundOff.isChecked();

        double tipAmount = billAmount * tipPercentage;

        if (roundOffEnabled) {
            tipAmount = Math.round(tipAmount);
        }

        textViewResult.setText("Calculated Amount: $" + String.format("%.2f", tipAmount));
    }
}




