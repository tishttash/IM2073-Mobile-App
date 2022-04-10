package com.example.im2073mobile3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    TextView textQuestion, textScore, textTimer;
    Button btn1, btn2, btn3, btn4, fetchdb;
    //EditText editText;
    private static final String DB_URL = "jdbc:mysql://192.168.1.161/MCQ";
    private static final String USER = "user1";
    private static final String PASS = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textQuestion = (TextView) findViewById(R.id.textQuestion);
        textScore = (TextView) findViewById(R.id.textView2);
        textTimer = (TextView) findViewById(R.id.textView);
        btn1 = (Button) findViewById(R.id.choice1);
        btn2 = (Button) findViewById(R.id.choice2);
        btn3 = (Button) findViewById(R.id.choice3);
        btn4 = (Button) findViewById(R.id.choice4);
        fetchdb = (Button) findViewById(R.id.fetchdb);

        //editText = (EditText) findViewById(R.id.textInputEditText);
    }

    public void btnConn(View view) {
        Send objSend = new Send();
        objSend.execute("");
    }

    private class Send extends AsyncTask<String, String, String>
    {
        String msg = "";
        //String text = editText.getText().toString();

        @Override
        protected void onPreExecute() {textScore.setText("Please Wait...");}

        @Override
        protected String doInBackground(String... strings)
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                if(conn == null)
                {
                    msg = "conn == null";
                }
                else
                {
                    //String query = "INSERT into questionnaire (question) VALUES ('"+text+"')";
                    String query = "SELECT * from questionnaire WHERE id=10";
                    Statement stmt = conn.createStatement();
                    ResultSet resultSet = stmt.executeQuery(query);

                    while(resultSet.next())
                    {
                        textQuestion.setText(resultSet.getString(2));
                        btn1.setText(resultSet.getString(3));
                        btn2.setText(resultSet.getString(4));
                        btn3.setText(resultSet.getString(5));
                        btn4.setText(resultSet.getString(6));
                    }
                    msg = "LOADED";
                }
                conn.close();
            }
            catch (Exception e)
            {
                msg = "fetch error";
                e.printStackTrace();
            }
            return msg;
        }

        @Override
        protected void onPostExecute(String msg)
        {
            textScore.setText(msg);
        }
    }
}