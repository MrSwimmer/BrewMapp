package com.brewmapp.brewmapp.core.presentation.base

import android.app.AlertDialog
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.View
import com.hannesdorfmann.mosby3.conductor.viewstate.MvpViewStateController
import com.hannesdorfmann.mosby3.mvp.conductor.MvpController
import com.hannesdorfmann.mosby3.mvp.viewstate.ViewState

abstract class BaseVSController<V : BaseContract.View, P : BaseContract.Presenter<V>, VS : ViewState<V>> : MvpViewStateController<V, P, VS>() {

    fun showSnack(message: String) {
        Snackbar.make(view!!, message, Snackbar.LENGTH_SHORT).show()
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

    fun showProgress() {
        val activity: BaseActivity = activity as BaseActivity
        activity.showProgress()
    }

    fun hideProgress() {
        Log.i("code", "hide base controller")
        val activity: BaseActivity = activity as BaseActivity
        activity.hideProgress()
    }

    fun showErrorMessage(message: String) {
        showSnack(message)
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        hideProgress()
    }


}