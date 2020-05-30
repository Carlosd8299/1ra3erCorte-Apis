package com.example.a3_1_servicios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Listar extends AppCompatActivity {

    ArrayList<Pelicula> peliculas = new ArrayList<>();
    ListView listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        Intent i = getIntent();
        peliculas = i.getParcelableArrayListExtra("peliculas");
        listado = findViewById(R.id.lstPelicula);

        if (peliculas !=null && peliculas.size()>0){
            PeliculaAdapter adapter = new PeliculaAdapter(this, peliculas);
            listado.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
        else{
            Toast.makeText(this,"No hay datos" , Toast.LENGTH_LONG).show();
        }

    }
}
