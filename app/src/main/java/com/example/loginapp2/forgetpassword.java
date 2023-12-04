package com.example.loginapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgetpassword extends AppCompatActivity {

    TextView backtologinobj;
     Button btnrecoverobj;
     EditText edtemailobj;
   FirebaseAuth mauth;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);

        backtologinobj=findViewById(R.id.backtologin);
        btnrecoverobj=findViewById(R.id.btnrecover);
        edtemailobj=findViewById(R.id.edtemail);
         mauth= FirebaseAuth.getInstance();

        backtologinobj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(forgetpassword.this,MainActivity.class);
                startActivity(i);
            }
        });

        btnrecoverobj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email=edtemailobj.getText().toString();

                if(!TextUtils.isEmpty(email))
                {
                    Resetpassword();
                }
                else
                {
                    edtemailobj.setError("email fiels can't be empty");
                }
            }
        });


    }



    private  void Resetpassword()
    {
        mauth.sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                      Toast.makeText(getApplicationContext(),"email sent",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(forgetpassword.this,MainActivity.class);
                startActivity(i);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"error occured",Toast.LENGTH_SHORT).show();
            }
        });

    }
}