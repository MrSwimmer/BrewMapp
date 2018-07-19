package com.brewmapp.brewmapp.features.main.profile

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.RouterTransaction
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.features.main.MainActivity
import kotlinx.android.synthetic.main.controller_choose.view.*
import android.text.Spanned



class ChooseController : Controller() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_choose, container, false)
        view.chooseEnter.setOnClickListener({router.pushController(RouterTransaction.with(SignInController()))})
        view.chooseRegistration.setOnClickListener({router.pushController(RouterTransaction.with(SignUpController()))})
        val htmlTaggedString = "<u>Пропустить</u>"
        val textSpan = android.text.Html.fromHtml(htmlTaggedString)
        view.chooseSkip.text = textSpan
        view.chooseSkip.setOnClickListener({
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
            activity!!.finish()
        })
        return view
    }

}