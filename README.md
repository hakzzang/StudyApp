StudyApp a.k.a Naver Movie Test App 
=============
Naver API Site : https://developers.naver.com/docs/search/blog/
## retrofit

~~~
I use retrofit library for Naver Search API.
implementation 'com.squareup.retrofit2:retrofit:2.3.0'
implementation 'com.squareup.retrofit2:converter-gson:2.3.0'
~~~
#### ConnectService.class
~~~
public class ConnectUtils {
    private Retrofit retrofitObject = null;
    public Retrofit makeRetrofitObject(String baseUrl) {
        retrofitObject = new Retrofit.Builder().
                baseUrl(baseUrl).
                addConverterFactory(GsonConverterFactory.create()).
                build();

        return retrofitObject;
    }
    ...
}
~~~
#### ConnectUtils.class
~~~
public interface ConnectService {
    /*
    Naver Movie Search API
    exampleUrl : https://openapi.naver.com/v1/search/movie.json
    */

    @GET("{version}/{api_type}/{file_type}")
    Call<Movie> movieContributors(
            @Header("X-Naver-Client-Id") String clientId,
            @Header("X-Naver-Client-Secret") String clientSecret,
            @Path("version") String version,
            @Path("api_type") String apiType,
            @Path("file_type") String fileType,
            @Query("query") String movieName
    );

}
~~~
