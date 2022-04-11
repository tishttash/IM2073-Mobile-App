// connection class to handle connection object to sql server
// TODO: make it non-async. just a regular class. connect it to the database server.
//  Using parcelable class you can access the conn object and it's attributes from the other activity classes!
//  https://www.youtube.com/watch?v=uMqgf17mx_U&ab_channel=ProGrammer

package com.example.im2073mobile3;

import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import android.os.Parcel;
import android.os.Parcelable;

public class Conn extends AsyncTask<String, String, String> implements Parcelable
{
    String msg = "nothing";
    private static final String DB_URL = "jdbc:mysql://192.168.1.161/MCQ";
    private static final String USER = "user1";
    private static final String PASS = "password";
//        @Override
//        protected void onPreExecute() {textScore.setText("Please Wait...");}

    protected Conn(Parcel in) {
        msg = in.readString();
    }

    public static final Creator<Conn> CREATOR = new Creator<Conn>() {
        @Override
        public Conn createFromParcel(Parcel in) {
            return new Conn(in);
        }

        @Override
        public Conn[] newArray(int size) {
            return new Conn[size];
        }
    };

    public Conn() {

    }

    @Override
    protected String doInBackground(String... strings)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            if(connection == null)
            {
                msg = "conn == null";
            }
//                else
//                {
//                    //String query = "SELECT * from questionnaire WHERE id=10";
//                    String query = "SELECT * FROM questionnaire";
//                    //TODO: add sql statement to reset counter table values to 0 0 0 0
//                    Statement stmt = conn.createStatement();
//                    ResultSet resultSet = stmt.executeQuery(query);
//
//                    resultSet.first();
//                }
//                conn.close();
        }
        catch (Exception e)
        {
            msg = "fetch error";
            e.printStackTrace();
        }
        return msg;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(msg);
    }

//        @Override
//        protected void onPostExecute(String msg)
//        {
//            textScore.setText(msg);
//        }
}