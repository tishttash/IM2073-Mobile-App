//package com.example.im2073mobile3;
//
//import static com.github.mikephil.charting.utils.ColorTemplate.MATERIAL_COLORS;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.graphics.Color;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.view.View;
//
//import com.github.mikephil.charting.charts.BarChart;
//import com.github.mikephil.charting.data.BarData;
//import com.github.mikephil.charting.data.BarDataSet;
//import com.github.mikephil.charting.data.BarEntry;
//import com.github.mikephil.charting.utils.ColorTemplate;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//public class BarChartActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_bar_chart);
//
//        BarChart barChart = findViewById(R.id.barChart);
//
//        String msg = "";
//
//        try
//        {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            if(conn == null)
//            {
//                msg = "conn == null";
//            }
//            else
//            {
//                String query = "SELECT * from counter";
//                //TODO: add sql statement to reset counter table values to 0 0 0 0
//                Statement stmt = conn.createStatement();
//                ResultSet resultSet = stmt.executeQuery(query);
//
//                while(resultSet.next())
//                {
//                    ArrayList<BarEntry> clicks = new ArrayList<>();
//                    clicks.add(new BarEntry(1, resultSet.getInt(1)));
//                    clicks.add(new BarEntry(2, resultSet.getInt(2)));
//                    clicks.add(new BarEntry(3, resultSet.getInt(3)));
//                    clicks.add(new BarEntry(4, resultSet.getInt(4)));
//
//                    BarDataSet barDataSet = new BarDataSet(clicks, "Results");
//                    barDataSet.setColors(MATERIAL_COLORS);
//                    barDataSet.setValueTextColor(Color.DKGRAY);
//                    barDataSet.setValueTextSize(18f);
//
//                    BarData barData = new BarData(barDataSet);
//
//                    barChart.setFitBars(true);
//                    barChart.setData(barData);
//                    barChart.getDescription().setText("Question Results");
//                    barChart.animateY(2000);
//                }
//                // msg = "LOADED | " + "Ans: " + answer;
//            }
//            conn.close();
//        }
//
//        catch (Exception e)
//        {
//            msg = "fetch error";
//            e.printStackTrace();
//        }
//
//    }
//}