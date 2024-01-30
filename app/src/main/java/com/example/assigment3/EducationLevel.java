package com.example.assigment3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class EducationLevel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.educationlevel);

        final RadioGroup radioGroup = findViewById(R.id.radioGroup2);
        Button submitButton = findViewById(R.id.submitButton1);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(selectedId);
                if (radioButton != null) {
                    String selectedEducationLevel = radioButton.getText().toString();
                    Intent intent = new Intent();
                    intent.putExtra("EDUCATION_LEVEL", selectedEducationLevel);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}