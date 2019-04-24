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
import android.widget.TextView;
import android.widget.Toast;

public class connection extends AppCompatActivity {

    ImageButton Play;
    ImageButton Pause;
    ImageButton Stop;
    ImageButton loggout;
    Dialog forgotPassDialog;
    TextView helpTV;
    Button okayButton;
    Button helpButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);
        this.okayButton=(Button)findViewById(R.id.okayButton);
        this.helpTV=(TextView) findViewById(R.id.helpTV1);
        this.helpButton=(Button) findViewById(R.id.helpButton);
//        Pause = (ImageButton) findViewById(R.id.Pause_button);
//        Stop = (ImageButton) findViewById(R.id.Stop_button);
//
//      loggout = (ImageButton) findViewById(R.id.loggoutbutton);
//        loggout.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View v) {
//                Intent intentTheGame = new Intent(connection.this, login.class);
//                startActivity(intentTheGame);
//            }
//        });


        forgotPassDialog=new Dialog(this);
        forgotPassDialog.setContentView(R.layout.help);
        Window dialogWindow = forgotPassDialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        //dialogWindow.setGravity(Gravity.LEFT | Gravity.TOP);
        //lp.x = 100; // The new position of the X coordinates
        //lp.y = 100; // The new position of the Y coordinates
        lp.width = 1000; // Width
        lp.height = 600; // Height
        dialogWindow.setAttributes(lp);




    }

    public void logoutClicked(View v){
        // Intent is what you use to start another activity
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }


    public void PlayButtonClicked(View v){

    }

    public void helpButtonPressed(View v){
        this.forgotPassDialog.show();
    }

    public void okayButtonPressed(View v){
        this.forgotPassDialog.dismiss();
    }

    public void pauseButtonClicked(View v){

    }


    public void stopButtonClicked(View v){

    }



}