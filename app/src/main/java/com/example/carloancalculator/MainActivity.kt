package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(){

            //   val inputValue = editTextLoanPeriod.text.toString()
            //   val amount:Double = inputValue.toDouble() * 0.123456
            //   textViewLoan.text = "%.2f".format(amount)

            val carPrice = editTextCarPrice.text.toString().toDouble()
            val downPayment = editTextDownPayment.text.toString().toDouble()
            val loanPeriod = editTextLoanPeriod.text.toString().toDouble()
            val interestRate = editTextInterestRate.text.toString().toDouble()

            val carLoan:Double = carPrice - downPayment
            val interest = carLoan * (interestRate / 100 ) * loanPeriod
            val monthlyRepayment = (carLoan + interest) / loanPeriod /12


            textViewLoan.text = "Loan : " + "%.2f".format(carLoan)
            textViewInterest.text = "Interest : " + "%.2f".format(interest) + "%"
            textViewMonthlyRepayment.text = "MonthlyRepayment :" + "%.2f".format(monthlyRepayment)
        }

        buttonReset.setOnClickListener(){

            editTextCarPrice.text.clear()
            editTextDownPayment.text.clear()
            editTextLoanPeriod.text.clear()
            editTextInterestRate.text.clear()
            textViewLoan.text = ""
            textViewInterest.text = ""
            textViewMonthlyRepayment.text = ""
        }


    }

}
