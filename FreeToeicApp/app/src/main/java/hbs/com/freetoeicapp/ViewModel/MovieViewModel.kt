package hbs.com.freetoeicapp.ViewModel

/*

class MovieViewModel() : BaseObservable() {
    var movieConnectService: MovieConnectService?= null
    var movieRecyclerItemBinding: MovieRecyclerItemBinding? = null
    val movies = ObservableArrayList<Movie>()



    fun onCreate(){
        movieConnectService = MovieConnectService.movieRetrofit.create(MovieConnectService::class.java)
        val movieApiCall: Call<List<Movie>> = movieConnectService!!.movieContributors("v1","search","movie.json")
        movieApiCall.enqueue(object : Callback<List<Movie>> {
            override fun onFailure(call: Call<List<Movie>>?, t: Throwable?) {
                Log.d("ERROR", t.toString())
            }

            override fun onResponse(call: Call<List<Movie>>?, response: Response<List<Movie>>?) {
                val movieDatas = response!!.body()
                movies.add(movieDatas)
            }
        })
    }

    fun getMovies():ArrayList<MovieViewModel>{
        return movies
    }
}
*/
