package com.uldev.javangers;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.uldev.javangers.models.UserModel;

import java.net.URL;
import java.util.concurrent.ExecutionException;

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

                UserModel user = null;
                try {
                    user = TestConn(view);
                } catch (Exception ex) {
                    System.out.println("debug : " + ex.getMessage());
                }

                if(user == null){
                    Toast.makeText(getApplicationContext(), "Login ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
                }
                else {
                    switch (user.id_Civil){
                        case 0: {
                            Intent indent = new Intent(getApplicationContext(), User_Menu.class);
                            indent.putExtra("id_User", user.id);
                            startActivity(indent);
                            finish();
                        }
                        case 1: {
                            Intent indent = new Intent(getApplicationContext(), Hero_menu.class);
                            indent.putExtra("id_User", user.id);
                            startActivity(indent);
                            finish();
                        }
                        /*case 2: {
                            Intent indent = new Intent(getApplicationContext(), Admin_menu.class);
                            indent.putExtra("id_User", user.id);
                            startActivity(indent);
                            finish();
                        }*/
                        case 3: {
                            Intent indent = new Intent(getApplicationContext(), SU_menu.class);
                            indent.putExtra("id_User", user.id);
                            startActivity(indent);
                            finish();
                        }
                    }
                }
            }
        });
    }

    public UserModel TestConn(View view) throws ExecutionException, InterruptedException {
//        BDD BDDconn = new BDD();
//        BDDconn.execute("request");
        BDD BDDconn = new BDD();
        //BDDconn.comment = "ceci est une demande créée via notre appli JAVAngers";
        //BDDconn.status = 1;
        //BDDconn.fkcivil = 1;
        //BDDconn.execute("createdemande");
        BDDconn.execute("signIn").get();
        //System.out.println("debug:  "+BDDconn.user);
        return BDDconn.user;

        // Do something in response to button click
    }


}
