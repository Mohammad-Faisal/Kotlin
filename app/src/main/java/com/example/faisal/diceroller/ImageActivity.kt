package com.example.faisal.diceroller

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_image.*
import kotlinx.android.synthetic.main.dialog_camera.view.*
import saveImage

class ImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
    }


    fun changeImage(view : View){
        showDialog()
    }


    //have to create a layout file named dialog camera
    @SuppressLint("InflateParams")
    private fun showDialog() {
        val dialogBuilder = AlertDialog.Builder(this, R.style.Base_ThemeOverlay_AppCompat_Dialog_Alert)
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_camera, null)

        dialogBuilder.setView(dialogView)
        val cameraBtn = dialogView.btn_dialog_camera
        val galleryBtn = dialogView.btn_dialog_gallery
        val alertDialog = dialogBuilder.create()

        cameraBtn.setOnClickListener {
            alertDialog.dismiss()
            val takePicture = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePicture, CAMERA)
        }

        galleryBtn.setOnClickListener {
            alertDialog.dismiss()
            val pickPhoto = Intent(Intent.ACTION_PICK,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(pickPhoto, GALLERY)
        }
        alertDialog.show()
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            CAMERA -> if (resultCode == Activity.RESULT_OK) {
                val thumbnail = data!!.extras!!.get("data") as Bitmap
                img!!.setImageBitmap(thumbnail)
                saveImage(this , thumbnail)
            }
            GALLERY -> if (resultCode == Activity.RESULT_OK) {
                val selectedImage = data!!.data
                img.setImageURI(selectedImage)
            }
        }
    }

}
