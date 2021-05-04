package com.example.itrack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DecimalFormat;

public class bbt_testing extends AppCompatActivity {
    EditText  yValue;
    Button btn_insert;
    FirebaseDatabase database;
    DatabaseReference reference;
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-dd-MM");
    DecimalFormat df2 = new DecimalFormat("#.##");
    GraphView graphView;
    LineGraphSeries series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbt_testing);

       yValue = findViewById(R.id.yValue);
       btn_insert = findViewById(R.id.btn_insert);
       graphView = (GraphView) findViewById(R.id.graphView);
       series= new LineGraphSeries();
       graphView.addSeries(series);
       database = FirebaseDatabase.getInstance();
       reference = database.getReference("ChartTable");

       setListeners();

       graphView.getGridLabelRenderer().setNumHorizontalLabels(3);

       graphView.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
           @Override
           public String formatLabel(double value, boolean isValueX) {
               if (isValueX){
                   return  sdf.format(new Date((long) value));
               }else{
                   return super.formatLabel(value, isValueX);
               }

           }
       });

    }

    private void setListeners() {
        btn_insert.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = reference.push().getKey();
                long x=new Date().getTime();
                double y= Double.parseDouble(yValue.getText().toString());

                PointValues pointValues = new PointValues(x,y);

                reference.child(id).setValue(pointValues);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataPoint[] dp = new DataPoint[(int) snapshot.getChildrenCount()];
                int index= 0;
                for(DataSnapshot myDataSnapshot: snapshot.getChildren())
                {
                 PointValues pointValues =  myDataSnapshot.getValue(PointValues.class);

                 dp[index] = new DataPoint(pointValues.getxValue(),pointValues.getyValue());
                 index++;

                }
                series.resetData(dp);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}