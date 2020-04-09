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
import android.widget.Toast;

import com.uldev.javangers.models.CivilModel;
import com.uldev.javangers.models.MissionModel;
import com.uldev.javangers.models.UserModel;

public class Hero_menu extends AppCompatActivity {

    public CivilModel civil = null;
    public UserModel user = null;
    private Button mission;
    private Button litige;
    private Button rapport;
    private Button profil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_menu);
        civil = (CivilModel)getIntent().getSerializableExtra("Civil");
        user = (UserModel)getIntent().getParcelableExtra("User");
    }

    public void test(View view){
                Intent otherActivity = new Intent(getApplicationContext(), Missions.class);
                startActivity(otherActivity);
                finish();
    }

}
