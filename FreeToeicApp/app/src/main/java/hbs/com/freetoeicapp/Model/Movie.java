package hbs.com.freetoeicapp.Model;

import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("total")
    private String resultCount;
    @SerializedName("item")
    private MovieItem movieItem;

    public Movie(String resultCount, MovieItem movieItem) {
        this.resultCount = resultCount;
        this.movieItem = movieItem;
    }

    public String getResultCount() {
        return resultCount;
    }

    public MovieItem getMovieItem() {
        return movieItem;
    }
}
