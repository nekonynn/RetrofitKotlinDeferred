package io.navendra.retrofitkotlindeferred.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.navendra.retrofitkotlindeferred.R
import io.navendra.retrofitkotlindeferred.service.ApiFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // val service = ApiFactory.placeholderApi

        val movieService = ApiFactory.tmdbApi

        /*
        //Getting Posts from Jsonplaceholder API
        GlobalScope.launch(Dispatchers.Main) {
            val postRequest = service.getPosts()
            try {
                val response = postRequest.await()
                if(response.isSuccessful){
                    val posts = response.body()
                }else{
                    Log.d("MainActivity ",response.errorBody().toString())
                }

            }catch (e: Exception){

            }
        }


        //Getting Users from Jsonplaceholder API
        GlobalScope.launch(Dispatchers.Main) {
            val userRequest = service.getUsers()
            try {
                val response = userRequest.await()
                if(response.isSuccessful){
                    val users = response.body()
                }else{
                    Log.d("MainActivity ",response.errorBody().toString())
                }

            }catch (e: Exception){

            }
        }

        //Getting Users from Jsonplaceholder API
        GlobalScope.launch(Dispatchers.Main) {
            val userRequest = service.getPhotos()
            try {
                val response = userRequest.await()
                if(response.isSuccessful){
                    val photos = response.body()
                    val lastPhotoUrl = photos?.last()?.url
                    Picasso.get().load(lastPhotoUrl).into(imageView)
                }else{
                    Log.d("MainActivity ",response.errorBody().toString())
                }


            }catch (e: Exception){

            }
        }
        */

        GlobalScope.launch(Dispatchers.Main) {
            Log.d("MainActivityResult", "Testing from couroutines!")
            val popularMovieRequest = movieService.getPopularMovie()
            try {
                Log.d("MainActivityResult", "Testing from try block!")
                val response = popularMovieRequest.await()
                if (response.isSuccessful) {
                    toast("Data Get!")
                    Log.d("MainActivityResult", "Data Get!")
                    val movieResponse = response.body() //This is single object Tmdb Movie response
                    val popularMovies = movieResponse?.results // This is list of TMDB Movie
                    popularMovies?.let {
                        for (movie in popularMovies) {
                            Log.d("MainActivityResult", "Movie Name: ${movie.title}, Original Movie Name: ${movie.original_title}")
                        }
                    }
                } else {
                    Log.d("MainActivity", response.errorBody().toString())
                }
            } catch (e: Exception) {

            }
        }

        Log.d("MainActivityResult", "Testing!")
    }
}
