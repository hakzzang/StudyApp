package hbs.com.freetoeicapp.Adapter

/*

class CurrentMovieRV(mRequestManager: RequestManager) : RecyclerView.Adapter<BindingViewHolder<MovieRecyclerItemBinding>>() {

    */
/*var movieArrayList:ArrayList<Movie>? = null
    companion object {
        var TAG = CurrentMovieRV.javaClass.name;
        @SuppressLint("StaticFieldLeak")
        var requestManager: RequestManager? = null
    }

    init {
        requestManager = mRequestManager
    }

    fun setArrayList(apiMovieArrayList:ArrayList<Movie>){
        for(apiMovie in apiMovieArrayList){
            movieArrayList!!.add(apiMovie)
            notifyItemInserted(movieArrayList!!.size-1)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<MovieRecyclerItemBinding> {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        return BindingViewHolder(layoutInflater.inflate(R.layout.movie_recycler_item, parent, false))
    }

    override fun getItemCount(): Int
    {
        return movieArrayList!!.size
    }

    override fun onBindViewHolder(holder: BindingViewHolder<MovieRecyclerItemBinding>, position: Int) {
        holder.binding().detail_movie = movieArrayList
        requestManager!!.load(holder.binding().detail_movie.movies.get(position).movieImageUrl)
    }*//*


}*/
