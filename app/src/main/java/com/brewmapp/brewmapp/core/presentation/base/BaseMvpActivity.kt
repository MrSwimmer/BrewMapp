package com.brewmapp.brewmapp.core.presentation.base

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import com.brewmapp.brewmapp.R
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import kotlinx.android.synthetic.main.activity_param.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.ThreadMode
import org.greenrobot.eventbus.Subscribe


abstract class BaseMvpActivity<V : BaseActivityContract.View, P : BaseActivityContract.Presenter<V>> : MvpActivity<V, P>() {

    fun showProgress() {
        Log.i("code", "show base activity")
        progressBar.visibility = View.VISIBLE
    }

    fun hideProgress() {
        Log.i("code", "hide base activity")
        progressBar.visibility = View.INVISIBLE
    }

    fun showErrorMessage(message: String) {
        showSnack(message)
    }

    fun showSnack(message: String) {
        Snackbar.make(getView(), message, Snackbar.LENGTH_SHORT).show()
    }

    abstract fun getView(): View
}