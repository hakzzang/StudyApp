package hbs.com.freetoeicapp.Activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import hbs.com.freetoeicapp.Model.Movie
import hbs.com.freetoeicapp.R
import hbs.com.freetoeicapp.Utils.ConnectService
import hbs.com.freetoeicapp.Utils.ConnectUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private var requestManager: RequestManager? = null
    private var connectUtils: ConnectUtils? = null
    private val naverApiUrl = "https://openapi.naver.com"
    val SUCCESS_STATUS = 200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestManager = Glide.with(this)
        connectUtils = ConnectUtils();
        //https://openapi.naver.com/v1/search/movie.json
        val movieConnector = connectUtils!!.makeRetrofitObject(naverApiUrl).create(ConnectService::class.java);

        //naver_client_id와 naver_client_secret은 naver개발자 홈페이지로 부터 획득해서 xml에 저장해서 호출
        val callMovie = movieConnector.movieContributors(getString(R.string.naver_client_id), getString(R.string.naver_client_secret), "v1", "search", "movie.json", "덩케르크");
        callMovie.enqueue(object : Callback<Movie> {
            //호출 실패
            override fun onFailure(call: Call<Movie>?, t: Throwable?) {
                Log.d("movieConnector", t!!.message)

            }

            //호출 성공
            override fun onResponse(call: Call<Movie>?, response: Response<Movie>?) {
                val movie = response!!.body()
                when (response.code()) {
                    SUCCESS_STATUS -> updateViewUi(movie)
                    else -> Log.d("movieConnector error", response.toString())
                }
            }
        })
    }

    fun updateViewUi(movie: Movie?) {
        Log.d("movieCount", movie!!.resultCount)
    }
}
