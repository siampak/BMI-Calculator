package com.example.bmicalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bmicalculator.databinding.FragmentResultBinding
import com.example.bmicalculator.viewmodels.BmiViewModel


class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding //data binding
    private lateinit var viewModel: BmiViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {



        // Inflate the layout for this fragment
        binding = FragmentResultBinding.inflate(inflater, container, false) //data binding

        viewModel = ViewModelProvider(requireActivity()).get(BmiViewModel ::class.java) //view_model_provider call for same data collect
                                                                                         //for different data use owner as ' this '

        //For live data & observer function use
        viewModel.bmi.observe(viewLifecycleOwner) { score ->

            binding.txtScoreId2.text = String.format("%.1f", score)
        }

        //For Live data

        viewModel.category.observe(viewLifecycleOwner) { category ->
            binding.txtTypeId4.text = category
        }


//        val score = arguments?.getDouble("score")  //for bundle passing
//        binding.txtScoreId2.text = String.format("%.1f", viewModel.bmi) //,score) //just use MVVM


         // Ignore part b-coz use MVVM
//        val category = when (String.format("%.1f", score).toDouble()) {
//
//            in 0.0 .. 18.4 -> underweight
//            in 18.5 ..24.9 -> normal
//            in 25.0 .. 29.9 -> overweight
//            in 30.0 .. 34.9 -> obesity1
//            in 35.0 .. 39.9 -> obesity2
//
//            else -> obesity3
//        }




//        binding.txtTypeId4.text = viewModel.category   //just use MVVM type

        return binding.root  //data binding

    }

    // Ignore part foe use MVVM
//    companion object {
//
//        val underweight ="Under weight"
//        val normal ="normal"
//        val overweight ="over weight"
//        val obesity1 ="obsity class 1"
//        val obesity2 ="obsity class 2"
//        val obesity3 ="obsity class 3"
//
//    }


}