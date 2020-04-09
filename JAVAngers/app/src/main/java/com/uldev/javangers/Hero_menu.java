package com.uldev.javangers;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.uldev.javangers.models.MissionModel;
import com.uldev.javangers.models.UserModel;

public class Hero_menu extends AppCompatActivity {

    private Button button5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_menu);


        Intent intent = getIntent();
        if (intent != null){
            final UserModel user = intent.getParcelableExtra("user");
            if (user != null) {

                this.button5 = (Button) findViewById(R.id.button5);

                button5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        System.out.println("userID = " + user.id);
                        System.out.println("login = " + user.login);

                        //Intent indent = new Intent(getApplicationContext(), Mission_Creation.class);
                        //startActivity(indent);
                        //finish();
                    }
                });


            }else{
                System.out.println("User null");
            }
        }
        else{
            System.out.println("Intent null");
        }


    }

}
