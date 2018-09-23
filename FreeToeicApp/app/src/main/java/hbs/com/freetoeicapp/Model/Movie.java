package hbs.com.freetoeicapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {
    @SerializedName("total")
    private String resultCount;
    /*@SerializedName("item")
    private MovieItem[] movieItems;*/
    @SerializedName("items")
    List<MovieItem> item;

    public Movie(String resultCount, List<MovieItem> item) {
        this.resultCount = resultCount;
        this.item = item;
    }

    public String getResultCount() {
        return resultCount;
    }

    public void setResultCount(String resultCount) {
        this.resultCount = resultCount;
    }

    public List<MovieItem> getItem() {
        return item;
    }

    public void setItem(List<MovieItem> item) {
        this.item = item;
    }
}
