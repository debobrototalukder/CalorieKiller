
package com.example.calorieKiller.ellafs321project;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class pin extends AppCompatActivity {

    Button okpin;
    Button pintxt;
    Dialog givePinDialog;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);

        okpin=(Button) findViewById(R.id.okPin_button);
        //thinking 2 - Part B



        pintxt=(Button) findViewById(R.id.getpin_button);

    }


    public void okPin_button_clicked(View v){
        Intent intent=new Intent(this,pincreated.class);
        startActivity(intent);

    }

    public void getpin_button_clicked(View v){
        Intent intent=new Intent(this,havepin.class);
        startActivity(intent);

    }





}

