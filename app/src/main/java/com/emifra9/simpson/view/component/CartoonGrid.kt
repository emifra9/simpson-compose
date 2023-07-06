package com.emifra9.simpson.view.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.emifra9.simpson.data.dto.Cartoon


@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterialApi::class)
@Composable
fun CartoonGrid(cartoonList: List<Cartoon>, onClick: (Cartoon)->Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp)
    ) {
        items(cartoonList.size) { index ->
            val character = cartoonList[index]

            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 8.dp)
                    .aspectRatio(0.6f),
                elevation = 8.dp,
                shape = RoundedCornerShape(12.dp),
                onClick = { onClick(character) }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = character.name,
                        modifier = Modifier.padding(bottom = 8.dp),
                        style = TextStyle(fontWeight = FontWeight.Bold),
                        textAlign = TextAlign.Center
                    )

                    GlideImage(
                        model = character.imageUrl,
                        contentDescription = character.name,
                        modifier = Modifier
                            .size(120.dp)
                            .clip(MaterialTheme.shapes.medium),
                        contentScale = ContentScale.Fit
                    )
                }

            }
        }
    }
}

@Preview
@Composable
fun PreviewGrid() {
    val cartoonList = listOf(
        Cartoon(
            _id = "63e2beaee6c69920933ff310",
            name = "Marge Simpson",
            history = "Marjorie Marge B. Simpson ,  (de soltera Bouvier ; nacida el 19 de marzo  ), es la feliz ama de casa y madre de tiempo completo de la familia Simpson . Con su esposo Homer",
            imageUrl = "https://res.cloudinary.com/dglqojivj/image/upload/v1682559694/simpsons/250px-Marge_Simpson_ivadwr.png",
            gender = "Femenino", status = "Vivo", occupation = "Ama de casa"
        )
    )
    CartoonGrid(cartoonList = cartoonList, onClick= { })

}

