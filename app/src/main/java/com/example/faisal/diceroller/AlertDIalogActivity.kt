package com.example.faisal.diceroller

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import createToast
import kotlinx.android.synthetic.main.activity_dialog.*
import kotlinx.android.synthetic.main.dialog_camera.view.*

class AlertDIalogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        btn_dialog.setOnClickListener { showDialog() }
    }

    @SuppressLint("InflateParams")
    private fun showDialog() {
        val dialogBuilder = AlertDialog.Builder(this, R.style.Base_ThemeOverlay_AppCompat_Dialog_Alert)
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_camera, null)

        dialogBuilder.setView(dialogView)
        val firstBtn = dialogView.btn_dialog_camera
        val secondBtn = dialogView.btn_dialog_gallery
        val alertDialog = dialogBuilder.create()

        firstBtn.setOnClickListener {
            createToast(this , "first button clicked")
        }

        secondBtn.setOnClickListener {
            createToast(this , "second button clicked")
        }
        alertDialog.show()
    }
}
