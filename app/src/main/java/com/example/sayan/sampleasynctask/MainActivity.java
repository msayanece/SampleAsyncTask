package com.example.sayan.sampleasynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomAsync customAsync = new CustomAsync();
        customAsync.execute(10,20);
    }

    private class CustomAsync extends AsyncTask<Integer, Void, Integer>{

        @Override
        protected void onPreExecute() {
            Toast.makeText(MainActivity.this, "Please wait", Toast.LENGTH_SHORT).show();
            super.onPreExecute();
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            int a = integers[0];
            int b = integers[1];
            int c = a + b;
            return c;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            Toast.makeText(MainActivity.this, "Result: " + integer, Toast.LENGTH_LONG).show();
            super.onPostExecute(integer);
        }
    }
}
