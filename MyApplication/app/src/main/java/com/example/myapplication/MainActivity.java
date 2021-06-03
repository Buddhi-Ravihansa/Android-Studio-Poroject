package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String userName= "user123";
    private String passWord= "pass123";
    private int attemptsCount= 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button =findViewById(R.id.btn_login);
        EditText enterUsername= findViewById(R.id.edit_username);
        EditText enterPassword= findViewById(R.id.edit_password);
        TextView testResults= findViewById(R.id.attempts_left);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String entUserName = enterUsername.getText().toString();
                String entUserPassword = enterPassword.getText().toString();
                if (attemptsCount > 0) {
                    if (entUserName.equals(userName) && entUserPassword.equals(passWord)) {
                        testResults.setText("Login Successfull...");
                    } else {
                        testResults.setText("Login Error.." + "Attempts Left:" + attemptsCount);
                        attemptsCount = attemptsCount - 1;
                    }
                } else {
                    testResults.setText("Please try again Later...");
                    attemptsCount = 5;
                }
            }
        });
    }
}