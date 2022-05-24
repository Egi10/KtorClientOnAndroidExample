package com.buaja.ktorclientonandroidexample.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.buaja.ktorclientonandroidexample.ui.theme.KtorClientOnAndroidExampleTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onResume() {
        super.onResume()

        viewModel.getCat()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val uiState = viewModel.uiState.collectAsState()

            KtorClientOnAndroidExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(
                                all = 32.dp
                            )
                    ) {
                        Text(
                            text = "Hello Ktor with Koin Here",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(
                            modifier = Modifier
                                .padding(
                                    top = 16.dp
                                )
                        )



                        SubcomposeAsyncImage(
                            model = uiState.value.url,
                            contentDescription = null,
                            loading = {
                                CircularProgressIndicator()
                            },
                        )

                        Spacer(
                            modifier = Modifier
                                .padding(
                                    top = 16.dp
                                )
                        )

                        Button(
                            onClick = {
                                viewModel.getCat()
                            },
                            modifier = Modifier
                                .height(56.dp)
                        ) {
                            if (uiState.value.loading) {
                                CircularProgressIndicator(
                                    modifier = Modifier
                                        .size(24.dp),
                                    color = Color.White
                                )
                            } else {
                                Text(text = "Reload New Image")
                            }
                        }
                    }
                }
            }
        }
    }
}