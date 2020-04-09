package com.uldev.javangers;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class incident_declaration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incident_declaration);
    }

    public void createIncident(View view) {
        EditText EditText_endroit = (EditText) findViewById (R.id.editText10);
        EditText EditText_details = (EditText) findViewById (R.id.editText12);
        BDD BDDconn = new BDD();
        BDDconn.comment = EditText_details.getText().toString();
        BDDconn.location = EditText_endroit.getText().toString();
        int userID = getIntent().getIntExtra("UserId", 0);
        BDDconn.userID = userID;
        BDDconn.doInBackground("foundcivilbyuser");
        BDDconn.doInBackground("createdemande");
    }

}
