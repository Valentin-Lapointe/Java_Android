package com.uldev.javangers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.concurrent.ExecutionException;

public class Inscription_civil extends AppCompatActivity {

    private Button suivant;
    private EditText nom;
    private EditText prenom;
    private EditText date_naissance;
    Integer id_user = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription_civil);

        Intent intent = getIntent();
        if(intent != null) {
            id_user = intent.getIntExtra("id_user", 0);
        }else{
            System.out.println("debug :" + "Intent null");
        }

        this.suivant = (Button) findViewById(R.id.suivant);
        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer id_civil = 0;
                try {
                    id_civil = insertCivil(v);
                }catch(Exception e){
                    System.out.println("debug :" + e.getMessage());
                }

                if(id_civil != 0){
                    Intent otherActivity = new Intent(getApplicationContext(), Inscription_contact.class);
                    otherActivity.putExtra("id_civil", id_civil);
                    startActivity(otherActivity);
                    finish();
                }
            }
        });
    }

    public int insertCivil(View view) throws ExecutionException, InterruptedException {

        //on recupere les valeurs dans les champs
        EditText text_nom = (EditText) findViewById(R.id.nom);
        EditText text_prenom = (EditText) findViewById(R.id.prenom);
        EditText text_date_naissance = (EditText) findViewById(R.id.date_naissance);

        String nom = text_nom.getText().toString();
        String prenom = text_prenom.getText().toString();
        String date_naissance = text_date_naissance.getText().toString();


        //on appel la fonction d'inscription de la classe BDD et on lui donne le login et le mot de passe
        BDD BDDconn = new BDD();
        BDD.nom = nom;
        BDD.prenom = prenom;
        BDD.date_naissance = date_naissance;
        BDD.ID_USER = id_user;
        BDDconn.execute("insertCivil").get();
        return BDDconn.id_civil;
    }
}
