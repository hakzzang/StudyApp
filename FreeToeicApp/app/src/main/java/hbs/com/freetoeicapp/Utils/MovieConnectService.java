package hbs.com.freetoeicapp.Utils;

import java.util.List;

import hbs.com.freetoeicapp.Model.Movie;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MovieConnectService {
    /*
    영화검색 API
    exampleUrl : https://openapi.naver.com/v1/search/movie.json
    */
    @GET("{version}/{api_type}/{file_type}")
    Call<List<Movie>> movieContributors(
            @Path("version") String version,
            @Path("api_type") String apiType,
            @Path("file_type") String fileType
    );

    public static final Retrofit movieRetrofit = new Retrofit.Builder().
            baseUrl("https://openapi.naver.com").
            addConverterFactory(GsonConverterFactory.create()).
            build();
}
