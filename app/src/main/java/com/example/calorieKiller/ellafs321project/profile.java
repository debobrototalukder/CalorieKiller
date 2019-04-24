package com.example.calorieKiller.ellafs321project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class profile extends AppCompatActivity {

    Button editProfileButton;
    final Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        editProfileButton=(Button) findViewById(R.id.editprofile);

    }
    public void editProfileButtonClicked(View v)
    {
        Intent i = new Intent(context, editprofile.class);
        startActivity(i);
    }
}
