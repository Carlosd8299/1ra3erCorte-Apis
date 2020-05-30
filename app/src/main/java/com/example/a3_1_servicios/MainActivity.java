package com.example.a3_1_servicios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button listar;
    String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=479b8c1486102d3a94b544e525cda371\n";
    ArrayList<Pelicula> pel = new ArrayList<>();
    String raiz = "https://image.tmdb.org/t/p/w500";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listar = findViewById(R.id.btnListar);
        listar.setOnClickListener(this);
        requestDatos();
    }

    public void requestDatos(){
        RequestQueue cola = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //dato.setText(response.toString());
                        parserJson(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Error en la conexion", Toast.LENGTH_LONG).show();
            }
        })
        {
            @Override
            public Map getHeaders() throws AuthFailureError {
                HashMap headers = new HashMap();
                // headers.put("Content-Type", "application/json");
                headers.put("X-Auth-Token", "479b8c1486102d3a94b544e525cda371");
                return headers;
            }
        };
        cola.add(jsonObjectRequest);
    }

    public void parserJson(JSONObject response){
        try {

            JSONArray nowPlaying = response.getJSONArray("results");
            for (int i = 0 ; i<nowPlaying.length(); i++) {
                JSONObject pel = nowPlaying.getJSONObject(i);
                // String id = pel.getString("id");
                double popularidad = pel.getDouble("popularity");
                double voteAverage = pel.getDouble("vote_average");
                String oLanguage = pel.getString("original_language");
                String oTitle = pel.getString("original_title");
                String Overview = pel.getString("overview");
                String titleE = pel.getString("title");
                String link = raiz + pel.getString("poster_path");
                Pelicula pe = new Pelicula(popularidad,oLanguage,oTitle,titleE,voteAverage,Overview,link);
                this.pel.add(pe);
            }
        } catch (JSONException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnListar:
                Intent i = new Intent(getApplicationContext(),Listar.class);
                i.putParcelableArrayListExtra("peliculas", pel);
                startActivity(i);
                break;
        }
    }
}
