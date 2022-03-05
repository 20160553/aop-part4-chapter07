package aqper.side_project.aop_part4_chapter07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import aqper.side_project.aop_part4_chapter07.data.Repository
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val scope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchRandomPhotos()
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }

    private fun fetchRandomPhotos(query: String? = null) = scope.launch {
        Repository.getRandomPhotos(query)?.let { photos ->
            Log.d("photos", photos.toString())
        }
    }
}