package com.versilis.crashlyticsassignment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.crashlytics.android.Crashlytics
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import java.lang.ArithmeticException
import java.lang.Exception
import java.lang.NullPointerException

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val firebaseAnalyticsInstance = FirebaseAnalytics.getInstance(application)
    private fun logException(e: Throwable) {
        Crashlytics.logException(e)
    }

    fun getFirebaseAnalyticsInstance(): FirebaseAnalytics {
        return firebaseAnalyticsInstance
    }
    fun throwRuntimeException() {
        val runtimeException = RuntimeException("This is a forced crash!")
        logException(runtimeException)
    }
    fun arrayOutOfBoundsException(): Int {
        try {
            val list = listOf<Int>(
                1,2,3,4
            )
            return list[4]
        } catch (e: ArrayIndexOutOfBoundsException) {
            logException(e)
            return 0
        }
    }
    fun nullPointerException() : String {
        try {
            val nullValue: String? = null
            return nullValue!!
        } catch (e: NullPointerException) {
            logException(e)
            return "Didn't Work"
        }

    }
    fun arithmeticException(): Int {
        try {
            return 3/0
        } catch (e: ArithmeticException) {
            logException(e)
            return 0
        }
    }

}