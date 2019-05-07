package com.example.calorieKiller.ellafs321project;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class individualet extends AppCompatActivity {

    Dialog llinkDialog;
    TextView heelpLink;
    Button okkButton;
    Button llinkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.individual_et);

        this.okkButton=(Button)findViewById(R.id.okkButton);
        this.heelpLink=(TextView) findViewById(R.id.heelpLink);
        this.llinkButton=(Button) findViewById(R.id.llinkButton);


        llinkDialog=new Dialog(this);
        llinkDialog.setContentView(R.layout.help3);
        Window dialogWindow = llinkDialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        //dialogWindow.setGravity(Gravity.LEFT | Gravity.TOP);
        //lp.x = 100; // The new position of the X coordinates
        //lp.y = 100; // The new position of the Y coordinates
        lp.width = 1000; // Width
        lp.height = 600; // Height
        dialogWindow.setAttributes(lp);


    }


    public void liinkButtonPressed(View v){
        this.llinkDialog.show();
    }

    public void okButtonPressd(View v){
        this.llinkDialog.dismiss();
    }

    public void homButtonClicked(View view) {
        Intent intent = new Intent(this, mainpage.class);
        startActivity(intent);
    }


}

