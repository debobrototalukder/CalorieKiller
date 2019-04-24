
package com.example.calorieKiller.ellafs321project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import com.example.calorieKiller.ellafs321project.R;

public class register extends AppCompatActivity
{

    EditText etfname;
    EditText etlname;
    EditText etage;
    EditText etlheight;
    EditText etlweight;
    EditText etlgender;
    EditText password;
    EditText email;
    Button signin1;

    FirebaseAuth firebase_auth;
    ProgressDialog progress_Dialog;
    DatabaseReference database_reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        firebase_auth = FirebaseAuth.getInstance();
        database_reference = FirebaseDatabase.getInstance().getReference().child("All Users");
        progress_Dialog = new ProgressDialog(this);


        etfname=(EditText) findViewById(R.id.etfnameETRP);
        etlname=(EditText) findViewById(R.id.etlnameETRP);
        etage=(EditText) findViewById(R.id.etageETRP);
        password=(EditText) findViewById(R.id.passwordETRP);
        email=(EditText) findViewById(R.id.emailETRP);
        etlheight = (EditText) findViewById(R.id.heightETRP);
        etlweight= (EditText) findViewById(R.id.weightETRP);
        etlgender=(EditText) findViewById(R.id.genderETRP);
        signin1=findViewById(R.id.signup_button);

        signin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserRegister();


            }
        });
    }



    private void UserRegister() {

        final String email1,pass1,fname1,lname1,age12,pass2,height,weight,gender;

        email1 = email.getText().toString();
        pass1 = password.getText().toString();
        pass2 = password.getText().toString();
        height = etlheight.getText().toString();
        weight = etlweight.getText().toString();
        gender = etlgender.getText().toString();


        //would be resolved only when first name and last name are added and age variable
        fname1 = etfname.getText().toString();
        lname1 = etlname.getText().toString();
        age12 = etage.getText().toString();

        if(TextUtils.isEmpty(fname1)){
            Toast.makeText(register.this, "Please Input First Name", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(age12)){
            Toast.makeText(register.this, "Please Input Age", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(height)){
            Toast.makeText(register.this, "Please Input Height (in cm)", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(weight)){
            Toast.makeText(register.this, "Please Input Weight (in kg) ", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(gender)){
            Toast.makeText(register.this, "Please Input Gender (M/F/Other)", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(email1)){
            Toast.makeText(register.this, "Please Input an Email", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(pass1)){
            Toast.makeText(register.this, "Please Input a Password", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass2)){
            Toast.makeText(register.this, "Please Input Confirmation Password", Toast.LENGTH_SHORT).show();
            return;
        }
        /*
        if(pass1 == pass2){
            progress_Dialog.dismiss();
            Toast.makeText(register.this , "Password and Confirmation Password are not same! Please Enter Again.", Toast.LENGTH_SHORT).show();
            return;

        }*/


        progress_Dialog.setMessage("Registering..");
        progress_Dialog.show();


        firebase_auth.createUserWithEmailAndPassword(email1,pass1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful())
                {
                    String userid = firebase_auth.getCurrentUser().getUid();
                    DatabaseReference dr = database_reference.child(userid);
                    dr.child("First Name").setValue(fname1);
                    dr.child("Last Name").setValue(lname1);
                    dr.child("Age").setValue(age12);
                    dr.child("Height").setValue(height);
                    dr.child("Weight").setValue(weight);
                    dr.child("Gender").setValue(gender);
                    dr.child("Email").setValue(email1);

                    //startActivity(new Intent(register.this, login.class)); //CHECK
                    Toast.makeText(register.this, "Successfully Registered! Verification mail has been sent on your registered email id.", Toast.LENGTH_SHORT).show();
                    sendEmailVerification();
                    startActivity(new Intent(register.this, login.class)); //CHECK

                }
                else
                {
                    progress_Dialog.dismiss();

                    Toast.makeText(register.this, "Registration Error! Please Try Again", Toast.LENGTH_SHORT).show();
                    //CHANGE
                    return;

                }

            }
        });


    }


    private void sendEmailVerification()
    {

        FirebaseUser firebaseUser = firebase_auth.getCurrentUser();
        if (firebaseUser!=null)
        {

            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>()
            {

                @Override
                public void onComplete(@NonNull Task<Void> task)
                {

                    if(task.isSuccessful()){

                        //startActivity(new Intent(register.this, login.class)); //CHECK
                        Toast.makeText(register.this, "Successfully Registered! Verification mail has been sent on your registered email id.", Toast.LENGTH_SHORT).show();
                        firebase_auth.signOut();
                        finish();
                        startActivity(new Intent(register.this, login.class)); //CHECK
                        Toast.makeText(register.this, "Successfully Registered! Verification mail has been sent on your registered email id.", Toast.LENGTH_SHORT).show();
                        //startActivity(new Intent(register.this, login.class)); //CHECK

                    }
                    else{

                        Toast.makeText(register.this , "Error! Cannot send the verification mail! Check  your internet connection.", Toast.LENGTH_SHORT).show();


                    }

                }

            });
        }

    }

}
