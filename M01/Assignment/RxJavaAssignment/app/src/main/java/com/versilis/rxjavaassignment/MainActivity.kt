package com.versilis.rxjavaassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.jakewharton.rxbinding3.widget.itemClicks
import com.jakewharton.rxbinding3.widget.itemSelections
import com.jakewharton.rxbinding3.widget.textChanges
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.Observables
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.roundToLong

class MainActivity : AppCompatActivity() {

    private lateinit var disposable: Disposable
    private val loanLengthNumList = mutableListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for(i in 1..70) {
            loanLengthNumList.add(i)
        }
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, loanLengthNumList)
        loan_length_spinner.adapter = arrayAdapter

        val obsPurchasePriceEditText = purchase_price_edit_text.textChanges().skipInitialValue()
        val obsDownPaymentEditText = down_payment_edit_text.textChanges().skipInitialValue()
        val obsInterestRateEditText = interest_rate_edit_text.textChanges().skipInitialValue()
        val obsLoanYearsSpinner = loan_length_spinner.itemSelections().skipInitialValue()

        val obsCombined = Observables.combineLatest(obsPurchasePriceEditText, obsDownPaymentEditText, obsInterestRateEditText, obsLoanYearsSpinner) {
            purchasePriceText, downPaymentText, interestRateText, numOfYearsText ->
            val purchasePrice = purchasePriceText.toString().toFloat()
            val downPayment = downPaymentText.toString().toFloat()
            val interestRate = interestRateText.toString().toFloat()/100
            val numOfYears = numOfYearsText.toFloat()
            tv_full_payment_amount.text = "${calculatePayment(purchasePrice-downPayment, interestRate, numOfYears).roundToInt()}"+" per year"
        }

        disposable = obsCombined.subscribe()

    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun calculatePayment(p: Float, r: Float, n: Float): Float {
        return p*r*(1+r).pow(n)/((1+r).pow(n) -1)
    }
}


