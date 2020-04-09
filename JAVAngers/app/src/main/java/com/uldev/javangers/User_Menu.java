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

public class User_Menu extends AppCompatActivity {
    UserModel user = null;
    CivilModel civil = null;
    private Button incident;
    private Button litige;
    private Button satisfaction;
    private Button profil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__menu);
        civil = (CivilModel)getIntent().getSerializableExtra("Civil");
        user = (UserModel)getIntent().getParcelableExtra("User");

        this.incident = (Button) findViewById(R.id.button5);
        incident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), incident_declaration.class);
                otherActivity.putExtra("UserId", user.id);
                startActivity(otherActivity);
                finish();
            }
        });

//        this.litige = (Button) findViewById(R.id.button8);
//        litige.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent otherActivity = new Intent(getApplicationContext(), Incident.class);
//                startActivity(otherActivity);
//                finish();
//            }
//        });

//        this.satisfaction = (Button) findViewById(R.id.button7);
//        satisfaction.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent otherActivity = new Intent(getApplicationContext(), Incident.class);
//                startActivity(otherActivity);
//                finish();
//            }
//        });

//        this.profil = (Button) findViewById(R.id.button6);
//        profil.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent otherActivity = new Intent(getApplicationContext(), Incident.class);
//                startActivity(otherActivity);
//                finish();
//            }
//        });
    }
        public void openIncidentActivity (View view){
        int user_id = 1; // A REMPLACER PAR LE USER CONNECTE LORSQUE LA CONNEXION SERA FAITE
        Intent myIntent = new Intent(User_Menu.this, incident_declaration.class);
        myIntent.putExtra("user_id", user.id);
        User_Menu.this.startActivity(myIntent);
    }
}