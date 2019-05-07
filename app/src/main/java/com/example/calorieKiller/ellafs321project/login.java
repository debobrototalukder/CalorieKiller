
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



public class login extends AppCompatActivity {

    Button login;
    Button register;
    Button send;
    Button forgotPassword;

    EditText email;
    EditText password;
    EditText emailFP;

    Dialog forgotPassDialog;


    //CHANGE
    FirebaseAuth firebaseAuth;
    FirebaseAuth.AuthStateListener authlisten;
    ProgressDialog pd;
    DatabaseReference dr1;
    FirebaseAuth firebaseAuth2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Toast.makeText(this,"Login screen reached",Toast.LENGTH_SHORT).show();
        setContentView(R.layout.login);
        login=(Button) findViewById(R.id.login_button);
        //thinking 2 - Part B

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //thinking 2
                Intent i = new Intent(login.this, mainpage.class);
                startActivity(i);

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Signin();

            }
        });


        register=(Button)findViewById(R.id.register_button);

        //CHANGE
        //POINT 1
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(login.this, register.class); ////SCREENCHANGECHECK CHANGE -- check if its correct
                startActivity(i);
            }
        });


        forgotPassword=(Button) findViewById(R.id.forgot_pass_button);

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(login.this, forgot_pw.class); ////SCREENCHANGECHECK CHANGE -- check if its correct
                startActivity(i);

            }
        });
        email=(EditText) findViewById(R.id.emailETAM);
        password=(EditText) findViewById(R.id.passwordETAM);
        send=(Button)findViewById(R.id.sendBFP);
        emailFP=(EditText) findViewById(R.id.emailETFP);

        //CHANGE
        firebaseAuth = FirebaseAuth.getInstance();
        authlisten = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if(firebaseAuth.getCurrentUser()!=null){

                    startActivity(new Intent(login.this, mainpage.class));		//SCREENCHANGECHECK - from login successful to which screen

                }
            }
        };

        firebaseAuth2= FirebaseAuth.getInstance();


        pd = new ProgressDialog(this);

        dr1 = FirebaseDatabase.getInstance().getReference().child("All Users");

        //CHANGE

        //forgotPassDialog=new Dialog(this);
        //forgotPassDialog.setContentView(R.layout.forgot_pass_dialog);


        /*
        Window dialogWindow = forgotPassDialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        //dialogWindow.setGravity(Gravity.LEFT | Gravity.TOP);
        //lp.x = 100; // The new position of the X coordinates
        //lp.y = 100; // The new position of the Y coordinates
        lp.width = 1000; // Width
        lp.height = 600; // Height
        dialogWindow.setAttributes(lp);
        */



    }//End of On Create


    @Override
    protected void onStart(){
        super.onStart();
        firebaseAuth.addAuthStateListener(authlisten);
    }

    //Doubt 2
    public void login_button_clicked(View view){
        String email;
        String password;

        //email=this.email.getText().toString();
        //password=this.password.getText().toString();


        Toast.makeText(this,"login Button Clicked",Toast.LENGTH_SHORT).show();
        Signin();
    }

    private void Signin()
    {

        String email_here,pass_here;

        email_here = email.getText().toString();
        pass_here = password.getText().toString();

        if(TextUtils.isEmpty(email_here))
        {

            Toast.makeText(login.this,"Enter Email",Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(pass_here))
        {
            Toast.makeText(login.this,"Enter Password",Toast.LENGTH_SHORT).show();
            return;
        }

        pd.setMessage("Trying To Login");
        pd.show();

        firebaseAuth.signInWithEmailAndPassword(email_here,pass_here).addOnCompleteListener(new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {

                if(task.isSuccessful())
                {
                    pd.dismiss();
                    String userId = firebaseAuth.getCurrentUser().getUid();
                    dr1.addValueEventListener(new ValueEventListener()
                    {

                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot)
                        {

                            if (dataSnapshot.hasChild(firebaseAuth.getCurrentUser().getUid()))
                            {
                                FirebaseUser firebaseUser = firebaseAuth.getInstance().getCurrentUser();
                                Boolean email_flag = firebaseUser.isEmailVerified();

                                if (email_flag){
                                    startActivity(new Intent(login.this, mainpage.class)); //SCREENCHANGECHECK //To change from which screen to which screen
                                }
                                else {

                                    startActivity(new Intent(login.this, login.class));
                                    Toast.makeText(login.this, "Verify your email",Toast.LENGTH_SHORT).show();
                                    firebaseAuth.signOut();
                                }

                            }
                            else
                            {

                                Toast.makeText(login.this,"You Need To Create An Account",Toast.LENGTH_SHORT).show();
                                //startActivity(new Intent(login.this, login.class)); //SCREENCHANGECHECK //To change from which screen to which screen
                                //startActivity(new Intent(login.this, register.class));
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError)
                        {


                        }

                    });

                    Toast.makeText(login.this,"Welcome!",Toast.LENGTH_SHORT).show();
                    //startActivity CHANGE CHECK (if it doesnt work then try here , but avoid since authentication thing )
                }
                else
                {
                    pd.dismiss();
                    Toast.makeText(login.this,"Error! Make Sure you have been Registered before Logging in! ",Toast.LENGTH_SHORT).show();
                }
            }
        });




    }//End Of Signin


    /*//Doubt 3 - Does this even work?
    public void register_button_clicked(View view){
        //Toast.makeText(null,"login Button Clicked",Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,register.class);
        startActivity(intent);

    }*/

    public void forgotPass_button_clicked(View view){
        this.forgotPassDialog.show();
    }

    public void sendButtonClicked(View view){
        //String email;
        //email=emailFP.getText().toString();
        Toast.makeText(this,"Check your mail",Toast.LENGTH_SHORT).show();

    }
}

