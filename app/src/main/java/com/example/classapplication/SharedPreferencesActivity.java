package com.example.classapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SharedPreferencesActivity extends AppCompatActivity {

    SharedPreferences sp;
    Button saveBtn;
    EditText Fname, Lname;
    TextView tvName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shared_preferences);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        saveBtn = findViewById(R.id.btnSubmit);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("Fname", Fname.getText().toString());
                editor.putString("Lname", Lname.getText().toString());
                editor.commit();
            }
        });
        Fname = findViewById(R.id.Fname);
        Lname = findViewById(R.id.Lname);
        tvName = findViewById(R.id.tvDisplay);

        sp = getSharedPreferences("datalist1", 0);
        String strFname = sp.getString("Fname", null);
        String strLname = sp.getString("Lname", null);
        if(strFname != null && strLname != null)
            tvName.setText(tvName.getText().toString() + " " + strFname + " " + strLname);

    }
}