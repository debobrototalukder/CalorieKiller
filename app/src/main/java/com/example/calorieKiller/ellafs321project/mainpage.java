package com.example.calorieKiller.ellafs321project;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class mainpage extends AppCompatActivity {



    ImageButton profile;
    ImageButton game;
    ImageButton workout;
    ImageButton music;
    ImageButton kalorie;
    ImageButton logout;


    public void profileButtonClicked(View v){
        // Intent is what you use to start another activity
        Intent intent = new Intent(this, profile.class);
        startActivity(intent);
    }

    public void gameButtonClicked(View v){
        // Intent is what you use to start another activity
        Intent intent = new Intent(this, numplayers.class);
        startActivity(intent);
    }

    public void workoutButtonClicked(View v){
        // Intent is what you use to start another activity
        Intent intent = new Intent(this, individual.class);
        startActivity(intent);
    }

    public void loggoutButtonClicked(View v){
        // Intent is what you use to start another activity
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }

    public void kalorieButtonClicked(View view) {
        // Intent is what you use to start another activity
        Intent intent = new Intent(this, graph.class);
        startActivity(intent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        profile = (ImageButton) findViewById(R.id.profile) ;

        game = (ImageButton) findViewById(R.id.game);


        logout = (ImageButton) findViewById(R.id.logoutbutton);


        workout = (ImageButton) findViewById(R.id.workout);

        kalorie = (ImageButton) findViewById(R.id.kalorie);


    }



    public void musicButtonClicked(View view) {
    }


}
