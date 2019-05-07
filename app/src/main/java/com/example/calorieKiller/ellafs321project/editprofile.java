package com.example.calorieKiller.ellafs321project;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class editprofile extends AppCompatActivity {


    private EditText edit_name,edit_height,edit_age,edit_weight,edit_gender,edit_password;

    private Button save;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference reff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);

        edit_name = findViewById(R.id.name_edit_profile);
        edit_age = findViewById(R.id.age_edit_profile);
        edit_height = findViewById(R.id.height_edit_profile);
        edit_weight = findViewById(R.id.weight_edit_profile);
        edit_gender = findViewById(R.id.gender_edit_profile);
        // edit_password = findViewById(R.id.password_edit_profile);

        save = findViewById(R.id.savebutton_edit_profile);


        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        reff = FirebaseDatabase.getInstance().getReference().child("All Users").child(firebaseAuth.getUid());

        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String name = dataSnapshot.child("First Name").getValue().toString();
                String age = dataSnapshot.child("Age").getValue().toString();
                String email = dataSnapshot.child("Email").getValue().toString();
                String height = dataSnapshot.child("Height").getValue().toString();
                String weight = dataSnapshot.child("Weight").getValue().toString();
                String gender = dataSnapshot.child("Gender").getValue().toString();

                edit_weight.setText(weight);
                edit_height.setText(height);
                edit_age.setText(age);
                edit_name.setText(name);
                edit_gender.setText(gender);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = edit_name.getText().toString();
                String age = edit_age.getText().toString();
                String weight = edit_weight.getText().toString();
                String height = edit_height.getText().toString();
                String gender = edit_gender.getText().toString();
                String gender_modified_male = "Male";
                String gender_modified_female = "Male";

                if(TextUtils.isEmpty(name)){
                    Toast.makeText(editprofile.this, "Please Input Name", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(age)){
                    Toast.makeText(editprofile.this, "Please Input Age", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(height)){
                    Toast.makeText(editprofile.this, "Please Input Height (in cm)", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(weight)){
                    Toast.makeText(editprofile.this, "Please Input Weight (in kg) ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(gender)){
                    Toast.makeText(editprofile.this, "Please Input Gender (M/F/Other)", Toast.LENGTH_SHORT).show();
                    return;
                }


                String userid = firebaseAuth.getCurrentUser().getUid();
                DatabaseReference dr = reff;
                dr.child("First Name").setValue(name);
                dr.child("Age").setValue(age);
                dr.child("Height").setValue(height);
                dr.child("Weight").setValue(weight);
                if((gender == "m") || (gender == "M"))
                {
                    dr.child("Gender").setValue(gender_modified_male);
                }else
                {
                    dr.child("Gender").setValue(gender_modified_female);
                }

                /*
                String updated_password = edit_password.getText().toString();
                FirebaseUser fb_user;
                FirebaseAuth fb_auth;
                fb_user= FirebaseAuth.getInstance().getCurrentUser();
                fb_user.updatePassword(updated_password).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                    }
                });*/



                edit_weight.setText(weight);
                edit_height.setText(height);
                edit_age.setText(age);
                edit_name.setText(name);
                edit_gender.setText(gender);


                Toast.makeText(editprofile.this, "Saved Successfully!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(editprofile.this, profile.class)); //CHECK

            }
        });

    }


}

