package com.learn.githubvisitor.activity

import android.app.AlertDialog
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.learn.githubvisitor.R


open class BaseActivity : AppCompatActivity() {
    private lateinit var dialog: AlertDialog

    companion object {
        lateinit var downloadCompleteDialog: androidx.appcompat.app.AlertDialog.Builder
    }

    fun initAlertDialog() {
        val dialogView = layoutInflater.inflate(R.layout.loading_dialog, null)
        dialog = AlertDialog.Builder(this, R.style.CustomDialog)
            .setView(dialogView).setCancelable(false)
            .create()
    }

    fun showDialog() {
        dialog.show()
    }

    fun dismissDialog() {
        dialog.dismiss()
    }

    fun isDialogShowing(): Boolean {
        return dialog.isShowing
    }

    fun setDownloadCompleteDialog() {
        downloadCompleteDialog = androidx.appcompat.app.AlertDialog.Builder(this, R.style.CustomDownloadDialog).apply {
            setTitle("download complete")
            setPositiveButton("OK") { dialogInterface, _ ->
                dialogInterface.dismiss()
            }
        }
    }


}