package com.uldev.javangers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.concurrent.ExecutionException;

public class Inscription extends AppCompatActivity {

    private Button connexion;
    private Button suivant;
    private EditText editText;
    private EditText editText11;
    private EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        this.connexion = (Button) findViewById(R.id.connexion);
        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });

        this.suivant = (Button) findViewById(R.id.suivant);
        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer id_user = 0;
                try{
                    id_user = insertUser(v);
                }catch(Exception e){
                    System.out.println("debug :" + e.getMessage());
                }

                if(id_user != 0){
                    Intent otherActivity = new Intent(getApplicationContext(), Inscription_civil.class);
                    otherActivity.putExtra("id_user", id_user);
                    startActivity(otherActivity);
                    finish();
                }

            }
        });
    }

    public int insertUser(View view) throws ExecutionException, InterruptedException {

        //on recupere les valeurs dans les champs
        EditText editText = (EditText) findViewById(R.id.editText);
        EditText editText11 = (EditText) findViewById(R.id.editText11);
        EditText editText2 = (EditText) findViewById(R.id.editText2);

        String login = editText.getText().toString();
        String password = editText11.getText().toString();
        String confirmPassword = editText2.getText().toString();

        //si le mot de passe correspond au mot de passe confirmé, alors on enregistre dans la BDD
        if(password.equals(confirmPassword)){

            //on appel la fonction d'inscription de la classe BDD et on lui donne le login et le mot de passe
            BDD BDDconn = new BDD();
            BDD.login = login;
            BDD.password = password;
            BDDconn.execute("signUp").get();
            return BDDconn.id_user;
        }

        return 0;
    }

}
