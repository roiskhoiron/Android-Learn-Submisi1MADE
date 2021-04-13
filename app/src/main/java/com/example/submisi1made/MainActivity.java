package com.example.submisi1made;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MovieAdapter movieAdapter;

    private String[] dataName, dataRelease, dataCategory, dataDirector, dataDesc ;
    private TypedArray dataPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lv_listMovie);
        movieAdapter = new MovieAdapter(this);
        listView.setAdapter(movieAdapter);

        preapare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Movie movieParcel = new Movie();
                if (movieParcel != null){
                    movieParcel.setName(dataName[i]);
                    movieParcel.setRelease(dataRelease[i]);
                    movieParcel.setCategoty(dataCategory[i]);
                    movieParcel.setDirector(dataDirector[i]);
                    movieParcel.setDescription(dataDesc[i]);
                    movieParcel.setBanner(dataPhoto.getResourceId(i, -1));
                }

                Intent intent = new Intent(MainActivity.this, MovieDetailActivity.class);
                intent.putExtra(MovieDetailActivity.MOVIE_INDEX, movieParcel);
                startActivity(intent);
            }
        });
    }

    private void addItem() {
        ArrayList<Movie> movies = new ArrayList<>();

        for (int i = 0; i <dataName.length; i++){
            Movie movie = new Movie();
            movie.setName(dataName[i]);
            movie.setRelease(dataRelease[i]);
            movie.setCategoty(dataCategory[i]);
            movie.setDirector(dataDirector[i]);
            movie.setDescription(dataDesc[i]);
            movie.setBanner(dataPhoto.getResourceId(i, -1));

            movies.add(movie);
        }

        movieAdapter.setMovies(movies);
    }

    private void preapare() {
        dataName = getResources().getStringArray(R.array.movie_name);
        dataRelease = getResources().getStringArray(R.array.release_date);
        dataCategory = getResources().getStringArray(R.array.category_film);
        dataDirector = getResources().getStringArray(R.array.director);
        dataDesc = getResources().getStringArray(R.array.movie_desc);
        dataPhoto = getResources().obtainTypedArray(R.array.movie_banner);

    }
}
