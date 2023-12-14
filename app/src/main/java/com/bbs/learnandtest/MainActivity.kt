package com.bbs.learnandtest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.bbs.learnandtest.retrofitapi.ApiService
import com.bbs.learnandtest.retrofitapi.MyData
import com.bbs.learnandtest.retrofitapi.RetrofitClient
import com.bbs.learnandtest.ui.theme.LearnandtestTheme
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call

class MainActivity : ComponentActivity() {

//     private lateinit var apiService: ApiService

//    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
//        Log.d(TAG, "Exception caught : ${throwable.message}")
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        setContent {
            LearnandtestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }

        // Consuming a web service with Retrofit from a Coroutine
        // apiService = RetrofitClient.retrofit.create(ApiService::class.java)
        consumeWebServiceWithRetrofit()
    }

    /**
     * Consume a web service using Retrofit2 library.
     * It use coroutines to doesn't block the main thread.
     * */
    private fun consumeWebServiceWithRetrofit() {
        Log.d(TAG, "consumeWebServiceWithRetrofit")
        val apiService: ApiService = RetrofitClient.retrofit.create(ApiService::class.java)
        lifecycleScope.launch(context = Dispatchers.IO) { // lifecycleScope.launch(context = Dispatchers.IO + exceptionHandler) {
            try {
                val data: MyData = apiService.getData()
                Log.d(TAG, "Name: ${data.name}")

                val jsonStr: String = Gson().toJson(data)
                Log.d(TAG, "Json: $jsonStr")
            } catch(e: Exception) {
                Log.d(TAG, "Exception caught : ${e.message}")
            }
        }
    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnandtestTheme {
        Greeting("Android developer")
    }
}