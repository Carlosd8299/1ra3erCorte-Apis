package com.example.a3_1_servicios;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class PeliculaAdapter extends ArrayAdapter<Pelicula> {

    public PeliculaAdapter(@NonNull Context context, @NonNull ArrayList<Pelicula> peliculas) {
        super(context, 0, peliculas);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Pelicula pel = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.dato_peliculas, parent, false);
        }
        // Lookup view for data population
        TextView idiomaOriginal = (TextView) convertView.findViewById(R.id.tv_originalL);
        TextView TitulOriginal = (TextView) convertView.findViewById(R.id.tv_originalTitle);
        TextView resumen = (TextView) convertView.findViewById(R.id.tv_resumen);
        TextView tituloEspañol = (TextView) convertView.findViewById(R.id.tv_tituloEs);
        TextView popularidad = (TextView) convertView.findViewById(R.id.tv_popu);
        TextView votos = (TextView) convertView.findViewById(R.id.tv_vote);
        ImageView poster = (ImageView) convertView.findViewById(R.id.img_poster);

        // Populate the data into the template view using the data object
        idiomaOriginal.setText("Idioma Original: "+pel.getOriginalLanguage());
        TitulOriginal.setText("Titulo del pais de Origen: "+pel.getOriginalTitle());
        resumen.setText("Resumen: \n"  + pel.getOverview());
        tituloEspañol.setText("Titulo Original: "+pel.getTitle());
        popularidad.setText("Popularidad = "+ pel.getPopularity());
        votos.setText("Votacion promedio = "+ pel.getVoteAverage());
        Picasso.get().load(pel.getPosterPath()).into(poster);

        // Return the completed view to render on screen
        return convertView;
    }

}
