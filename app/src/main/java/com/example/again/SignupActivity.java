package com.example.again;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupActivity extends AppCompatActivity {
LinearLayout Signubttnfinal,Loginbttnfinal;
private FirebaseAuth mAuth;
EditText editemail,editpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Signubttnfinal=findViewById(R.id.main_signupbttnfinal);
        Loginbttnfinal=findViewById(R.id.main_loginbttnfinal);
  mAuth=FirebaseAuth.getInstance();
        editemail=findViewById(R.id.signup_email);
        editpassword=findViewById(R.id.signup_password);

        Loginbttnfinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


        Signubttnfinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
String email=editemail.getText().toString();
                String password=editpassword.getText().toString();
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
Intent intent=new Intent(SignupActivity.this,Dashboard.class);
startActivity(intent);
finish();
                        }else{
                            Toast.makeText(SignupActivity.this,"Error",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.

        if(mAuth.getCurrentUser()!=null){
            startActivity(new Intent(this,Dashboard.class));
            finish();
        }
    }
    protected void onResume(){
        super.onResume();


    }

}