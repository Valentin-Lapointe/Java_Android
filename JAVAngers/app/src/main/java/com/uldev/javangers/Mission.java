package com.uldev.javangers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.uldev.javangers.models.CivilModel;
import com.uldev.javangers.models.HeroModel;
import com.uldev.javangers.models.MissionModel;
import com.uldev.javangers.models.UserModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Mission extends AppCompatActivity {

    public MissionModel mission = null;
    TextView detail = null;
    TextView date = null;
    TextView title = null;
    TextView location = null;
    TextView type = null;

    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission);

        mission = (MissionModel) getIntent().getSerializableExtra("Mission");

        detail = (TextView) findViewById(R.id.textDetail);
        detail.setText("Détails :" + mission.comment);

        title = (TextView) findViewById(R.id.titleMission);
        title.setText(mission.title);

        date = (TextView) findViewById(R.id.textCreationDate);
        date.setText("Mission crée le : " + dateFormat.format(mission.creationDate).toString());

    }
}
