package com.example.classapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Switch imgSwitch;
    ImageView imageTest;

    SeekBar SeekBarTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViews();



    }
    public void initViews(){
        SeekBarTest = findViewById(R.id.FirstSeekBar);

        imageTest = findViewById(R.id.imageTest1);

        imgSwitch = (Switch) findViewById(R.id.SwitchImageVIS);
        imgSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean switchState = imgSwitch.isChecked();

                if(!switchState){
                    imageTest.setVisibility(View.INVISIBLE);
                }
                else{
                    imageTest.setVisibility(View.VISIBLE);
                }
            }
        });


        SeekBarTest.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float alpha = progress / 100f;
                imageTest.setAlpha(alpha);
                Toast.makeText(MainActivity.this, "Press Started", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Press Started", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Press ended", Toast.LENGTH_SHORT).show();
            }
        });


    }


}



