package com.bbs.learnandtest

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bbs.learnandtest.glidelib.GlidePhotoView
import com.bbs.learnandtest.ui.theme.LearnandtestTheme
import com.bbs.learnandtest.uilayer.MainScreenState
import com.bbs.learnandtest.uilayer.MainScreenViewModel

/**
 * State hoisting
 * */
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    name: String = "",
    viewModel: MainScreenViewModel = hiltViewModel(),
) {
    MainContent(
        modifier = modifier,
        name = name,
        onClickGetImage = { viewModel.getImageUrl() },
        screenState = viewModel.uiState.value,
    )
}

@Composable
fun MainContent(
    modifier: Modifier = Modifier,
    name: String = "",
    onClickGetImage: () -> Unit = {},
    screenState: MainScreenState = MainScreenState.Loading,
) {
    Column(
        //modifier = modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextHeader(name, modifier)
        Button(
            // onClick = { urlState = urlTest },
            onClick = onClickGetImage,
            modifier = modifier.padding(10.dp),
        ) {
            Text(text = "Load image")
        }
        GlidePhotoView(modifier, screenState)
    }
}

@Composable
fun TextHeader(name: String, modifier: Modifier) {
    Text(
        text = buildString {
            append(stringResource(id = R.string.app_name))
            append(" - ")
            append(name)
        } ,
        modifier = modifier.padding(10.dp),
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MainScreenPreview() {
    LearnandtestTheme {
        MainContent()
    }
}