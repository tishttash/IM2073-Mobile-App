package com.example.im2073mobile3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    EditText editText;
    private static final String DB_URL = "jdbc:mysql://192.168.1.161/MCQ";
    private static final String USER = "user1";
    private static final String PASS = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        editText = (EditText) findViewById(R.id.textInputEditText);
    }

    public void btnConn(View view) {
        Send objSend = new Send();
        objSend.execute("");
    }

    private class Send extends AsyncTask<String, String, String>
    {
        String msg = "";
        String text = editText.getText().toString();

        @Override
        protected void onPreExecute() {textView2.setText("Please Wait...");}

        @Override
        protected String doInBackground(String... strings)
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                if(conn == null)
                {
                    msg = "Connection unsuccessful: conn == null";
                }
                else
                {
                    String query = "INSERT into questionnaire (question) VALUES ('"+text+"')";
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate(query);
                    msg = "Insert successful!";
                }
                conn.close();
            }
            catch (Exception e)
            {
                msg = "Connection unsuccessful: insert to database error.";
                e.printStackTrace();
            }
            return msg;
        }

        @Override
        protected void onPostExecute(String msg)
        {
            textView2.setText(msg);
        }
    }
}