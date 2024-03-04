package com.example.testproduces

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.content.edit
import com.example.testproduces.di.component.AppComponent
import com.example.testproduces.di.component.DaggerAppComponent
import com.example.testproduces.di.module.AppModule
import com.example.testproduces.ui.theme.TestProducesTheme
import com.google.common.util.concurrent.FutureCallback
import com.google.common.util.concurrent.Futures
import java.util.concurrent.Executors
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    private lateinit var appComponent: AppComponent

    @Inject
    lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(application))
            .build()
        appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContent {
            var editText by remember {
                mutableStateOf("")
            }
            var savedText by remember {
                mutableStateOf("")
            }
            TestProducesTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {

                        Text(text = "your text - $savedText")

                        Spacer(modifier = Modifier.height(16.dp))

                        TextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = editText,
                            onValueChange = {
                                editText = it
                            })

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Button(onClick = {
                                savedText = sp.getString("edit_text", "") ?: ""
                            }) {
                                Text(text = "show text")
                            }

                            Button(onClick = {
                                sp.edit(true) {
                                    putString("edit_text", editText)
                                }
                            }) {
                                Text(text = "save text")
                            }
                        }
                    }

                }
            }
        }
    }
}
