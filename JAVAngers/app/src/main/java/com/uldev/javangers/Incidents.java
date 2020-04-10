package com.uldev.javangers;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.uldev.javangers.models.IncidentModel;

import org.w3c.dom.Text;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class Incidents extends AppCompatActivity {

    ListView lv;
    List<IncidentModel> incidents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incidents);

        BDD connection = new BDD();
        try {
            connection.execute("listIncidents").get();
            incidents = connection.incidents;
        } catch (Exception e) {
            e.printStackTrace();
        }

        lv = (ListView) findViewById(R.id.list);
        final ArrayAdapter<IncidentModel> adapter = new ArrayAdapter<IncidentModel>(Incidents.this,
                android.R.layout.simple_list_item_1, incidents);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                IncidentModel incident = new IncidentModel();
                incident = (IncidentModel) lv.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(), Incident.class);
                intent.putExtra("Incident", incident);
                startActivity(intent);
                finish();
            }
        });
    }
}
