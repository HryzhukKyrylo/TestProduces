package com.example.testproduces

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.testproduces.di.component.AppComponent
import com.example.testproduces.di.component.DaggerAppComponent
import com.example.testproduces.ui.theme.TestProducesTheme
import com.google.common.util.concurrent.FutureCallback
import com.google.common.util.concurrent.Futures
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.concurrent.Executors
import java.util.concurrent.Future

class MainActivity : ComponentActivity() {
    private lateinit var appComponent: AppComponent
    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent = DaggerAppComponent.create()
        super.onCreate(savedInstanceState)
        Futures.addCallback(appComponent.testStr,object : FutureCallback<String>{
            override fun onSuccess(result: String?) {
                Log.d("TESTTEST", "onSuccess: result - $result")
            }

            override fun onFailure(t: Throwable) {
                Log.d("TESTTEST", "onFailure: result error")
            }
        },
            Executors.newCachedThreadPool()
        )
        setContent {
            TestProducesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestProducesTheme {
        Greeting("Android")
    }
}