package com.example.charactercompose.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.charactercompose.components.CharacterCard
import com.example.charactercompose.views.viewmodels.CharacterViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(characterViewModel: CharacterViewModel = viewModel()) {
    val character = characterViewModel.characterData.observeAsState().value
    val isLoading = characterViewModel.isLoading.observeAsState().value
    val error = characterViewModel.error.observeAsState().value
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(
                text = "Characters App", style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
            )
        })
    }

    ) { innerPadding ->
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            if (isLoading == true) {
                CircularProgressIndicator()
            } else if (error != null) {
                Text(text = error)
            } else {
                LazyColumn(
                    modifier = Modifier.padding(innerPadding)
                ) {
                    character?.results?.forEach {
                        item {
                            CharacterCard(it = it)
                        }
                    }
                }
            }
        }
    }
}