package com.example.faisal.diceroller

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import createLog
import kotlinx.android.synthetic.main.activity_spinner.*


class SpinnerActivity : AppCompatActivity()  , AdapterView.OnItemSelectedListener{


    //needed resources

    //spinner_background.xml
    //spinner_layout.xml
    //colors.xml
    //strings.xml



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)


        spinner_sample.setOnItemSelectedListener(this)
        val spnr = ArrayAdapter(this, R.layout.spinner_layout , resources.getStringArray(R.array.spinner_items) )
        spnr.setDropDownViewResource(R.layout.spinner_layout)
        spinner_sample.setAdapter(spnr)

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        createLog("item selected "+ resources.getStringArray(R.array.spinner_items)[position] )

    }
}
