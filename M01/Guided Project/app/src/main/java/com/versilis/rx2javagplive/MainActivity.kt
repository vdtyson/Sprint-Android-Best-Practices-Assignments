package com.versilis.rx2javagplive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jakewharton.rxbinding3.widget.textChanges
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.Observables
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    lateinit var disposable: Disposable
    /*private val obsJust: Observable<Int> = Observable.just(
        1,
        2,
        3,
        4,
        5,
        6,
        7,
        8,
        9,
        10
    )*/
    val obsCreate: Observable<Int> = Observable.create { emitter ->
        for (i in 1..10) {
            Thread.sleep(1000)
            emitter.onNext(i)
        }
        emitter.onComplete()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val obsFirstNameEditText = first_name.textChanges().debounce(500, TimeUnit.MILLISECONDS)
        val obsLastNameEditText = last_name.textChanges()

        val obsCombined = Observables.combineLatest(obsFirstNameEditText, obsLastNameEditText) {first, last ->
            "$first $last"
        }

        disposable = obsCombined.observeOn(AndroidSchedulers.mainThread()).subscribe { name ->
            text_view.text = nam
      /* disposable = obsCreate.subscribe(
           { num -> text_view.text = "$num" },
           {},
           {text_view.text = "Completed!"}
       )*/



    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
}
