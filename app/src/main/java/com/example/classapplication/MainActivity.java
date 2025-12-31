package com.example.classapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tvContext;
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

    public void initViews() {
        SeekBarTest = findViewById(R.id.FirstSeekBar);

        imageTest = findViewById(R.id.imageTest1);

        tvContext = findViewById(R.id.tv_menu);

        registerForContextMenu(tvContext);

        imgSwitch = (Switch) findViewById(R.id.SwitchImageVIS);
        imgSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean switchState = imgSwitch.isChecked();

                if (!switchState) {
                    imageTest.setVisibility(View.INVISIBLE);
                } else {
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
        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }


    public boolean onOptionsItemSelected (MenuItem item){

        super.onOptionsItemSelected(item);

        int id = item.getItemId();

        if (id == R.id.action_login) {
            Toast.makeText(this, "You've logged in successfully", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.action_register) {
            Toast.makeText(this, "You've registered successfully", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.action_toast) {
            Toast.makeText(this, "You have 10 minutes :)", Toast.LENGTH_SHORT).show();
        }

        return true;
    }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
            super.onCreateContextMenu(menu, v, menuInfo);

            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_main, menu);
        }

    public boolean onConetextMenuSelected (MenuItem item){

        if (item.getItemId() ==  R.id.firstline) {
            Toast.makeText(this, "You selected first line", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() ==  R.id.secondtline) {
            Toast.makeText(this, "You selected second line", Toast.LENGTH_SHORT).show();
        }

        return false;
    }
}








