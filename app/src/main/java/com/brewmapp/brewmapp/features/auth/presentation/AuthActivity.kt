package com.brewmapp.brewmapp.features.auth.presentation

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ProgressBar
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.domain.interactor.SettingsService
import com.brewmapp.brewmapp.core.presentation.base.BaseActivity
import com.brewmapp.brewmapp.features.main.MainActivity
import com.brewmapp.brewmapp.features.main.profile.ChooseController
import com.brewmapp.brewmapp.features.main.profile.SettingsPresenter
import kotlinx.android.synthetic.main.activity_auth.*
import javax.inject.Inject

class AuthActivity : BaseActivity() {

    @Inject
    lateinit var settingsService: SettingsService

    private lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.component.inject(this)
        setContentView(R.layout.activity_auth)
        if(settingsService.getToken() != settingsService.ERROR) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        router = Conductor.attachRouter(this, authContainer, savedInstanceState)
        if (!router.hasRootController())
            router.setRoot(RouterTransaction.with(ChooseController()))
    }

    override fun onBackPressed() {
        if (!router.handleBack()) {
            super.onBackPressed()
        }
    }
}