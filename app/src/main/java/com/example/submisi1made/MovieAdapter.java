package com.example.submisi1made;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class MovieAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<Movie> movies = new ArrayList<>();

    void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    MovieAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;

        if (itemView == view) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie);

        return itemView;
    }

    private class ViewHolder {
        private TextView tvName, tvDesc;
        private ImageView imgvPhoto;

        ViewHolder(View view) {
            this.tvName = view.findViewById(R.id.tv_name);
            this.tvDesc = view.findViewById(R.id.tv_desc);
            this.imgvPhoto = view.findViewById(R.id.imgv_photo);
        }

        void bind(Movie movie){
            tvName.setText(movie.getName());
            tvDesc.setText(movie.getDescription());
            imgvPhoto.setImageResource(movie.getBanner());
        }
    }
}
