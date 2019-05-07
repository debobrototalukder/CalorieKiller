package com.example.calorieKiller.ellafs321project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class individual extends AppCompatActivity {




    ImageButton advancedChoice;
    ImageButton beginnerChoice;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual);
        advancedChoice=(ImageButton)findViewById(R.id.hard);
        beginnerChoice=(ImageButton) findViewById(R.id.easy);





      }

    public void advancedButtonClicked(View v){

        Intent intent = new Intent(this, individualhf.class);
        startActivity(intent);


    }

    public void beginnerButtonClicked(View v){

        Intent intent = new Intent(this, individualef.class);
        startActivity(intent);

    }


}
