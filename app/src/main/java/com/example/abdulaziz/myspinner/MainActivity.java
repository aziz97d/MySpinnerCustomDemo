package com.example.abdulaziz.myspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txtShow;
    private Button btnShow;
    private Spinner spinnerCountry;
    private String[] countryNames;

    private Spinner customSpinner;
    private String[] populations;
    private int[] imgCountry={R.drawable.algeria,R.drawable.bahrain,R.drawable.bangladesh,R.drawable.belgium,R.drawable.bolivia,R.drawable.cameroon,R.drawable.canada,R.drawable.egypt,R.drawable.england,R.drawable.finland,R.drawable.france,R.drawable.germany, R.drawable.ghana,R.drawable.italy};

    private boolean isFirstSelection = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryNames = getResources().getStringArray(R.array.country_names);
        populations = getResources().getStringArray(R.array.population);

        txtShow = findViewById(R.id.txt_show);
        btnShow = findViewById(R.id.btn_show);
        spinnerCountry = findViewById(R.id.spinnner_country);
        customSpinner = findViewById(R.id.custom_spnnier);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.sample_view,R.id.txt_sampleView,countryNames);
        spinnerCountry.setAdapter(arrayAdapter);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = spinnerCountry.getSelectedItem().toString();
                txtShow.setText(value);
            }
        });


        CustomAdapter customAdapter = new CustomAdapter(this,imgCountry,countryNames,populations);
        customSpinner.setAdapter(customAdapter);

        customSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                if (isFirstSelection==true){
                    isFirstSelection = false;
                }
                else {
                    Toast.makeText(getApplicationContext(),countryNames[i]+" is selected",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
