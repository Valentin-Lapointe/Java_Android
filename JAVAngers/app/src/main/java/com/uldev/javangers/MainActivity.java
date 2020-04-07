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
//        BDD BDDconn = new BDD();
//        BDDconn.execute("request");
        BDD BDDconn = new BDD();
        BDDconn.comment = "ceci est une demande créer via l'appli JAVAngers !";
        BDDconn.status = 1;
        BDDconn.fkcivil = 1;
        BDDconn.execute("createdemande");

        // Do something in response to button click
    }
}
