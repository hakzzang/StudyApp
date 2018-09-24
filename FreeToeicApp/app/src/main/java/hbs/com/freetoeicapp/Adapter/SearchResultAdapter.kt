package hbs.com.freetoeicapp.Adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import hbs.com.freetoeicapp.Model.BoxOfficeItem
import hbs.com.freetoeicapp.Model.MovieItem
import hbs.com.freetoeicapp.R
import hbs.com.freetoeicapp.Utils.MainUtils.BOX_OFFICE_CLASS_TYPE
import hbs.com.freetoeicapp.Utils.MainUtils.MOVIE_CLASS_TYPE
import hbs.com.freetoeicapp.ViewModel.BoxOfficeViewModel
import hbs.com.freetoeicapp.ViewModel.MovieViewModel
import hbs.com.freetoeicapp.databinding.MovieRecyclerItemBinding
import hbs.com.freetoeicapp.databinding.OfficeRecyclerItemBinding

class SearchResultAdapter(mContext: Context, arrayList:ArrayList<*>, requestManager:RequestManager) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var context:Context? = mContext
    var searchItemList: ArrayList<*> = arrayList
    var mRequestManager:RequestManager = requestManager
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType== MOVIE_CLASS_TYPE){
            val itemBinding:MovieRecyclerItemBinding=DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.movie_recycler_item, parent, false)
            return MovieBindingHolder(itemBinding)
        }else if(viewType== BOX_OFFICE_CLASS_TYPE){
            val itemBinding:OfficeRecyclerItemBinding=DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.office_recycler_item, parent, false)
            return OfficeBindingHolder(itemBinding)
        }

        val itemBinding:OfficeRecyclerItemBinding=DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.office_recycler_item, parent, false)
        return OfficeBindingHolder(itemBinding)

    }

    override fun getItemCount(): Int {
        return searchItemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is MovieBindingHolder){
            val movieItem = searchItemList.get(position) as MovieItem
            holder.binding.movieViewModel = MovieViewModel(movieItem = movieItem, movieRecyclerItemBinding = holder.binding)
            holder.binding.movieViewModel!!.onCreate(position,mRequestManager)
        }

        if(holder is OfficeBindingHolder){
            val officeItem= searchItemList.get(position) as BoxOfficeItem
            holder.binding.officeViewModel = BoxOfficeViewModel(officeItem, holder.binding)
            holder.binding.officeViewModel!!.onCreate(position,mRequestManager)
        }
    }

    override fun getItemViewType(position: Int): Int {
        if(searchItemList[position] is MovieItem)
            return MOVIE_CLASS_TYPE

        else if(searchItemList[position] is BoxOfficeItem)
            return BOX_OFFICE_CLASS_TYPE

        return 0
    }

    class MovieBindingHolder(val binding: MovieRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root)
    class OfficeBindingHolder(val binding: OfficeRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root)
}