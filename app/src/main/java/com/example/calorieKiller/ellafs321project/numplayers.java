package com.example.calorieKiller.ellafs321project;

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

    Spinner numberOfPlayers;
    Button Next;
    ImageButton Back;

    ImageButton MultipleChoice;
    String mode="NULL";
    ImageButton profile;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numplayers);
        Next=(Button) findViewById(R.id.Next_button);
        numberOfPlayers=findViewById(R.id.numberOfPlayersSpinner);
        MultipleChoice=(ImageButton) findViewById(R.id.uzerz);
        String[] items = new String[]{"1","2","3","4","5"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        numberOfPlayers.setAdapter(adapter);
        numberOfPlayers.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

    }
    public void Next_button_clicked(View v) {
        if (mode.equals("NULL")) {
            Toast.makeText(this, "Please choose a mode", Toast.LENGTH_SHORT).show();
        } else{
            Intent intent=new Intent(this,connection.class);
            intent.putExtra("TYPE",mode);

            startActivity(intent);
        }

    }
    public void home_ButtonClicked(View v){

    }


    public void MultiButtonClicked(View v){
        mode="Multiple";
        Toast.makeText(this,"Multiple mode chosen",Toast.LENGTH_SHORT).show();

    }


}