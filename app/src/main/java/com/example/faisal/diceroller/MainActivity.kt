package com.example.faisal.diceroller
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.faisal.diceroller.fragment.FragmentHolderActiviy
import com.example.faisal.diceroller.mvvm.QuotesActivity
import createLog
import createSnackBar
import createToast
import isDataAvailable
import kotlinx.android.synthetic.main.activity_main.*
import com.example.faisal.diceroller.recycler.RecyclerActivity
import com.example.faisal.diceroller.roomviewmodel.WordActivity


class MainActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_log.setOnClickListener{createLog("Main faisal") }

        btn_toast.setOnClickListener{ createToast(this , "button clicked") }

        btn_chk_internet.setOnClickListener{
            when(isDataAvailable(this)){
                true  -> createToast(this ,"enabled")
                false -> createToast(this , "not enabled")
            }
        }

        btn_spinner_activity.setOnClickListener { activityTransition() }

        btn_snackbar.setOnClickListener { createSnackBar(root , "this is a snackbar") }

        btn_image_activity.setOnClickListener {
            val intent  = Intent(this , ImageActivity::class.java)
            startActivity(intent)
        }

        btn_dialog_activity.setOnClickListener {
            val intent  = Intent(this , AlertDIalogActivity::class.java)
            startActivity(intent)
        }

        btn_recycler_activity.setOnClickListener {
            val intent  = Intent(this , RecyclerActivity::class.java)
            startActivity(intent)
        }

        btn_fragment_activity.setOnClickListener {
            val intent  = Intent(this , FragmentHolderActiviy::class.java)
            startActivity(intent)
        }

        btn_menu_activity.setOnClickListener {
            val intent  = Intent(this , MenuActivity::class.java)
            startActivity(intent)
        }

        btn_mvvm_activity.setOnClickListener {
            val intent  = Intent(this , QuotesActivity::class.java)
            startActivity(intent)
        }

        btn_room_activity.setOnClickListener {
            val intent  = Intent(this , WordActivity::class.java)
            startActivity(intent)
        }


    }


    private fun activityTransition(){
        val intent  = Intent(this , SpinnerActivity::class.java).apply {
            putExtra("message" , "payload")
        }
        startActivity(intent)
    }

}
