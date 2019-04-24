package com.example.calorieKiller.ellafs321project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class individual extends AppCompatActivity {



    ImageButton Back;
    ImageButton advancedChoice;
    ImageButton beginnerChoice;


    public void BackButtonClicked(View v){
        Intent intent = new Intent(this, mainpage.class);
        startActivity(intent);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual);
        advancedChoice=(ImageButton)findViewById(R.id.hard);
        beginnerChoice=(ImageButton) findViewById(R.id.easy);



        Back = (ImageButton) findViewById(R.id.backbutton);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTheGame = new Intent(individual.this, mainpage.class);
                startActivity(intentTheGame);
            }
        });

      }

    public void advancedButtonClicked(View v){



    }

    public void beginnerButtonClicked(View v){

        Intent intent = new Intent(this, connection.class);
        startActivity(intent);

    }


}
