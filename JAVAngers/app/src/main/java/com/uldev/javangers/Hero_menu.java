package com.uldev.javangers;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Hero_menu extends AppCompatActivity {

    private Button mission;
    private Button litige;
    private Button rapport;
    private Button profil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_menu);

        this.mission = (Button) findViewById(R.id.button5);
        mission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), Missions.class);
                startActivity(otherActivity);
                finish();
            }
        });

//        this.litige = (Button) findViewById(R.id.button8);
//        litige.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent otherActivity = new Intent(getApplicationContext(), Missions.class);
//                startActivity(otherActivity);
//                finish();
//            }
//        });

//        this.rapport = (Button) findViewById(R.id.button7);
//        rapport.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent otherActivity = new Intent(getApplicationContext(), Missions.class);
//                startActivity(otherActivity);
//                finish();
//            }
//        });
//
//        this.profil = (Button) findViewById(R.id.button6);
//        profil.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent otherActivity = new Intent(getApplicationContext(), Missions.class);
//                startActivity(otherActivity);
//                finish();
//            }
//        });
    }

}
