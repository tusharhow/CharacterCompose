package com.example.charactercompose.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.charactercompose.models.Result

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterCard(
    it: Result,
) {
    Card(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth(),
        onClick = {
            //TODO
        },

        ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = it.image,
                contentDescription = null,
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Column {
                Text(
                    text = it.name, style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Text(
                    text = it.species, style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                    )
                )
            }
            Spacer(modifier = Modifier.weight(1f))

            IconButton(onClick = { /*TODO*/ }, content = {
                Icon(
                    Icons.Filled.ArrowForward, contentDescription = null
                )
            })
        }
    }
}