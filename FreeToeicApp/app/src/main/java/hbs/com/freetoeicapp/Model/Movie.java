package hbs.com.freetoeicapp.Model;

import android.databinding.ObservableField;

import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("userRating")
    public ObservableField<Integer> movieRating = new ObservableField<>();
    @SerializedName("title")
    public ObservableField<String> movieName = new ObservableField<>();
    @SerializedName("image")
    public ObservableField<String> movieImageUrl = new ObservableField<>();
    @SerializedName("pubDate")
    public ObservableField<String> pubDate = new ObservableField<>();

    public Movie(int movieRating, String movieName, String movieImageUrl, String pubDate) {
        this.movieRating.set(movieRating);
        this.movieName.set(movieName);
        this.movieImageUrl.set(movieImageUrl);
        this.pubDate.set(pubDate);
    }

    public Movie(Movie movie){
        this.movieRating.set(movie.getMovieRating());
        this.movieName.set(movie.getMovieName());
        this.movieImageUrl.set(movie.getMovieImageUrl());
        this.pubDate.set(movie.getPubDate());
    }

    public Integer getMovieRating() {
        return movieRating.get();
    }

    public String getMovieName() {
        return movieName.get();
    }

    public String getMovieImageUrl() {
        return movieImageUrl.get();
    }

    public String getPubDate() {
        return pubDate.get();
    }
}
