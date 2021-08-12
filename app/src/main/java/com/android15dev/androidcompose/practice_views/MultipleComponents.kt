package com.android15dev.androidcompose.practice_views

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@Composable
fun ShowSnackBarAsView() {
    Snackbar {
        Text(text = "Sahil Garg")
    }
}

@Composable
fun ShowGreetingView() {
    val scaffoledState = rememberScaffoldState()
    var textFieldState by remember {
        mutableStateOf("")
    }
    var snackBarStatus by remember {
        mutableStateOf("")
    }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoledState
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = textFieldState, onValueChange = {
                    textFieldState = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                singleLine = true,
                label = {
                    Text(text = "Enter Name Here")
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.padding(horizontal = 12.dp)) {
                Text(
                    text = snackBarStatus, modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
                Button(onClick = {
                    if (textFieldState.isNotEmpty()) {
                        coroutineScope.launch {
                            val result = scaffoledState.snackbarHostState.showSnackbar(
                                "Hello $textFieldState",
                                actionLabel = "Okay",
                                duration = SnackbarDuration.Short
                            )

                            snackBarStatus = "SnackBar ${result.name}"
                        }
                    }
                }) {
                    Text(text = "Press Me!")
                }
            }
        }
    }
}