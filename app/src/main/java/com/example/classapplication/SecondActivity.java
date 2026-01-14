package com.example.classapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class SecondActivity extends AppCompatActivity {

    TextView tvFirstName, tvAge, tvGender;
    Button btnFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvFirstName = findViewById(R.id.tvFirstName);
        tvAge = findViewById(R.id.tvAge);
        tvGender = findViewById(R.id.tvGender);
        btnFinish = findViewById(R.id.btnFinish);

        String firstName = getIntent().getStringExtra("FIRST_NAME");
        int age = getIntent().getIntExtra("AGE", 0);
        boolean isMale = getIntent().getBooleanExtra("IS_MALE", false);

        tvFirstName.setText("First Name: " + firstName);
        tvAge.setText("Age: " + age);
        tvGender.setText("Male: " + (isMale ? "Yes" : "No"));

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
