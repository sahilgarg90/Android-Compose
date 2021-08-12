package com.android15dev.androidcompose.practice_views

import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

var i = 0

@Composable
fun SideEffectFun() {
    // This will make sure this block of code will execute when this composable successfully re-composed.
    // If composition fails then this block of code will not executed
    SideEffect {
        i++
    }

    Button(onClick = {

    }) {
        Text(text = "Click Me")
    }
}

@Composable
fun DisposableEffectFun(backPressedDispatcher: OnBackPressedDispatcher) {

    val callback = remember {
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Do Something
            }
        }
    }

    // When we have to free up something inside a composable then we should use this
    DisposableEffect(key1 = backPressedDispatcher) {
        backPressedDispatcher.addCallback(callback)

        onDispose {
            callback.remove()
        }
    }

    Button(onClick = {

    }) {
        Text(text = "Click Me")
    }
}

@Composable
fun LaunchedEffectFun() {
    val scaffoldState = rememberScaffoldState()
    val counter = remember {
        mutableStateOf(0)
    }

    if(counter.value % 5 == 0 && counter.value > 0){
        // To call suspend functions safely from inside a composable
        LaunchedEffect(key1 = scaffoldState.snackbarHostState) {
            scaffoldState.snackbarHostState.showSnackbar("Hello ${counter.value}")
        }
    }
    Scaffold(scaffoldState = scaffoldState, modifier = Modifier.fillMaxSize()) {
        Button(onClick = { counter.value++ }) {
            Text(text = "Click Me ${counter.value}")
        }
    }
}

@Composable
fun ProduceStateFun() {
    val scaffoldState = rememberScaffoldState()

    // convert non-Compose state into Compose state
    val counter = produceState(initialValue = 0) {
        kotlinx.coroutines.delay(2000L)
        this.value = 5
    }

    if(counter.value % 5 == 0 && counter.value > 0){
        // To call suspend functions safely from inside a composable
        LaunchedEffect(key1 = scaffoldState.snackbarHostState) {
            scaffoldState.snackbarHostState.showSnackbar("Hello ${counter.value}")
        }
    }
    Scaffold(scaffoldState = scaffoldState, modifier = Modifier.fillMaxSize()) {
        Button(onClick = {  }) {
            Text(text = "Click Me ${counter.value}")
        }
    }
}