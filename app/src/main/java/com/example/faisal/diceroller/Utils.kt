@file:JvmName("Utils")

import android.content.Context
import android.graphics.Bitmap
import android.media.MediaScannerConnection
import android.os.Environment

import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.faisal.diceroller.*

import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.*
import android.content.Context.CONNECTIVITY_SERVICE
import com.google.android.material.snackbar.Snackbar


fun createToast(context : Context ,msg : String ){
    Toast.makeText(context , msg, Toast.LENGTH_SHORT).show();
}

fun createLog( msg: String){
    Log.d( APP_NAME, msg)
}

fun createSnackBar(root : View , msg : String){
    Snackbar.make(
            root,
            msg,
            Snackbar.LENGTH_SHORT
    ).show()
}

fun hideKeyboard(context: Context , view : View) {
    val inn = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inn.hideSoftInputFromWindow(view.windowToken , 0)
}

fun createSnackBarWithAction(root : View , msg: String , actionText : String){
    Snackbar.make(
            root, // Parent view
            msg, // Message to show
            Snackbar.LENGTH_LONG //
    ).setAction( // Set an action for snack bar
            actionText, // Action button text
            {
                // Action button click listener
            })
            .show() // Finally show the snack bar
}

fun isDataAvailable(context: Context): Boolean {
    val connectivityManager = context.getSystemService(CONNECTIVITY_SERVICE) as android.net.ConnectivityManager
    val networkInfo = connectivityManager.activeNetworkInfo
    return networkInfo != null && networkInfo.isConnected
}

fun saveImage(context : Context ,myBitmap: Bitmap):String {
    val IMAGE_DIRECTORY = "/$APP_NAME"
    val bytes = ByteArrayOutputStream()
    myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes)
    val wallpaperDirectory = File(
            (Environment.getExternalStorageDirectory()).toString() + IMAGE_DIRECTORY)
    // have the object build the directory structure, if needed.
    if (!wallpaperDirectory.exists())
    {
        wallpaperDirectory.mkdirs()
    }
    try
    {
        val f = File(wallpaperDirectory, ((Calendar.getInstance()
                .getTimeInMillis()).toString() + ".jpg"))
        f.createNewFile()
        val fo = FileOutputStream(f)
        fo.write(bytes.toByteArray())
        MediaScannerConnection.scanFile(context,
                arrayOf(f.getPath()),
                arrayOf("image/jpeg"), null)
        fo.close()
        return f.getAbsolutePath()
    }
    catch (e1: IOException) {
        e1.printStackTrace()
    }

    return ""
}



