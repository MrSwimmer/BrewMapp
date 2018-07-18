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

class ChooseController : Controller() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_choose, container, false)
        view.chooseEnter.setOnClickListener({router.replaceTopController(RouterTransaction.with(SignInController()))})
        view.chooseRegistration.setOnClickListener({router.replaceTopController(RouterTransaction.with(SignUpController()))})
        view.chooseSkip.setOnClickListener({
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
            activity!!.finish()
        })
        return view
    }

}