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

    /*override fun onResume() {
        super.onResume()
        //progress = findViewById(R.id.progressBar)
        //hideProgress()
    }*/

    //lateinit var progress: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //progress = progressBar
    }

    fun showProgress() {
        Log.i("code", "show base activity")
        progressBar.visibility = View.VISIBLE
    }

    fun hideProgress() {
        Log.i("code", "hide base activity")
        progressBar.visibility = View.INVISIBLE
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }


    public override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    public override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    fun showErrorMessage(message: String) {
        showSnack(message)
    }

    fun showSnack(message: String) {
        Snackbar.make(getView(), message, Snackbar.LENGTH_SHORT).show()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(message: String) {
        Log.i("code", "eventbus message")
        hideProgress()
        when (message) {
            "error" -> showSnack("Ошибка")
        }
    }

    abstract fun getView(): View
}