package com.example.again;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
LinearLayout login,signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=findViewById(R.id.main_loginbttn);
        signup=findViewById(R.id.main_signupbttn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Intent intent=new Intent(MainActivity.this,LoginActivity.class);
startActivity(intent);
finish();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SignupActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}