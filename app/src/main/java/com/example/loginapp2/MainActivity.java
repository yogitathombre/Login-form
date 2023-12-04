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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    TextView signupbtnobj,btnforgotpassobj;
    EditText edt1obj,edt2obj;
    Button btnloginobj;
   FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth=FirebaseAuth.getInstance();

           edt1obj=findViewById(R.id.edt1);
           edt2obj=findViewById(R.id.edt2);
           btnloginobj=findViewById(R.id.btnlogin);
           btnforgotpassobj=findViewById(R.id.btnforgotpass);

           btnloginobj.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   String Email,password;
                   Email=edt1obj.getText().toString();
                   password=String.valueOf(edt2obj.getText());

                   if(TextUtils.isEmpty(Email))
                   {

                       Toast.makeText(getApplicationContext(),"Enter username",Toast.LENGTH_SHORT).show();
                   }

                   if(TextUtils.isEmpty(password))
                   {
                       Toast.makeText(getApplicationContext(),"Enter password",Toast.LENGTH_SHORT).show();
                   }

                   mAuth.createUserWithEmailAndPassword(Email, password)
                           .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                               @Override
                               public void onComplete(@NonNull Task<AuthResult> task) {
                                   if (task.isSuccessful()) {
                                       // Sign in success, update UI with the signed-in user's information
                                       Toast.makeText(MainActivity.this, "Successful login.",
                                               Toast.LENGTH_SHORT).show();

                                   } else {
                                       // If sign in fails, display a message to the user.

                                       Toast.makeText(MainActivity.this, "Authentication failed.",
                                               Toast.LENGTH_SHORT).show();

                                   }
                               }
                           });
               }
           });

             signupbtnobj = findViewById(R.id.signupbtn);
             signupbtnobj.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     Intent i = new Intent(MainActivity.this,signupactivity.class);
                     startActivity(i);
                 }
             });


             btnforgotpassobj.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     Intent i = new Intent(MainActivity.this, forgetpassword.class);
                     startActivity(i);
                 }
             });

    }
}