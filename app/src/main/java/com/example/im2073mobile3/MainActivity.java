package com.example.im2073mobile3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    TextView textQuestion, textScore, textTimer;
    Button btn1, btn2, btn3, btn4;
    Button fetch1, fetch2, fetch3, fetch4, fetch5;
    Button fetchnext, btntally;
    //EditText editText;
    private static final String DB_URL = "jdbc:mysql://192.168.1.161/MCQ";
    private static final String USER = "user1";
    private static final String PASS = "password";
    public String answer, choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textQuestion = (TextView) findViewById(R.id.textQuestion);
        textScore = (TextView) findViewById(R.id.textView2);
        //textTimer = (TextView) findViewById(R.id.textView);
        btn1 = (Button) findViewById(R.id.select1);
        btn2 = (Button) findViewById(R.id.select2);
        btn3 = (Button) findViewById(R.id.select3);
        btn4 = (Button) findViewById(R.id.select4);
        fetch1 = (Button) findViewById(R.id.fetch1);
        fetch2 = (Button) findViewById(R.id.fetch2);
        fetch3 = (Button) findViewById(R.id.fetch3);
        fetch4 = (Button) findViewById(R.id.fetch4);
//        fetchnext = (Button) findViewById(R.id.fetchnext);
        btntally = (Button) findViewById(R.id.btntally);

        //editText = (EditText) findViewById(R.id.textInputEditText);
    }

//    public void btnConn(View view) {
//        LoadQ objSend = new LoadQ();
//        objSend.execute("");
//    }
    public void btnConn1(View view) {
        LoadQ1 objSend = new LoadQ1();
        objSend.execute("");
    }
    public void btnConn2(View view) {
        LoadQ2 objSend = new LoadQ2();
        objSend.execute("");
    }
    public void btnConn3(View view) {
        LoadQ3 objSend = new LoadQ3();
        objSend.execute("");
    }
    public void btnConn4(View view) {
        LoadQ4 objSend = new LoadQ4();
        objSend.execute("");
    }
    public void btnConn5(View view) {
        LoadQ5 objSend = new LoadQ5();
        objSend.execute("");
    }

    public void btnChoice(View view) {
        Tally1 objTally1 = new Tally1();
        Tally2 objTally2 = new Tally2();
        Tally3 objTally3 = new Tally3();
        Tally4 objTally4 = new Tally4();

        if (((((Button)view).getTag()).toString()).equals("select1")) {
            objTally1.execute("");
            if((((Button)view).getText()).equals(answer)) {
                ((Button)view).setTextColor(Color.GREEN);
            }
            else {
                ((Button)view).setTextColor(Color.RED);
            }
        }
        else if (((((Button)view).getTag()).toString()).equals("select2")) {
            objTally2.execute("");
            if((((Button)view).getText()).equals(answer)) {
                ((Button)view).setTextColor(Color.GREEN);
            }
            else {
                ((Button)view).setTextColor(Color.RED);
            }
        }
        else if (((((Button)view).getTag()).toString()).equals("select3")) {
            objTally3.execute("");
            if((((Button)view).getText()).equals(answer)) {
                ((Button)view).setTextColor(Color.GREEN);
            }
            else {
                ((Button)view).setTextColor(Color.RED);
            }
        }
        else if (((((Button)view).getTag()).toString()).equals("select4")) {
            objTally4.execute("");
            if((((Button)view).getText()).equals(answer)) {
                ((Button)view).setTextColor(Color.GREEN);
            }
            else {
                ((Button)view).setTextColor(Color.RED);
            }
        }
    }

    public class LoadQ1 extends AsyncTask<String, String, String>
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
                    //String query = "SELECT * from questionnaire WHERE id=10";
                    String query = "SELECT * FROM questionnaire";
                    //TODO: add sql statement to reset counter table values to 0 0 0 0
                    Statement stmt = conn.createStatement();
                    ResultSet resultSet = stmt.executeQuery(query);

                    resultSet.first();
                    textQuestion.setText(resultSet.getString(2));
                    btn1.setText(resultSet.getString(3));
                    btn2.setText(resultSet.getString(4));
                    btn3.setText(resultSet.getString(5));
                    btn4.setText(resultSet.getString(6));
                    answer = resultSet.getString(7);
//                    while(resultSet.next())
//                    {
//
//                    }
                    msg = "LOADED | " + "Ans: " + answer;
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
    public class LoadQ2 extends AsyncTask<String, String, String>
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
                    //String query = "SELECT * from questionnaire WHERE id=10";
                    String query = "SELECT * FROM questionnaire";
                    //TODO: add sql statement to reset counter table values to 0 0 0 0
                    Statement stmt = conn.createStatement();
                    ResultSet resultSet = stmt.executeQuery(query);

                    resultSet.absolute(2);
                    textQuestion.setText(resultSet.getString(2));
                    btn1.setText(resultSet.getString(3));
                    btn2.setText(resultSet.getString(4));
                    btn3.setText(resultSet.getString(5));
                    btn4.setText(resultSet.getString(6));
                    answer = resultSet.getString(7);
//                    while(resultSet.next())
//                    {
//
//                    }
                    msg = "LOADED | " + "Ans: " + answer;
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
    public class LoadQ3 extends AsyncTask<String, String, String>
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
                    //String query = "SELECT * from questionnaire WHERE id=10";
                    String query = "SELECT * FROM questionnaire";
                    //TODO: add sql statement to reset counter table values to 0 0 0 0
                    Statement stmt = conn.createStatement();
                    ResultSet resultSet = stmt.executeQuery(query);

                    resultSet.absolute(3);
                    textQuestion.setText(resultSet.getString(2));
                    btn1.setText(resultSet.getString(3));
                    btn2.setText(resultSet.getString(4));
                    btn3.setText(resultSet.getString(5));
                    btn4.setText(resultSet.getString(6));
                    answer = resultSet.getString(7);
//                    while(resultSet.next())
//                    {
//
//                    }
                    msg = "LOADED | " + "Ans: " + answer;
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
    public class LoadQ4 extends AsyncTask<String, String, String>
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
                    //String query = "SELECT * from questionnaire WHERE id=10";
                    String query = "SELECT * FROM questionnaire";
                    //TODO: add sql statement to reset counter table values to 0 0 0 0
                    Statement stmt = conn.createStatement();
                    ResultSet resultSet = stmt.executeQuery(query);

                    resultSet.absolute(4);
                    textQuestion.setText(resultSet.getString(2));
                    btn1.setText(resultSet.getString(3));
                    btn2.setText(resultSet.getString(4));
                    btn3.setText(resultSet.getString(5));
                    btn4.setText(resultSet.getString(6));
                    answer = resultSet.getString(7);
//                    while(resultSet.next())
//                    {
//
//                    }
                    msg = "LOADED | " + "Ans: " + answer;
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
    public class LoadQ5 extends AsyncTask<String, String, String>
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
                    //String query = "SELECT * from questionnaire WHERE id=10";
                    String query = "SELECT * FROM questionnaire";
                    //TODO: add sql statement to reset counter table values to 0 0 0 0
                    Statement stmt = conn.createStatement();
                    ResultSet resultSet = stmt.executeQuery(query);

                    resultSet.absolute(5);
                    textQuestion.setText(resultSet.getString(2));
                    btn1.setText(resultSet.getString(3));
                    btn2.setText(resultSet.getString(4));
                    btn3.setText(resultSet.getString(5));
                    btn4.setText(resultSet.getString(6));
                    answer = resultSet.getString(7);
//                    while(resultSet.next())
//                    {
//
//                    }
                    msg = "LOADED | " + "Ans: " + answer;
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

    public class Tally1 extends AsyncTask<String, String, String>
    {
        String msg = "";

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
//                    query i want to perform: UPDATE counter SET qtyselect(col) = qtyselect(col) + 1 --> NOTE: cannot concatenate strings!!!
//                    PreparedStatement stmt = conn.prepareStatement("UPDATE counter SET ? = ? + 1");
//                    stmt.setString(1, col);
//                    stmt.setString(2, col);
                    String query = "UPDATE counter SET qtyselect1 = qtyselect1 + 1";
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate(query);
                    msg = "tally updated!";
                }
                conn.close();
            }
            catch (Exception e)
            {
                msg = "tally error";
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
    public class Tally2 extends AsyncTask<String, String, String>
    {
        String msg = "";

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
//                    query i want to perform: UPDATE counter SET qtyselect(col) = qtyselect(col) + 1 --> NOTE: cannot concatenate strings!!!
//                    PreparedStatement stmt = conn.prepareStatement("UPDATE counter SET ? = ? + 1");
//                    stmt.setString(1, col);
//                    stmt.setString(2, col);
                    String query = "UPDATE counter SET qtyselect2 = qtyselect2 + 1";
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate(query);
                    msg = "tally updated!";
                }
                conn.close();
            }
            catch (Exception e)
            {
                msg = "tally error";
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
    public class Tally3 extends AsyncTask<String, String, String>
    {
        String msg = "";

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
//                    query i want to perform: UPDATE counter SET qtyselect(col) = qtyselect(col) + 1 --> NOTE: cannot concatenate strings!!!
//                    PreparedStatement stmt = conn.prepareStatement("UPDATE counter SET ? = ? + 1");
//                    stmt.setString(1, col);
//                    stmt.setString(2, col);
                    String query = "UPDATE counter SET qtyselect3 = qtyselect3 + 1";
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate(query);
                    msg = "tally updated!";
                }
                conn.close();
            }
            catch (Exception e)
            {
                msg = "tally error";
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
    public class Tally4 extends AsyncTask<String, String, String>
    {
        String msg = "";

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
//                    query i want to perform: UPDATE counter SET qtyselect(col) = qtyselect(col) + 1 --> NOTE: cannot concatenate strings!!!
//                    PreparedStatement stmt = conn.prepareStatement("UPDATE counter SET ? = ? + 1");
//                    stmt.setString(1, col);
//                    stmt.setString(2, col);
                    String query = "UPDATE counter SET qtyselect4 = qtyselect4 + 1";
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate(query);
                    msg = "tally updated!";
                }
                conn.close();
            }
            catch (Exception e)
            {
                msg = "tally error";
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
