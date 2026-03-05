package ru.store.testapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.store.testapp.ui.theme.TestAppTheme

class SecondaryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val receivedText = intent.getStringExtra(SettingsKey.EXTRA_TEXT) ?: "Text was not received"
        enableEdgeToEdge()
        setContent {
            TestAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SecondaryScreen(
                        modifier = Modifier.padding(innerPadding),
                        text = receivedText)
                }
            }
        }
    }
}

@Composable
fun SecondaryScreen(modifier: Modifier = Modifier, text: String) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text)
    }

}
