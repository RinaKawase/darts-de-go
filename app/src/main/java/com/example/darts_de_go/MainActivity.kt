package com.example.darts_de_go

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.darts_de_go.nav.Navigation
import com.example.darts_de_go.ui.theme.DartsdegoTheme

/**
 * MainActivity
 * Do not include any processing other than
 * calling the Navigation function.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DartsdegoTheme {
                Navigation()
            }
        }
    }
}