package com.example.dummyproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.commit
import com.example.dummyproject.ui.fragment.FirstFragment
import com.example.dummyproject.ui.theme.DummyProjectTheme
import com.example.dummyproject.viewmodel.ActivityViewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val activityViewModel by viewModels<ActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        if(savedInstanceState == null) {
//            supportFragmentManager.commit {
//                setReorderingAllowed(true)
//                add(R.id.fragmentContainerView, FirstFragment())
//            }
//        }
    }
}