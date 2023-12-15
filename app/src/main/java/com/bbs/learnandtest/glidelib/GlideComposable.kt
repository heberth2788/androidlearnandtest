package com.bbs.learnandtest.glidelib

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.bbs.learnandtest.R
import com.bbs.learnandtest.uilayer.MainScreenState
import com.bumptech.glide.integration.compose.CrossFade
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
//fun GlidePhotoView(modifier: Modifier, url: String) {
fun GlidePhotoView(modifier: Modifier, state: MainScreenState) {
    GlideImage(
        //model = url.ifBlank { stringResource(id = R.string.default_photo_url) },
        model = when(state) {
            MainScreenState.Loading -> stringResource(id = R.string.default_photo_url)
            is MainScreenState.Success -> {
                Log.d("GlidePhotoView", state.data.photoUrl)
                state.data.photoUrl
            }
            is MainScreenState.Failure -> {
                Log.d("GlidePhotoView", state.message)
                stringResource(id = R.string.default_photo_url)
            }
        },
        transition = CrossFade,
        contentDescription = "Testing Glide",
        modifier = modifier
            .padding(all = 10.dp)
            .fillMaxWidth(),
        loading = placeholder(android.R.drawable.progress_indeterminate_horizontal),
        failure = placeholder(android.R.drawable.progress_horizontal),
    )
}