package com.example.classapplication;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CustomDialogActivity extends AppCompatActivity {
    Dialog d;
    SharedPreferences sp;
    EditText etUserName, etPassword;
    Button btnCustomLogin, btnLogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom_dialog);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateLoginDialog();
            }
        });
        sp=getSharedPreferences("datalist1", 0);

    }

    public void CreateLoginDialog(){
        d = new Dialog(this);
        d.setContentView(R.layout.custom_layout);
        d.setTitle("Login");
        d.setCancelable(false);
        etUserName=d.findViewById(R.id.etUserName);
        etPassword=d.findViewById(R.id.etPassword);
        btnCustomLogin=d.findViewById(R.id.btnDialogLogin);
        btnCustomLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CustomDialogActivity.this, "username and password saved", Toast.LENGTH_SHORT).show();
                d.dismiss();
            }
        });
        d.show();
    }
}