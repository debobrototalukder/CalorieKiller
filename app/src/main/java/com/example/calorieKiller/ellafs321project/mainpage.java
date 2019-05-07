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

import com.google.firebase.auth.FirebaseAuth;

public class mainpage extends AppCompatActivity {



    ImageButton profile;
    ImageButton game;
    ImageButton workout;
    ImageButton kalorie;
    ImageButton logout;
    Dialog linkDialoog;
    TextView helpLiink;
    Button okButtoon;
    Button linkButtoon;


    private FirebaseAuth firebaseAuth;




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

        firebaseAuth = FirebaseAuth.getInstance();
        logout = (ImageButton) findViewById(R.id.logoutbutton);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                finish();
                Intent intent = new Intent(mainpage.this, login.class);
                startActivity(intent);
            }
        });

        this.okButtoon=(Button)findViewById(R.id.okButtoon);
        this.helpLiink=(TextView) findViewById(R.id.helpLiink);
        this.linkButtoon=(Button) findViewById(R.id.linkButton);

        linkDialoog=new Dialog(this);
        linkDialoog.setContentView(R.layout.infomain);
        Window dialogWindow = linkDialoog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        //dialogWindow.setGravity(Gravity.LEFT | Gravity.TOP);
        //lp.x = 100; // The new position of the X coordinates
        //lp.y = 100; // The new position of the Y coordinates
        lp.width = 1000; // Width
        lp.height = 600; // Height
        dialogWindow.setAttributes(lp);


        profile = (ImageButton) findViewById(R.id.profile);

        game = (ImageButton) findViewById(R.id.game);

        workout = (ImageButton) findViewById(R.id.workout);

        kalorie = (ImageButton) findViewById(R.id.kalorie);


    }


    public void linkButtonPressed(View v){
        this.linkDialoog.show();
    }

    public void okButtonPressed(View v){
        this.linkDialoog.dismiss();
    }



}
