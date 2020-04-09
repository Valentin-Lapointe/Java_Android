package com.uldev.javangers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Inscription_contact extends AppCompatActivity {

    private Button inscription;
    private EditText adresse;
    private EditText cp;
    private EditText ville;
    private EditText pays;
    private EditText email;
    private EditText telephone;
    Integer id_civil = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription_contact);

        Intent intent = getIntent();
        if(intent != null) {
            id_civil = intent.getIntExtra("id_civil", 0);
        }else{
            System.out.println("debug :" + "Intent null");
        }

        this.inscription = (Button) findViewById(R.id.inscription);
        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    insertContact(v);
                }catch(Exception e){
                    System.out.println("debug :" + e.getMessage());
                }
                Intent otherActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });
    }

    public void insertContact(View view){

        //on recupere les valeurs dans les champs
        EditText text_adresse = (EditText) findViewById(R.id.adresse);
        EditText text_cp = (EditText) findViewById(R.id.cp);
        EditText text_ville = (EditText) findViewById(R.id.ville);
        EditText text_pays = (EditText) findViewById(R.id.pays);
        EditText text_email = (EditText) findViewById(R.id.email);
        EditText text_telephone = (EditText) findViewById(R.id.telephone);

        String adresse = text_adresse.getText().toString();
        String cp = text_cp.getText().toString();
        String ville = text_ville.getText().toString();
        String pays = text_pays.getText().toString();
        String email = text_email.getText().toString();
        String telephone = text_telephone.getText().toString();


        //on appel la fonction d'inscription de la classe BDD et on lui donne le login et le mot de passe
        BDD BDDconn = new BDD();
        BDD.adresse = adresse;
        BDD.cp = cp;
        BDD.ville = ville;
        BDD.pays = pays;
        BDD.email = email;
        BDD.telephone = telephone;
        BDD.ID_CIVIL = id_civil;
        BDDconn.execute("insertContact");


    }
}
