package com.versilis.rxjavaassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.jakewharton.rxbinding3.widget.textChanges
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val loanLengthNumList = mutableListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val obsPurchasePriceEditText = purchase_price_edit_text.textChanges()
        val obsDownPaymentEditText = down_payment_edit_text.textChanges()
        val obsInterestRateEditText = interest_rate_edit_text.textChanges()
        //val obsLoanYearsSpinner =
        for(i in 1..70) {
            loanLengthNumList.add(i)
        }
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, loanLengthNumList)
        loan_length_spinner.adapter = arrayAdapter
       /* loan_length_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }*/

    }
}
