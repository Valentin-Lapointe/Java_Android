package com.uldev.javangers;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.uldev.javangers.models.IncidentModel;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Incident extends AppCompatActivity {

    IncidentModel incident = null;
    TextView comment = null;
    TextView date = null;
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incident);
        incident = (IncidentModel)getIntent().getSerializableExtra("Incident");

        comment = (TextView) findViewById(R.id.textView4);
        comment.setText("Détails :" + incident.comment);

        date = (TextView) findViewById(R.id.textView);
        date.setText("Soumis le " + dateFormat.format(incident.creationDate).toString());
    }

}
