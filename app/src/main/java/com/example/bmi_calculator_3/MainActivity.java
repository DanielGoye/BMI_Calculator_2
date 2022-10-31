package com.example.bmi_calculator_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editName, editHeight, editWeight;
    Button btnSubmit;
    TextView textViewName, textViewBMI, textViewStatus, textViewWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = (EditText) findViewById(R.id.editName);
        editHeight = (EditText) findViewById(R.id.editHeight);
        editWeight = (EditText) findViewById(R.id.editWeight);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewBMI = (TextView) findViewById(R.id.textViewBMI);
        textViewStatus = (TextView) findViewById(R.id.textViewStatus);
        textViewWeight = (TextView) findViewById(R.id.textViewWeight);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editName.getText().toString();
                float height = Float.parseFloat(editHeight.getText().toString());
                float weight = Float.parseFloat(editWeight.getText().toString());
                float bmi = weight / (height * height);
                String status;
                if (bmi <= 18.5) {
                    status = "Underweight";
                } else if (bmi > 18.5 && bmi <= 25.0) {
                    status = "Normal";
                } else if (bmi > 25.0 && bmi <= 30.0) {
                    status = "Overweight";
                } else {
                    status = "Obese";
                }
                textViewName.setText("Name: " + name);
                textViewBMI.setText("BMI: " + bmi);
                textViewStatus.setText("Status: " + status);
                textViewWeight.setText("Weight: " + weight);
            }
        });
    }
}