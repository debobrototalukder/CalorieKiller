package com.example.calorieKiller.ellafs321project;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class numplayers extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numplayers);



    }







    public void create_button_clicked(View v){
        Intent intent = new Intent(this, pin.class);
        startActivity(intent);

    }


    public void join_button_clicked(View view){
        Intent intent = new Intent(this, havepin.class);
        startActivity(intent);
    }


}