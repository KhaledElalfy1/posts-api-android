import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items


import androidx.compose.material3.CircularProgressIndicator


import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.example.appwithretrofit.models.PostsModel
import com.example.appwithretrofit.services.PostsViewModel

@Composable
fun PostsListScreen(
    innerPadding: PaddingValues,
    postsViewModel: PostsViewModel=PostsViewModel(),
) {
    val posts = postsViewModel.posts

    LaunchedEffect(Unit) {
        postsViewModel.fetchPosts()
    }

    if (posts.isEmpty()) {
        CircularProgressIndicator()
    } else {
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {

            items(posts) { post->
                PostItem(post)

            }
        }
    }
}

@Composable
fun PostItem(post: PostsModel) {
    Column {
        Text(text = post.title, style = MaterialTheme.typography.titleSmall)
        Text(text = post.body, style = MaterialTheme.typography.bodySmall)
        Divider()
    }
}
