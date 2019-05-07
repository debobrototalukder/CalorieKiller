package com.example.calorieKiller.ellafs321project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profile extends AppCompatActivity {

    Button editProfileButton;
    final Context context=this;

    //private ImageView profile_pic;
    private TextView profile_name,profile_age,profile_height,profile_weight,profile_email,profile_gender;
    public static final String GenderString = "genderString";

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference reff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //profile_pic = findViewById(R.id.receive_image);
        profile_name = findViewById(R.id.receive_name);
        profile_age = findViewById(R.id.receive_age);
        profile_height = findViewById(R.id.receive_height);
        profile_weight = findViewById(R.id.receive_weight);
        profile_email = findViewById(R.id.receive_email);
        profile_gender = findViewById(R.id.receive_gender);

        final SharedPreferences.Editor editor = getSharedPreferences(GenderString, MODE_PRIVATE).edit();



        editProfileButton=(Button) findViewById(R.id.editprofile);

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
                //GenderString = dataSnapshot.child("Gender").getValue().toString();
                Log.d("height", "onDataChange: " + height);
                editor.putString("gender", gender);
                editor.putInt("age", Integer.parseInt(age));
                editor.putInt("weight", Integer.parseInt(weight));
                editor.apply();


                profile_weight.setText(weight);
                profile_height.setText(height);
                profile_age.setText(age);
                profile_name.setText(name);
                profile_email.setText(email);
                profile_gender.setText(gender);
                //profile_gender.setText(GenderString);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
    public void editProfileButtonClicked(View v)
    {
        Intent i = new Intent(context, editprofile.class);
        startActivity(i);
    }
}
