package com.example.assigment3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class DemographicInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demographicinfo);



//Next button
        findViewById(R.id.nextButton3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve the response object passed from IdentificationInfo
                Response response = getIntent().getParcelableExtra("response");

                // Retrieve education level from the appropriate source (e.g., from radio button selection)
                RadioGroup radioGroup = findViewById(R.id.radioGroup2);
                int selectedId = radioGroup.getCheckedRadioButtonId();
                String educationLevel;
                if (selectedId != -1) {
                    RadioButton radioButton = findViewById(selectedId);
                    educationLevel = radioButton.getText().toString();
                } else {
                    // Handle the case where no radio button is selected
                    educationLevel = ""; // or any default value you want
                }

                // Start FinalPage activity and pass the response object and education level
                Intent intent = new Intent(DemographicInfo.this, FinalPage.class);
                intent.putExtra("response", response);
                intent.putExtra("EDUCATION_LEVEL", educationLevel);
                startActivity(intent);
            }
        });

        //Select Buttons
        findViewById(R.id.educationButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DemographicInfo.this, EducationLevel.class );
                startActivityForResult(intent, 1); // Start for result
            }
        });
        findViewById(R.id.maritalButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DemographicInfo.this, MaritalStatus.class );
                startActivityForResult(intent, 1); // Start for result
            }
        });
        findViewById(R.id.livingButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DemographicInfo.this, LivingStatus.class );
                startActivityForResult(intent, 1); // Start for result
            }
        });
        findViewById(R.id.incomeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DemographicInfo.this, HouseholdIncome.class );
                startActivityForResult(intent, 1); // Start for result
            }
        });
    }

}