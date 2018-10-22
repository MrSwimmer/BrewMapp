package com.brewmapp.brewmapp.features.main.profile

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.domain.interactor.SettingsService
import com.brewmapp.brewmapp.core.presentation.base.BaseController
import com.brewmapp.brewmapp.features.auth.presentation.AuthActivity
import kotlinx.android.synthetic.main.controller_settings.view.*
import javax.inject.Inject

class SettingsController : BaseController<SettingsContract.View, SettingsContract.Presenter>(), SettingsContract.View {
    init {
        App.component.inject(this)
    }

    @Inject
    lateinit var settingsService: SettingsService

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_settings, container, false)
        view.signOut.setOnClickListener {
            settingsService.setToken(settingsService.ERROR)
            startActivity(Intent(activity, AuthActivity::class.java))
            activity!!.finish()
        }
        view.share.setOnClickListener {
            var intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "Присоединяйтесь к BrewMapp https://www.brewmapp.com/")
            intent.putExtra(Intent.EXTRA_SUBJECT, "Поделиться")
            intent = Intent.createChooser(intent, "С помощью")
            activity!!.startActivity(intent)
        }
        return view
    }

    override fun createPresenter(): SettingsContract.Presenter {
        return SettingsPresenter()
    }
}