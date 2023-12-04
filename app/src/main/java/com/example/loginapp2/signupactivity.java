package com.example.loginapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class signupactivity extends AppCompatActivity {

    TextView signinbtnobj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupactivity);

        signinbtnobj = findViewById(R.id.signinbtn);
        signinbtnobj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(signupactivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}