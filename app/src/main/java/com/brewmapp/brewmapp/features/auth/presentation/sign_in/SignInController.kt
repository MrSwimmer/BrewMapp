package com.brewmapp.brewmapp.features.main.profile

import android.content.Intent
import com.google.android.material.snackbar.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BaseController
import com.brewmapp.brewmapp.features.main.MainActivity
import com.hannesdorfmann.mosby3.mvp.conductor.MvpController
import kotlinx.android.synthetic.main.controller_sign_in.view.*

class SignInController : BaseController<SignInContract.View, SignInContract.Presenter>(), SignInContract.View {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_sign_in, container, false)
        view.enter.setOnClickListener { onEnterClick() }
        return view
    }

    override fun createPresenter(): SignInContract.Presenter {
        return SignInPresenter()
    }

    fun onEnterClick() {
        if (isFeelingFields()) {
            showProgress()
            presenter.signIn(view!!.email.text.toString(), view!!.password.text.toString())
        } else {
            showSnack("Заполните все поля")
        }

    }

    fun isFeelingFields(): Boolean {
        return view!!.email.text.toString() != "" && view!!.password.text.toString() != ""
    }

    override fun gotoMain() {
        val intent = Intent(activity, MainActivity::class.java)
        startActivity(intent)
        activity!!.finish()
    }
}