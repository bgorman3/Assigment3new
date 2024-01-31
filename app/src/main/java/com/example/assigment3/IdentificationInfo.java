package com.example.assigment3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class IdentificationInfo extends AppCompatActivity {

    private EditText editTextName, editTextEmail;
    private RadioGroup radioGroup;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.indentificationinfo);

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        radioGroup = findViewById(R.id.radioGroup2);
        nextButton = findViewById(R.id.cancelButton1);

        nextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();

                if (TextUtils.isEmpty(name)) {
                    showToast("Name is required");
                } else if (TextUtils.isEmpty(email)) {
                    showToast("Email is required");
                } else if (checkedRadioButtonId == -1) {
                    showToast("Role is required");
                } else {
                    String role;
                    if (checkedRadioButtonId == R.id.radButton1) {
                        role = getResources().getString(R.string.radButton1);
                    } else if (checkedRadioButtonId == R.id.radButton2) {
                        role = getResources().getString(R.string.radButton2);
                    } else if (checkedRadioButtonId == R.id.radButton3) {
                        role = getResources().getString(R.string.radButton3);
                    } else {
                        role = "";
                    }

                    // Create Response object and start DemographicInfo activity
                    Response response = new Response(name, email, role);
                    Intent intent = new Intent(IdentificationInfo.this, DemographicInfo.class);
                    intent.putExtra("response", response);
                    startActivity(intent);
                }
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
