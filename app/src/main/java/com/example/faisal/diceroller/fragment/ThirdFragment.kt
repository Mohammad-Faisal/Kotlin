package com.example.faisal.diceroller.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

import com.example.faisal.diceroller.R
import kotlinx.android.synthetic.main.fragment_third.view.*

class ThirdFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view : View = inflater.inflate(R.layout.fragment_third, container, false)


        view.third_fragment_btn.setOnClickListener {
            view.findNavController().navigate(R.id.action_thirdFragment_to_firstFragment)
        }



        return view
    }


}
