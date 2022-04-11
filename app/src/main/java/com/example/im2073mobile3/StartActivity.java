package com.example.im2073mobile3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StartActivity extends AppCompatActivity {
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        configureStartButton();
    }

    private void configureStartButton() {
        btnStart = (Button) findViewById(R.id.start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Conn conn = new Conn();
//                conn.execute("");
//                Intent intent = new Intent(StartActivity.this, MainActivity.class);
//                intent.putExtra("conn", conn);
//                startActivity(intent);
                startActivity(new Intent(StartActivity.this, MainActivity.class));
            }
        });
    }
}