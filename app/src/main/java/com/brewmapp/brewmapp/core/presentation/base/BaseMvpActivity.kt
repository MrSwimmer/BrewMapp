package com.brewmapp.brewmapp.core.presentation.base

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.support.constraint.ConstraintLayout
import android.support.design.widget.Snackbar
import android.util.AttributeSet
import android.view.View
import android.widget.ProgressBar
import com.brewmapp.brewmapp.R
import com.hannesdorfmann.mosby3.mvp.MvpActivity

abstract class BaseMvpActivity<V : BaseContract.View, P : BaseContract.Presenter<V>> : MvpActivity<V, P>() {
    lateinit var progress: ProgressBar
    lateinit var parentLayout: ConstraintLayout

    fun showProgress() {
        if (progress != null)
            progress.visibility = View.VISIBLE
    }

    fun hideProgress() {
        if (progress != null)
            progress.visibility = View.INVISIBLE
    }

    fun showErrorMessage(message: String) {
        showSnack(message)
    }

    fun showSnack(message: String) {
        Snackbar.make(parentLayout, message, Snackbar.LENGTH_SHORT).show()
    }

    fun showDialog(title: String, message: String) {
        val builder = AlertDialog.Builder(applicationContext)
        builder.setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("ОК",
                        { dialog, _ -> dialog.cancel() })
        val alert = builder.create()
        alert.show()
    }
}