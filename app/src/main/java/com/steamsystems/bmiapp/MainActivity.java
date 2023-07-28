package com.steamsystems.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txvResult;
        EditText edtWeight;
        EditText edtHeightIn;
        EditText edtHeightFt;
        Button btnCalculate;
        LinearLayout llMain;

        txvResult = findViewById(R.id.txvResult);
        edtWeight = findViewById(R.id.edtWeight);
        edtHeightIn = findViewById(R.id.edtHeightIn);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        btnCalculate = findViewById(R.id.btnCalculate);
        llMain = findViewById(R.id.llMain);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              int weight =  Integer.parseInt(edtWeight.getText().toString());
              int heightIn = Integer.parseInt(edtHeightIn.getText().toString());
              int heightFt = Integer.parseInt(edtHeightFt.getText().toString());

              int totalIn = heightFt * 12 + heightIn;
              double totalCm = totalIn * 2.53;
              double totalMt = totalCm / 100;

              double bmi = weight / Math.pow(totalMt, 2);
              
              if(bmi > 25){
                  txvResult.setText("You are Over Weight");
                  llMain.setBackgroundColor(getResources().getColor(R.color.colorOverWgt));
              }else if(bmi < 18){
                  txvResult.setText("You are Under Weight");
                  llMain.setBackgroundColor(getResources().getColor(R.color.colorUnderWgt));
              }else {
                  txvResult.setText("You are Healthy");
                  llMain.setBackgroundColor(getResources().getColor(R.color.colorHealWgt));

              }
            }
        });
    }
}