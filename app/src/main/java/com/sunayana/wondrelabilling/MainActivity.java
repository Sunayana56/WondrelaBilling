package com.sunayana.wondrelabilling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText adultNo, childNo;
    TextView adultCost, childCost, totCostDisp;
    RadioGroup ac, days;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adultNo = (EditText)findViewById(R.id.adultNo);
        childNo = (EditText)findViewById(R.id.childNo);

        adultCost = (TextView)findViewById(R.id.adultCost);
        childCost = (TextView)findViewById(R.id.childCost);
        totCostDisp = (TextView)findViewById(R.id.totCostDisp);

        ac = (RadioGroup)findViewById(R.id.ac);
        days = (RadioGroup)findViewById(R.id.noDays);

        submit = (Button)findViewById(R.id.Submit);



        ac.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int perAdultCost = 0;
                int perChildCost = 0;
                switch (ac.getCheckedRadioButtonId()){
                    case R.id.AC :
                        perAdultCost = 2000;
                        perChildCost = 1500;
                        break;
                    case R.id.nonAC :
                        perAdultCost = 1800;
                        perChildCost = 1300;
                        break;
                }

                adultCost.setText(String.valueOf(perAdultCost));
                childCost.setText(String.valueOf(perChildCost));

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int perAdultCost = 0;
                int perChildCost = 0;

                int noOfadults = Integer.parseInt(adultNo.getText().toString());
                int noOfchildren = Integer.parseInt(childNo.getText().toString());

                switch (ac.getCheckedRadioButtonId()){
                    case R.id.AC :
                        perAdultCost = 2000;
                        perChildCost = 1500;
                        break;
                    case R.id.nonAC :
                        perAdultCost = 1800;
                        perChildCost = 1300;
                        break;
                }

                //Log.d("ADULTCOST", String.valueOf(perAdultCost));
                int totcost = (perAdultCost * noOfadults) + (perChildCost * noOfchildren);

                switch (days.getCheckedRadioButtonId()){
                    case R.id.rdBtn1:
                        totcost = totcost * 1;
                        break;

                    case R.id.rdBtn2:
                        totcost = totcost * 2;
                        break;

                    case R.id.rdBtn3:
                        totcost = totcost * 3;
                        break;
                }

                totCostDisp.setText(String.valueOf(totcost));
            }
        });
    }

}
