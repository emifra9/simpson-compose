package com.emifra9.simpson.view.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.emifra9.simpson.data.dto.Cartoon
import com.emifra9.simpson.view.component.CartoonGrid
import com.emifra9.simpson.view.component.CartoonModal
import com.emifra9.simpson.view.component.Indicator
import com.emifra9.simpson.viewmodel.MainViewModel

@Composable
fun MainView(viewModel: MainViewModel) {
    val cartoonListState = viewModel.cartoonListState
    val cartoonList = cartoonListState.value
    val loading = viewModel.loading

    val showDialog = remember { mutableStateOf(false) }
    val selectedCartoon = remember { mutableStateOf<Cartoon?>(null) }

    if (loading.value) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Indicator(size = 100.dp)
        }
    } else {
        cartoonList.data?.let {
            CartoonGrid(cartoonList = it.list) { cartoon ->
                selectedCartoon.value = cartoon
                showDialog.value = true
            }
        }
    }

    if (showDialog.value) {
        selectedCartoon.value?.let { cartoon ->
            CartoonModal(cartoon, onDismiss = { showDialog.value = false })
        }
    }

}
