package com.example.classapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

public class FirstActivity extends AppCompatActivity {

    EditText etFirstName;
    TextView tvAgeDisplay;
    Button btnSetAge, btnSubmit;
    Switch switchMale;

    int age = -1; // stored age

    // Activity Result Launcher
    ActivityResultLauncher<Intent> ageLauncher =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    result -> {
                        if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                            age = result.getData().getIntExtra("AGE", -1);
                            tvAgeDisplay.setText("Age: " + age);
                        }
                    }
            );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        etFirstName = findViewById(R.id.etFirstName);
        tvAgeDisplay = findViewById(R.id.tvAgeDisplay);
        btnSetAge = findViewById(R.id.btnSetAge);
        btnSubmit = findViewById(R.id.btnSubmit);
        switchMale = findViewById(R.id.switchMale);

        btnSetAge.setOnClickListener(v -> {
            Intent intent = new Intent(FirstActivity.this, AgeActivity.class);
            ageLauncher.launch(intent);
        });

        btnSubmit.setOnClickListener(v -> {
            String firstName = etFirstName.getText().toString();
            boolean isMale = switchMale.isChecked();

            Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
            intent.putExtra("FIRST_NAME", firstName);
            intent.putExtra("AGE", age);
            intent.putExtra("IS_MALE", isMale);

            startActivity(intent);
        });
    }
}
