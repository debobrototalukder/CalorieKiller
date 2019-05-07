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

public class individuales extends AppCompatActivity {

    Dialog linkDialog;
    TextView helpLink;
    Button okButton;
    Button linkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_es);
        this.okButton=(Button)findViewById(R.id.okButton);
        this.helpLink=(TextView) findViewById(R.id.helpLink);
        this.linkButton=(Button) findViewById(R.id.linkButton);


        linkDialog=new Dialog(this);
        linkDialog.setContentView(R.layout.help2);
        Window dialogWindow = linkDialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        //dialogWindow.setGravity(Gravity.LEFT | Gravity.TOP);
        //lp.x = 100; // The new position of the X coordinates
        //lp.y = 100; // The new position of the Y coordinates
        lp.width = 1000; // Width
        lp.height = 600; // Height
        dialogWindow.setAttributes(lp);


    }


    public void linkButtonPressed(View v){
        this.linkDialog.show();
    }

    public void okayButtonPressed(View v){
        this.linkDialog.dismiss();
    }

    public void nxxtButtonClicked(View view) {
        Intent intent = new Intent(this, individualet.class);
        startActivity(intent);
    }


}
