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
import com.bbs.learnandtest.retrofitlib.ApiService
import com.bbs.learnandtest.retrofitlib.MyData
import com.bbs.learnandtest.retrofitlib.RetrofitClient
import com.bbs.learnandtest.roomlib.AppDatabase
import com.bbs.learnandtest.roomlib.LearnAndTestDatabase
import com.bbs.learnandtest.roomlib.User
import com.bbs.learnandtest.ui.theme.LearnandtestTheme
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
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
                    MainScreen(name = "HD")
                }
            }
        }

        // Consuming a web service with Retrofit from a Coroutine
        // apiService = RetrofitClient.retrofit.create(ApiService::class.java)
        consumeWebServiceWithRetrofit()

        insertAndGetDataToDatabase()
    }

    private fun insertAndGetDataToDatabase() {
        Log.d(TAG, "insertAndGetDataToDatabase")
        lifecycleScope.launch(Dispatchers.IO) {
            val db: AppDatabase? = LearnAndTestDatabase.getDatabase(application.applicationContext)
            db?.userDao()?.insertAll(User(
                dni = "45453948",
                name = "Heberth",
                surname = "Deza",
                state = true,
                code = 1988,
                desc = "PM"
            ), User(
                dni = "44309130",
                name = "Lilian",
                surname = "Martinez",
                state = true,
                code = 1987,
                desc = "PO"
            ))
            val users: List<User>? = db?.userDao()?.getAll()
            users?.let {
                for(u in it){
                    Log.d(TAG, u.toString())
                }
            }
        }
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

