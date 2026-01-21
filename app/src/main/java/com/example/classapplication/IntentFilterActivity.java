package com.example.classapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IntentFilterActivity extends AppCompatActivity {

    Button hintedIntentbtnB, hintedIntentbtnA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intent_filter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViews();
    }
    private void initViews(){
        hintedIntentbtnA = findViewById(R.id.hintedIntentBTNA);
        hintedIntentbtnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent intent = new Intent("com.example.ACTION_OPEN_SCREEN_A");
                 startActivity(intent);
            }
        });

        hintedIntentbtnB = findViewById(R.id.hintedIntentBTNB);
        hintedIntentbtnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.ACTION_OPEN_SCREEN_B");
                startActivity(intent);
            }
        });

    }
}