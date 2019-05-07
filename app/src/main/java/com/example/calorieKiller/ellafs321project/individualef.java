package com.example.calorieKiller.ellafs321project;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class individualef extends AppCompatActivity {

    ImageButton nxt;

    Dialog forgotPassDialog;
    TextView helpTV;// in help
    Button okayButton; //in help
    Button helpButton; //in xml ef



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.individual_ef);
        this.okayButton=(Button)findViewById(R.id.okayButton);
        this.helpTV=(TextView) findViewById(R.id.helpTV1);
        this.helpButton=(Button) findViewById(R.id.helpButton);

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





    public void helpButtonPressed(View v){
        this.forgotPassDialog.show();
    }

    public void okayButtonPressed(View v){
        this.forgotPassDialog.dismiss();
    }


    public void nxtButtonClicked(View view) {

        Intent intent = new Intent(this, individuales.class);
        startActivity(intent);
    }
}