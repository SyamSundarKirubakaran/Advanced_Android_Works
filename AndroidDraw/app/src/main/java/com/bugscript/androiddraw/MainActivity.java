package com.bugscript.androiddraw;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.LeadingMarginSpan;
import android.util.Log;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.io.LineNumberReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    PieChart pieChart;
    String sample;
    String[] arr1;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pieChart=findViewById(R.id.piechart);

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5,10,5,5);

        pieChart.setDragDecelerationFrictionCoef(0.9f);

        pieChart.setDrawHoleEnabled(false);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f);

        ArrayList<PieEntry> yValues=new ArrayList<>();

        yValues.add(new PieEntry(34,"CSK"));
        yValues.add(new PieEntry(23,"RCB"));
        yValues.add(new PieEntry(15,"SRH"));
        yValues.add(new PieEntry(40,"RR"));
        yValues.add(new PieEntry(50,"KKR"));
        yValues.add(new PieEntry(9,"MI"));
        yValues.add(new PieEntry(33,"DD"));
        yValues.add(new PieEntry(51,"KXIP"));

        pieChart.animateY(1000, Easing.EasingOption.EaseInOutExpo);

        PieDataSet dataSet=new PieDataSet(yValues,"Teams");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
//        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        dataSet.setColors(new int[]{R.color.csk,R.color.rcb,R.color.srh,R.color.rr,R.color.kkr,R.color.mi,R.color.dd,R.color.kxip},getApplicationContext());

        PieData data=new PieData(dataSet);
        data.setValueTextColor(Color.YELLOW);
        data.setValueTextSize(10f);

        pieChart.setData(data);
        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                sample=e.toString();
                arr1=sample.split(":",-1);
                switch (arr1[2]){
                    case " 34.0":
                        Toast.makeText(MainActivity.this,"CSK",Toast.LENGTH_LONG).show();
                        break;
                    case " 23.0":
                        Toast.makeText(MainActivity.this,"RCB",Toast.LENGTH_LONG).show();
                        break;
                    case " 15.0":
                        Toast.makeText(MainActivity.this,"SRH",Toast.LENGTH_LONG).show();
                        break;
                    case " 40.0":
                        Toast.makeText(MainActivity.this,"RR",Toast.LENGTH_LONG).show();
                        break;
                    case " 50.0":
                        Toast.makeText(MainActivity.this,"KKR",Toast.LENGTH_LONG).show();
                        break;
                    case " 9.0":
                        Toast.makeText(MainActivity.this,"MI",Toast.LENGTH_LONG).show();
                        break;
                    case " 33.0":
                        Toast.makeText(MainActivity.this,"DD",Toast.LENGTH_LONG).show();
                        break;
                    case " 51.0":
                        Toast.makeText(MainActivity.this,"KXIP",Toast.LENGTH_LONG).show();
                        break;
                }
            }

            @Override
            public void onNothingSelected() {
                Toast.makeText(MainActivity.this,"Nothing selected..",Toast.LENGTH_LONG).show();
            }
        });
    }
}
