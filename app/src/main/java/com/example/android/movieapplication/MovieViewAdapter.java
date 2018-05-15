package com.example.android.movieapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class MovieViewAdapter extends RecyclerView.Adapter<MovieViewAdapter.MovieViewAdapterViewHolder>  {

    private String[] mMovieData;

    private final MovieViewAdapterOnClickHandler mClickHandler;

    public interface MovieViewAdapterOnClickHandler {
        void onClick(String movieName);
    }

    public MovieViewAdapter(MovieViewAdapterOnClickHandler clickHandler) {
        mClickHandler = clickHandler;
    }

    public class MovieViewAdapterViewHolder extends RecyclerView.ViewHolder implements OnClickListener {
        public final TextView mMovieTextView;

        public MovieViewAdapterViewHolder(View view) {
            super(view);
            mMovieTextView = (TextView) view.findViewById(R.id.movie_data);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            String movie_str = mMovieData[adapterPosition];
            mClickHandler.onClick(movie_str);
        }
    }

        @Override
        public MovieViewAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            Context context = viewGroup.getContext();
            int layoutIdForListItem = R.layout.movie_list_item;
            LayoutInflater inflater = LayoutInflater.from(context);
            boolean shouldAttachToParrentImmediately = false;

            View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParrentImmediately);
            return new MovieViewAdapterViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MovieViewAdapterViewHolder movieViewAdapterViewHolder, int position) {
            String movie_str = mMovieData[position];
            movieViewAdapterViewHolder.mMovieTextView.setText(movie_str);
        }

        @Override
        public int getItemCount() {
            if(null == mMovieData) return 0;
            return mMovieData.length;
        }

        public void setmMovieData(String[] movieData) {
            mMovieData = movieData;
            notifyDataSetChanged();
        }

    }
}
