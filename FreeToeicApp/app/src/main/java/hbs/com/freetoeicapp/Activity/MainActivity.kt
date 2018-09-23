package hbs.com.freetoeicapp.Activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import hbs.com.freetoeicapp.Adapter.SearchResultAdapter
import hbs.com.freetoeicapp.Model.Movie
import hbs.com.freetoeicapp.Model.MovieItem
import hbs.com.freetoeicapp.R
import hbs.com.freetoeicapp.Utils.ConnectService
import hbs.com.freetoeicapp.Utils.ConnectUtils
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        var tempItemLayout: LinearLayout? = null
    }

    private var requestManager: RequestManager? = null
    private var connectUtils: ConnectUtils? = null
    private var searchResultAdapter: SearchResultAdapter? = null
    private val movieSearchArrayList: ArrayList<MovieItem>? = ArrayList()
    private val naverApiUrl = "https://openapi.naver.com"
    val SUCCESS_STATUS = 200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestManager = Glide.with(this)
        connectUtils = ConnectUtils();
        searchResultAdapter = SearchResultAdapter(this@MainActivity, movieSearchArrayList!!, requestManager!!)
        movieSearchRV.layoutManager = LinearLayoutManager(this@MainActivity)
        movieSearchRV.adapter = searchResultAdapter

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
                val movies = response!!.body()
                when (response.code()) {
                    SUCCESS_STATUS -> {
                        statusTV.text = ""
                        updateViewUi(movies!!.item)
                    }
                    else -> statusTV.text = response.toString()
                }
            }
        })
    }


    fun updateViewUi(moviesResult: List<MovieItem>?) {
        for (movieItem in moviesResult!!) {
            movieSearchArrayList!!.add(movieItem)
            searchResultAdapter!!.notifyItemInserted(movieSearchArrayList.size - 1)
        }
    }

    override fun onLowMemory() {
        super.onLowMemory()
        Glide.get(this@MainActivity).clearMemory()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        Glide.get(this@MainActivity).trimMemory(level)
    }

}
