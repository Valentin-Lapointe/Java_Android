package com.uldev.javangers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.navigation.NavController;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), Inscription.class);
                startActivity(otherActivity);
                finish();
            }
        });
    }

    public void TestConn(View view) {
//        BDD BDDconn = new BDD();
//        BDDconn.execute("request");
        BDD BDDconn = new BDD();
        BDDconn.comment = "ceci est une demande créée via notre appli JAVAngers";
        BDDconn.status = 1;
        BDDconn.fkcivil = 1;
        BDDconn.execute("createdemande");

        // Do something in response to button click
    }
}
