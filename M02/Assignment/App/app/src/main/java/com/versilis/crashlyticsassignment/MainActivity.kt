package com.versilis.crashlyticsassignment

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.crashlytics.android.Crashlytics
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider
            .AndroidViewModelFactory(application)
            .create(MainViewModel::class.java)

        bttn_runtimeException.setOnClickListener {
            viewModel.throwRuntimeException()
        }

        bttn_arrayOutOfBoundsException.setOnClickListener {
            viewModel.arrayOutOfBoundsException()
        }

        bttn_arithmeticException.setOnClickListener {
            viewModel.arithmeticException()
        }

        bttn_nullPointerException.setOnClickListener {
            viewModel.nullPointerException()
        }
    }
}
