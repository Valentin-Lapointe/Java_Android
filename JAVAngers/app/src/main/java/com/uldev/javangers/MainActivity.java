package com.uldev.javangers;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.uldev.javangers.models.UserModel;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private Button connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.connection = findViewById(R.id.connection);

        connection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                TestConn(view);

                Intent indent = new Intent(getApplicationContext(), User_Menu.class);
                startActivity(indent);
                finish();

            }
        });
    }

    public void TestConn(View view) {
//        BDD BDDconn = new BDD();
//        BDDconn.execute("request");
        BDD BDDconn = new BDD();
        //BDDconn.comment = "ceci est une demande créée via notre appli JAVAngers";
        //BDDconn.status = 1;
        //BDDconn.fkcivil = 1;
        //BDDconn.execute("createdemande");
        BDDconn.execute("signIn");

        // Do something in response to button click
    }


}
