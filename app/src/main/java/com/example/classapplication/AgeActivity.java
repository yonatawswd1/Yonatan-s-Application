package com.example.classapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AgeActivity extends AppCompatActivity {

    EditText etAge;
    Button btnDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);

        etAge = findViewById(R.id.etAge);
        btnDone = findViewById(R.id.btnDone);

        btnDone.setOnClickListener(v -> {
            int age = Integer.parseInt(etAge.getText().toString());

            Intent resultIntent = new Intent();
            resultIntent.putExtra("AGE", age);

            setResult(RESULT_OK, resultIntent);
            finish(); // return to First
        });
    }
}
