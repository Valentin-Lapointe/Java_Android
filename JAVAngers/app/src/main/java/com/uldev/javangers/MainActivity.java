package com.uldev.javangers;

import android.content.Context;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import android.widget.EditText;


import com.uldev.javangers.models.CivilModel;
import com.uldev.javangers.models.UserModel;

import java.io.Serializable;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private Button inscription;
    private Button connection;
    private EditText login;
    private EditText password;


    CivilModel civil = null;
//    UserModel user = null;

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

                UserModel user = null;
                try {
                    user = testConn(view);

                } catch (Exception ex) {
                    System.out.println("bug : " + ex.getMessage());
                }

                if(user == null){
                    Toast.makeText(getApplicationContext(), "Idenfiants incorrects", Toast.LENGTH_SHORT).show();
                }
                else {
                    Class otherActivity = null;
                    switch (user.administrationRight){
                        case 0: {
                            otherActivity = User_Menu.class;
                            break;
                        }
                        case 1: {
                            otherActivity = Hero_menu.class;
                            break;
                        }
                        case 2: {
                            otherActivity = admin_menu.class;
                            break;
                        }
                        case 3: {
                            otherActivity = SU_menu.class;
                            break;
                        }
                    }
                    
                    Intent indent = new Intent(getApplicationContext(), otherActivity);
                    indent.putExtra("User", user);
                    indent.putExtra("Civil", civil);
                    startActivity(indent);
                    finish();
                }

            }
        });
    }

    public UserModel testConn(View view) throws ExecutionException, InterruptedException {
        BDD BDDconn = new BDD();
        BDDconn.login = login.getText().toString().trim();
        BDDconn.password = password.getText().toString().trim();
        BDDconn.execute("signIn").get();
        civil = BDDconn.civil;
        return BDDconn.user;
    }
}






