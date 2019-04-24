package com.example.calorieKiller.ellafs321project;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class graph extends AppCompatActivity {
PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        pieChart = (PieChart) findViewById(R.id.piechart);
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5,10,5,5);
        pieChart.setDragDecelerationFrictionCoef(0.95f);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(android.R.color.white);
        pieChart.setTransparentCircleRadius(61f);
        pieChart.setTouchEnabled(false);

        ArrayList<PieEntry>  yValues = new ArrayList <> ();
        yValues.add(new PieEntry(23f, "jumping jacks"));
        yValues.add(new PieEntry(50, "running"));


        PieDataSet dataSet = new PieDataSet(yValues,"Calories burned");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setSliceSpace(5);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        PieData data = new PieData((dataSet));
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.YELLOW);
        pieChart.setData(data);
    }
}
