package hbs.com.freetoeicapp.ViewModel

import android.databinding.BaseObservable
import android.view.View
import com.bumptech.glide.RequestManager
import hbs.com.freetoeicapp.Activity.MainActivity
import hbs.com.freetoeicapp.Model.MovieItem
import hbs.com.freetoeicapp.databinding.MovieRecyclerItemBinding

class MovieViewModel(private var movieItem: MovieItem?, movieRecyclerItemBinding:MovieRecyclerItemBinding) : BaseObservable() {
    val movieItemBinding = movieRecyclerItemBinding
    fun getMovieData(): MovieItem? {
        return movieItem
    }

    fun onCreate(itemPosition:Int, mRequestManager:RequestManager){
        movieItemBinding.positionTV.text = (itemPosition+1).toString()
        movieItemBinding.searchLL.setOnClickListener {
            _ ->
            if(MainActivity.tempItemLayout !=null){
                MainActivity.tempItemLayout!!.visibility = View.GONE
            }
            movieItemBinding.expandedLayout.visibility = View.VISIBLE
            mRequestManager.load(movieItem!!.image).into(movieItemBinding.movieImageView)
            movieItemBinding.movieRatingBar.rating = (movieItem!!.userRating.toFloat() / 2.0).toFloat()
            MainActivity.tempItemLayout = movieItemBinding.expandedLayout
        }
    }
}