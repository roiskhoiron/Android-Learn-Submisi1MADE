package com.example.submisi1made;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MovieDetailActivity extends AppCompatActivity {

    public static final String MOVIE_INDEX = "parcel movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        TextView tvName = findViewById(R.id.tv_name);
        TextView tvRelease = findViewById(R.id.tv_release);
        TextView tvCategory = findViewById(R.id.tv_category);
        TextView tvDirector = findViewById(R.id.tv_dirrector);
        TextView tvDesc = findViewById(R.id.tv_desc);
        ImageView imgvPhoto = findViewById(R.id.imgv_photo);


        Movie movieParcel = getIntent().getParcelableExtra(MOVIE_INDEX);

        assert movieParcel != null;
        tvName.setText(movieParcel.getName());
        tvRelease.setText(movieParcel.getRelease());
        tvCategory.setText(movieParcel.getCategoty());
        tvDirector.setText(movieParcel.getDirector());
        tvDesc.setText(movieParcel.getDescription());
        imgvPhoto.setImageResource(movieParcel.getBanner());
    }
}
