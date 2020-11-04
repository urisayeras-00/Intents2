package com.example.intents2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText,editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = findViewById(R.id.b1);
        editText = findViewById(R.id.nom);
        editText2 = findViewById(R.id.edat);

        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //Recupero el valor del EditText per enviar-ho a l'activitat 2 quan es faci click
        String nom = editText.getText().toString();
        int edat = Integer.parseInt(editText2.getText().toString());

        Intent intent = new Intent(this, activity2.class);
        //intent.putExtra("etiquetaNom", nom); //"etiquetaNom" el definim nosaltres i nom es la variable

        //si enviem nomes una dada fariem un intent.putExtra. Si n'enviem més d'una utilitzariem el bundle (conjunt de intent.putExtra)
        Bundle sac = new Bundle();
        sac.putString("etiquetaNom",nom);
        sac.putInt("etiquetaEdat",edat);

        intent.putExtras(sac);  //encontes de putExtra, fem putExtras perque pasem més d'un parametre
        startActivity(intent);
    }
}