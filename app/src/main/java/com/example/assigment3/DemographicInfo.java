package com.example.assigment3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DemographicInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demographicinfo);

        findViewById(R.id.educationButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DemographicInfo.this, EducationLevel.class);
                startActivityForResult(intent, 1); // Start for result
            }
        });
    }

    // Handle the result from EducationLevel activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String selectedEducationLevel = data.getStringExtra("EDUCATION_LEVEL");
                // Update TextView or perform any other action with selectedEducationLevel
            }
        }
    }
}