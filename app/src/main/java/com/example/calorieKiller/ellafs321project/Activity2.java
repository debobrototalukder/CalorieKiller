package com.example.calorieKiller.ellafs321project;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Activity2 extends Activity {
    TextView text;
    long time;
    String gender;
    int age, weight;
    //private TextView profile_heightCalc,profile_weightCalc,profile_genderCalc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        SharedPreferences prefs = getSharedPreferences("genderString", MODE_PRIVATE);
        //String restoredText = prefs.getString("text", null);
        //Log.d("", "onCreate: " + restoredText);
        // (restoredText != null) {
            gender = prefs.getString("gender", "No name defined");//"No name defined" is the default value.
            age = prefs.getInt("age", 0); //0 is the default value.
            weight = prefs.getInt("weight", 0); //0 is the default value.
        //}
        //profile_heightCalc = findViewById(R.id.receive_height);
        //profile_weightCalc = findViewById(R.id.receive_weight);
        //profile_genderCalc = findViewById(R.id.receive_gender);
        text = (TextView) findViewById(R.id.calcText);
        Log.d("Reached here,","Hello");
        Log.d("Gender", gender);
        Log.d("age", age + "");
        Log.d("weight", weight + "");

        String file= getIntent().getStringExtra("filename");
        time = getIntent().getLongExtra("time", 0);

        read_file(file);

    }


    public String read_file(String filename) {
        try {
            List<Integer> col = new ArrayList<Integer>();
            FileInputStream fis = new FileInputStream(filename);
            //FileInputStream fis = getApplicationContext().openFileInput(filename);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line).append("\n");
                col.add(Integer.valueOf(line));
            }
            Log.d("wtf",sb.toString());
            Log.d("sizeOFCOL"," "+col.size());
            //text.setText(sb.toString());
            CaloriesCalc(col);
            return sb.toString();
        } catch (FileNotFoundException e) {
            return "";
        } catch (UnsupportedEncodingException e) {
            return "";
        } catch (IOException e) {
            return "";
        }
    }

    public void CaloriesCalc(List<Integer> collection){
        if(collection.size() < 1 )
        {
            text.setText("Empty!!");
            Log.d("Crash", "Entered");
        }
        else {
            float total = 0;
            float avg = 0;
            for (int i = 0; i < collection.size(); i++) {
                total += collection.get(i);
                Log.d("ArrayLIST", "" + collection.get(i));
            }
            avg = total / collection.size();
            Log.d("T0tal:", " " + total);
            Log.d("AveragE:", " " + avg);
            //text.setText(" "+avg);


            //Calories Burned = [(Age x 0.2017) - (Weight x 0.09036) + (Heart Rate x 0.6309) - 55.0969] x Time / 4.184
            double calcBurn = ((age * 0.2017) - (weight * 0.09036) + (avg * 0.6309) - 55.0969) * ((time/60) / 4.184);
            Log.d("TIME2", time + "");
            text.setText(" " + String.format("%.2f", calcBurn) + " Calories");
        }
    }
}
