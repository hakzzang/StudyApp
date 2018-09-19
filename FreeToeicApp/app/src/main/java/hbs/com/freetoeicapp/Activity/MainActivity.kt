package hbs.com.freetoeicapp.Activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import hbs.com.freetoeicapp.R
import hbs.com.freetoeicapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    var activityMainBinding:ActivityMainBinding?=null
    var requestManager:RequestManager? = null
    //var movieViewModel = MovieViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestManager = Glide.with(this)


        //activityMainBinding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        /*val currentMovieRV = CurrentMovieRV(requestManager!!)
        movieViewModel.onCreate()
        currentMovieRV.setArrayList(movieViewModel.getMovies())*/
    }
}
