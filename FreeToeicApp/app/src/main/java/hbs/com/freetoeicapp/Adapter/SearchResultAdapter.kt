package hbs.com.freetoeicapp.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import com.bumptech.glide.RequestManager
import hbs.com.freetoeicapp.Activity.MainActivity.Companion.tempItemLayout
import hbs.com.freetoeicapp.Model.MovieItem
import hbs.com.freetoeicapp.R

class SearchResultAdapter(mContext: Context, arrayList:ArrayList<MovieItem>, requestManager:RequestManager) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var context:Context? = mContext
    var searchItemList:ArrayList<MovieItem>? = arrayList
    var mRequestManager:RequestManager = requestManager
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.movie_recycler_item,parent,false)

        return SearchItemHolder(view)
    }

    override fun getItemCount(): Int {
        return searchItemList!!.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val movieItem = searchItemList!!.get(position)
        if(holder is SearchItemHolder){
            holder.positionTV.text = (position+1).toString()
            holder.movieTitleTV.text = movieItem.title
            holder.searchLL.setOnClickListener {
                _ ->
                if(tempItemLayout!=null){
                    tempItemLayout!!.visibility = View.GONE
                }
                holder.expanded_layout.visibility = View.VISIBLE
                mRequestManager.load(movieItem.image).into(holder.movieImageView)
                holder.pubDateTV.text = movieItem.pubDate
                holder.movieRatingBar.rating = (movieItem.userRating.toFloat() / 2.0).toFloat()
                tempItemLayout = holder.expanded_layout
            }
        }
    }

    class SearchItemHolder(mItemView:View): RecyclerView.ViewHolder(mItemView){
        var positionTV: TextView = mItemView.findViewById(R.id.positionTV)
        var movieTitleTV: TextView = mItemView.findViewById(R.id.movieTitleTV)
        var movieImageView: ImageView = mItemView.findViewById(R.id.movieImageView)
        var searchLL : LinearLayout = mItemView.findViewById(R.id.searchLL)
        var expanded_layout : LinearLayout = mItemView.findViewById(R.id.expanded_layout)
        var pubDateTV: TextView = mItemView.findViewById(R.id.pubDateTV)
        var movieRatingBar: RatingBar = mItemView.findViewById(R.id.movieRatingBar)
    }
}