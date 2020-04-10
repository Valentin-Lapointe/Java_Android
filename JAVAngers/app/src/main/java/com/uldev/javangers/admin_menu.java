package com.uldev.javangers;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.uldev.javangers.models.CivilModel;
import com.uldev.javangers.models.UserModel;

public class admin_menu extends AppCompatActivity {

    private Button mission;
    private Button crise;
    private Button incidents;

    public CivilModel civil = null;
    public UserModel user = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);
        civil = (CivilModel)getIntent().getSerializableExtra("Civil");
        user = (UserModel)getIntent().getParcelableExtra("User");

        this.mission = (Button) findViewById(R.id.button5);
        mission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), Missions.class);
                otherActivity.putExtra("User", user);
                otherActivity.putExtra("Civil", civil);
                startActivity(otherActivity);
                finish();
            }
        });

        this.crise = (Button) findViewById(R.id.button8);
        crise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), Incident.class);
                startActivity(otherActivity);
                finish();
            }
        });

        this.incidents = (Button) findViewById(R.id.button7);
        incidents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), Incidents.class);
                startActivity(otherActivity);
                finish();
            }
        });
    }

}
