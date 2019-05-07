package com.example.calorieKiller.ellafs321project;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgot_pw extends AppCompatActivity {

    EditText email_id;
    FirebaseAuth firebase_Auth2;
    Button sendBFP_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pw);


        firebase_Auth2= FirebaseAuth.getInstance();
        email_id = (EditText) findViewById(R.id.emailETFP);
        sendBFP_1 = findViewById(R.id.sendBFP);

        sendBFP_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String email_1 = email_id.getText().toString();
                if (email_1.isEmpty()) {
                    Toast.makeText(forgot_pw.this, "Enter Email!", Toast.LENGTH_SHORT).show();
                } else {
                    firebase_Auth2.sendPasswordResetEmail(email_1).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(forgot_pw.this, "Password Reset Email Sent", Toast.LENGTH_SHORT).show();
                                finish();
                                Toast.makeText(forgot_pw.this, "Password Reset Email Sent", Toast.LENGTH_SHORT).show();
                                Toast.makeText(forgot_pw.this, "Password Reset Email Sent", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(forgot_pw.this, login.class)); //after reset email is sent - main login page
                            } else {
                                Toast.makeText(forgot_pw.this, "Error in sending password email! Please register first if not registered!", Toast.LENGTH_SHORT).show();


                            }

                        }

                    });
                }
            }


        });



    }

    public void sendButtonClicked(View view) {
    }
}






