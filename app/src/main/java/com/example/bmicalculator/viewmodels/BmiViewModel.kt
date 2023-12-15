package com.example.bmicalculator.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bmicalculator.ResultFragment

class BmiViewModel : ViewModel() {


    //use live data
    var bmi : MutableLiveData<Double>  = MutableLiveData()
    var category : MutableLiveData<String> = MutableLiveData()
//    var bmi  =0.0
//    var category = ""

     fun calculateBmi(weight: Double, height: Double){



          bmi.value = weight / (height * height) //.value add for use live data


          category.value = when (String.format("%.1f", bmi.value).toDouble()) {     //.value add for use live data

             in 0.0 .. 18.4 -> underweight
             in 18.5 ..24.9 -> normal
             in 25.0 .. 29.9 -> overweight
             in 30.0 .. 34.9 -> obesity1
             in 35.0 .. 39.9 -> obesity2

             else -> obesity3

         }

//         Log.e("BMIViewModel", "${String.format("%.1f",bmi)}, $category",)


    }

    companion object {

        val underweight ="Under weight"
        val normal ="normal"
        val overweight ="over weight"
        val obesity1 ="obsity class 1"
        val obesity2 ="obsity class 2"
        val obesity3 ="obsity class 3"

    }

}