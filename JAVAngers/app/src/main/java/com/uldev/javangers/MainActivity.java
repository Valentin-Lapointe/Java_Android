package com.uldev.javangers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void TestConn(View view) {
        BDD BDDconn = new BDD();
        URL url = null;
        BDDconn.execute(url);
        // Do something in response to button click
    }
}
