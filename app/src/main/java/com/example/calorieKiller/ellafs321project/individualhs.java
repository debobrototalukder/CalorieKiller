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

public class individualhs extends AppCompatActivity {

    ImageButton nxt;

    Dialog forgotPassDialog1;
    TextView help1TV;
    Button okayButton;
    Button helpButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_hs);
        this.okayButton=(Button)findViewById(R.id.okayButton);
        this.help1TV=(TextView) findViewById(R.id.helpTV1);
        this.helpButton=(Button) findViewById(R.id.helpButton);



        forgotPassDialog1=new Dialog(this);
        forgotPassDialog1.setContentView(R.layout.help4);
        Window dialogWindow = forgotPassDialog1.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        //dialogWindow.setGravity(Gravity.LEFT | Gravity.TOP);
        //lp.x = 100; // The new position of the X coordinates
        //lp.y = 100; // The new position of the Y coordinates
        lp.width = 1000; // Width
        lp.height = 600; // Height
        dialogWindow.setAttributes(lp);




    }





    public void helpButtonPressed2(View v){
        this.forgotPassDialog1.show();
    }

    public void okButtonPressed(View v){
        this.forgotPassDialog1.dismiss();
    }


    public void nxxtButtonClicked(View view) {

        Intent intent = new Intent(this, individualht.class);
        startActivity(intent);
    }
}