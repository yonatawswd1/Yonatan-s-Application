package com.example.classapplication;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DynamicActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    LinearLayout linearLayoutTemp;
    HorizontalScrollView scrollView;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dynamic);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        linearLayout = findViewById(R.id.main);
        linearLayoutTemp = new LinearLayout(this);
        scrollView = new HorizontalScrollView(this);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        scrollView.setLayoutParams(layoutParams);

        linearLayoutTemp.setLayoutParams(layoutParams);


        for(int i = 1; i <= 10; i++){
            imageView = new ImageView(this);
            LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(200,200);
            imageParams.setMargins(8,8,8,8);
            imageView.setLayoutParams(imageParams);
            int imageKey = getResources().getIdentifier("image" + i%3, "drawable", getPackageName());
            imageView.setImageResource(imageKey);
            linearLayoutTemp.addView(imageView);
        }
        scrollView.addView(linearLayoutTemp);
        linearLayout.addView(scrollView);

    }
}