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

public class LoginActivity extends AppCompatActivity {
    EditText logineditemail,logineditpassword;
    LinearLayout loginn,signup;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        logineditemail=findViewById(R.id.login_email);
        logineditpassword=findViewById(R.id.login_password);
        mAuth=FirebaseAuth.getInstance();
        loginn=findViewById(R.id.login_loginbttnfinal);
        signup=findViewById(R.id.login_signupbttnfinal);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });

        loginn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=logineditemail.getText().toString();
                String password=logineditpassword.getText().toString();
                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent intent=new Intent(LoginActivity.this,Dashboard.class);
                            startActivity(intent);
                            finish();
                        }else{
                            Toast.makeText(LoginActivity.this,"Error...........",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        // If user logged in, go to sign-in screen
        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(this, Dashboard.class));
            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }


}