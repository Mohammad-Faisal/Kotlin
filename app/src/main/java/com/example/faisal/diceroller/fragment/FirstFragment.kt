package com.example.faisal.diceroller.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

import com.example.faisal.diceroller.R
import kotlinx.android.synthetic.main.fragment_first.view.*


class FirstFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        val view : View = inflater.inflate(R.layout.fragment_first, container, false)

        view.first_fragment_btn.setOnClickListener {
            view.findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        return view
    }


}
