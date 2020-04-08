package com.uldev.javangers;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class User_Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__menu);
    }

    public void openIncidentActivity(View view){
        int user_id = 1; // A REMPLACER PAR LE USER CONNECTE LORSQUE LA CONNEXION SERA FAITE
        Intent myIntent = new Intent(User_Menu.this, incident_declaration.class);
        myIntent.putExtra("user_id", user_id);
        User_Menu.this.startActivity(myIntent);
    }

}