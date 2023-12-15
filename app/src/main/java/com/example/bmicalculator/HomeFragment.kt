package com.example.bmicalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.bmicalculator.databinding.FragmentHomeBinding
import com.example.bmicalculator.viewmodels.BmiViewModel


class HomeFragment : Fragment() {


//    private var _binding: FragmentHomeBinding? = null
//    private val binding get() = _binding!!

    private lateinit var binding: FragmentHomeBinding  //data binding
    private lateinit var viewModel: BmiViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProvider(requireActivity()).get(BmiViewModel :: class.java) //view_model_provider call for same data collect
                                                                                         //for different data use owner as ' this '

        binding = FragmentHomeBinding.inflate(inflater, container, false) //data binding

        binding.calculatebtnId.setOnClickListener {
            val weight = binding.editweightId1.text.toString().toDouble()
            val height = binding.editheightId2.text.toString().toDouble()

           // if (weight.isNotEmpty() && height.isNotEmpty()) {
             //   val weight = weightText.toDouble()
             //   val height = heightText.toDouble()

            viewModel.calculateBmi(weight, height)


//                val bmi = weight / (height * height)     //now no need

//                Toast.makeText(activity, "BMI: $bmi", Toast.LENGTH_SHORT).show()
          //  } else {
          //      Toast.makeText(activity, "Please enter valid weight and height", Toast.LENGTH_SHORT).show()
          //  }

                // bundle passing to result fragment
//            val bundle = bundleOf("score" to bmi )

            //here use safe args passing
            findNavController().navigate(R.id.result_actionId) //,bundle)  //,bundle use for Bundle  passing
        }

        return binding.root  //data binding
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        binding = null // Avoid memory leaks
//    }


}