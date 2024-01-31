package com.example.assigment3;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FinalPage extends AppCompatActivity {

    private TextView nameTextView, emailTextView, roleTextView, educationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_page);

        nameTextView = findViewById(R.id.nameFinal);
        emailTextView = findViewById(R.id.emailFinal);
        roleTextView = findViewById(R.id.roleFinal);
        educationTextView = findViewById(R.id.educationFinal);

        // Retrieve information from Intent extras
        if (getIntent().hasExtra("response")) {
            Response response = getIntent().getParcelableExtra("response");
            if (response != null) {
                nameTextView.setText(response.getName());
                emailTextView.setText(response.getEmail());
                roleTextView.setText(response.getRole());
            }
        }

        // Retrieve education level from intent extras
        String educationLevel = getIntent().getStringExtra("EDUCATION_LEVEL");

        // Set education level to corresponding TextView
        educationTextView.setText(educationLevel);
    }
}
