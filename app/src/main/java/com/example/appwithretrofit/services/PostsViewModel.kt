package com.example.appwithretrofit.services
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.appwithretrofit.models.PostsModel

class PostsViewModel : ViewModel() {
    var posts by mutableStateOf<List<PostsModel>>(emptyList())
        private set

    fun fetchPosts() {
        viewModelScope.launch {
            try {
                val apiService = RetrofitInstance.retrofit.create(ApiService::class.java)
                posts = apiService.getData()
            } catch (e: Exception) {
                Log.e("YourViewModel", "Error fetching posts: ${e.message}", e)
            }
        }
    }
}
