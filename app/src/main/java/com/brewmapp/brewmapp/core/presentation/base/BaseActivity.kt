package com.brewmapp.brewmapp.core.presentation.base

import android.content.Context
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import com.brewmapp.brewmapp.R
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.ThreadMode
import org.greenrobot.eventbus.Subscribe


abstract class BaseActivity : AppCompatActivity() {
    lateinit var progress: ProgressBar

    override fun onResume() {
        super.onResume()
        progress = findViewById(R.id.progressBar)
        hideProgress()
    }

    fun showProgress() {
        Log.i("code", "show base activity")
        progress.visibility = View.VISIBLE
    }

    fun hideProgress() {
        Log.i("code", "hide base activity")
        progress.visibility = View.INVISIBLE
    }

    public override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    public override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    abstract fun getParentView(): View

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(message: String) {
        Log.i("code", "eventbus message $message")
        hideProgress()
    }


}