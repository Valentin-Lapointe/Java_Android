package com.uldev.javangers;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.uldev.javangers.models.CivilModel;
import com.uldev.javangers.models.HeroModel;
import com.uldev.javangers.models.MissionModel;
import com.uldev.javangers.models.UserModel;

import java.util.List;

public class Missions extends AppCompatActivity {


    public CivilModel civil = null;
    public UserModel user = null;
    public HeroModel hero = null;

    ListView lv;
    List<MissionModel> missions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missions);
        civil = (CivilModel)getIntent().getSerializableExtra("Civil");
        user = (UserModel)getIntent().getParcelableExtra("User");

        if(user.administrationRight == 1){
            hero = (HeroModel) getIntent().getSerializableExtra("Hero");
            BDD connection = new BDD();
            try {
                connection.heroID = hero.id;
                connection.execute("listMissionsByHeroId").get();
                missions = connection.missions;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(user.administrationRight == 2){
            BDD connection = new BDD();
            try {
                connection.execute("listMissions").get();
                missions = connection.missions;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        lv = (ListView) findViewById(R.id.listMission);
        final ArrayAdapter<MissionModel> adapter = new ArrayAdapter<MissionModel>(Missions.this,
                android.R.layout.simple_list_item_1, missions);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MissionModel mission  = (MissionModel) lv.getItemAtPosition(position);

                Intent intent = new Intent(getApplicationContext(), Mission.class);
                intent.putExtra("Mission", mission);
                startActivity(intent);
                finish();
            }
        });

    }

}
