package com.uldev.javangers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private Button inscription;
    private Button connection;
    private EditText login;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.inscription = (Button) findViewById(R.id.inscription);
        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), Inscription.class);
                startActivity(otherActivity);
                finish();
            }
        });

        login = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);
        this.connection = (Button) findViewById(R.id.connection);

        connection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                System.out.println(login.getText().toString());
                System.out.println(password.getText().toString());

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
        //BDDconn.comment = "ceci est une demande créée via notre appli JAVAngers";
        //BDDconn.status = 1;
        //BDDconn.fkcivil = 1;
        //BDDconn.execute("createdemande");
        BDD BDDconn = new BDD();
        BDDconn.login = login.getText().toString();
        BDDconn.password = password.getText().toString();
        BDDconn.execute("signIn");

        // Do something in response to button click
    }
}






