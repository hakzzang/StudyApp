package hbs.com.freetoeicapp.Activity

import android.annotation.SuppressLint
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import hbs.com.freetoeicapp.Adapter.SearchResultAdapter
import hbs.com.freetoeicapp.Model.Movie
import hbs.com.freetoeicapp.Model.MovieItem
import hbs.com.freetoeicapp.R
import hbs.com.freetoeicapp.Utils.ConnectService
import hbs.com.freetoeicapp.Utils.ConnectUtils
import hbs.com.freetoeicapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main2.*
import kotlinx.android.synthetic.main.content_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    /*
    * Retrofit으로 Naver Search API 사용
    * MVVM 패턴으로 RecyclerView 갱신
    * */

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

    private var activityMainBinding:ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        requestManager = Glide.with(this)

        connectUtils = ConnectUtils();
        initView()

        searchResultAdapter = SearchResultAdapter(this@MainActivity, movieSearchArrayList!!, requestManager!!)
        movieSearchRV.layoutManager = LinearLayoutManager(this@MainActivity)
        movieSearchRV.adapter = searchResultAdapter
    }
    private fun initView(){
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        toolbar.title = ""
    }

    private fun updateViewUi(moviesResult: List<MovieItem>?) {
        if(movieSearchArrayList!!.size>0){
            Log.d("itemIndex:", (movieSearchArrayList.size-1).toString())
            searchResultAdapter!!.notifyItemRangeRemoved(0, movieSearchArrayList.size)
        }

        movieSearchArrayList.clear()

        for (movieItem in moviesResult!!) {
            movieSearchArrayList.add(movieItem)
            searchResultAdapter!!.notifyItemInserted(movieSearchArrayList.size - 1)
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.search_menu, menu)
        val searchItem = menu.findItem(R.id.action_search)
        val searchView : SearchView = searchItem.actionView as SearchView
        searchView.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener, SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                //submit
                //https://openapi.naver.com/v1/search/movie.json
                val movieConnector = connectUtils!!.makeRetrofitObject(naverApiUrl).create(ConnectService::class.java);
                //naver_client_id와 naver_client_secret은 naver개발자 홈페이지로 부터 획득해서 xml에 저장해서 호출
                val callMovie = movieConnector.movieContributors(getString(R.string.naver_client_id), getString(R.string.naver_client_secret), "v1", "search", "movie.json", query);
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
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
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
