package com.brewmapp.brewmapp.core.presentation.base

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.util.AttributeSet
import android.view.View
import android.widget.ProgressBar
import com.brewmapp.brewmapp.R

abstract class BaseActivity : AppCompatActivity() {
    lateinit var progress: ProgressBar

    override fun onResume() {
        super.onResume()
        progress = findViewById(R.id.progressBar)
    }

    fun showProgress() {
        progress.visibility = View.VISIBLE
    }

    fun hideProgress() {
        progress.visibility = View.INVISIBLE
    }
}