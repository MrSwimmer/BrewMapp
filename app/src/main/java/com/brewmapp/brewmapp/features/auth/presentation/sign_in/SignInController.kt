package com.brewmapp.brewmapp.features.main.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.hannesdorfmann.mosby3.mvp.conductor.MvpController
import kotlinx.android.synthetic.main.controller_sign_in.view.*

class SignInController : MvpController<SignInContract.View, SignInContract.Presenter>(), SignInContract.View {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_sign_in, container, false)
        view.enter.setOnClickListener { onEnterClick() }
        return view
    }

    override fun createPresenter(): SignInContract.Presenter {
        return SignInPresenter()
    }

    fun onEnterClick() {
        if (isFeelingFields())
            presenter.signIn(view!!.email.text.toString(), view!!.password.text.toString())
    }

    fun isFeelingFields() : Boolean {
        return view!!.email.text.toString() != "" && view!!.password.text.toString() != ""
    }
}