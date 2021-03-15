package com.example.calculatoractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtv_num1,txtv_num2,edtResult;
    EditText edtNumber1,edtNumber2;
    Spinner spr;
    String[] list;
    private Button btnspinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btnspinner = (Button)findViewById(R.id.bt_spinner);
        spr = (Spinner)findViewById(R.id.spinner_item);


        list = getResources().getStringArray(R.array.spinner_item);

        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.color_spinner_layout,list);
        adapter.setDropDownViewResource(R.layout.color_spinner_layout);
        spr.setAdapter(adapter);

        btnspinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtv_num1 = (TextView)findViewById(R.id.txt1);
                txtv_num2 = (TextView)findViewById(R.id.txt2);
                edtNumber1 = (EditText)findViewById(R.id.ed1);
                edtNumber2 = (EditText)findViewById(R.id.ed2);
                edtResult = (TextView) findViewById(R.id.edtResult);

                String selectedItem = (String) spr.getSelectedItem();

                //Perform the operations based on selected signs strings

                if (selectedItem.trim().equals("no_item")){
                    Toast.makeText(MainActivity.this, "Please Select the one item ", Toast.LENGTH_SHORT).show();
                }
                if (selectedItem.trim().equals("Addition")){

                    float result = Float.parseFloat(edtNumber1.getText().toString())  + Float.parseFloat(edtNumber2.getText().toString());
                    edtResult.setText(Float.toString(result));
                }else if (selectedItem.trim().equals("Subtract")){

                    float result = Float.parseFloat(edtNumber1.getText().toString())  - Float.parseFloat(edtNumber2.getText().toString());
                    edtResult.setText(Float.toString(result));
                }else if (selectedItem.trim().equals("Multiply")){

                    float result = Float.parseFloat(edtNumber1.getText().toString())  * Float.parseFloat(edtNumber2.getText().toString());
                    edtResult.setText(Float.toString(result));

                }else if (selectedItem.trim().equals("Division")){

                    float result = Float.parseFloat(edtNumber1.getText().toString())  / Float.parseFloat(edtNumber2.getText().toString()) ;
                    edtResult.setText(Float.toString(result));


                }


            }
        });

        spr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                ((TextView)parentView.getChildAt(0)).setTextColor(Color.WHITE);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}