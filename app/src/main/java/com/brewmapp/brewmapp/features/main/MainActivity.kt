package com.brewmapp.brewmapp.features.main

import android.content.Intent
import android.content.res.Configuration
import android.graphics.Typeface
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.FragmentManager
import android.support.v7.app.ActionBarDrawerToggle
import android.text.Spannable
import android.text.SpannableString
import android.util.Log
import android.view.MenuItem
import android.view.View
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.domain.CustomTypefaceSpan
import com.brewmapp.brewmapp.core.presentation.base.BaseActivity
import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.core.domain.interactor.SettingsService
import com.brewmapp.brewmapp.features.main.map.map.presentation.MapController
import com.brewmapp.brewmapp.features.main.profile.*
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.request.RequestOptions
import javax.inject.Inject
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.nav_header.view.*
import kotlinx.android.synthetic.main.toolbar.*

@Suppress("UNNECESSARY_NOT_NULL_ASSERTION")
class MainActivity : BaseActivity() {

    private lateinit var router: Router
    private lateinit var drawerToggle: ActionBarDrawerToggle

    @Inject
    lateinit var settingsService: SettingsService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.component.inject(this)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        navView.setCheckedItem(0)
        navView.setNavigationItemSelectedListener {
            selectDrawerItem(it.itemId)
            it.isChecked = true
            title = it.title
            drawerLayout.closeDrawers()
            true
        }
        Log.i("code", (supportActionBar == null).toString())
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val header = navView.getHeaderView(0)
        if (settingsService.getToken() != settingsService.ERROR) {
            header.username.text = settingsService.getUsername()
            val options = RequestOptions()
                    .centerCrop()
                    .placeholder(R.drawable.ic_person)
                    .error(R.drawable.ic_person)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH)
                    .circleCrop()
            Glide.with(this)
                    .load(settingsService.getUrl())
                    .apply(options)
                    .into(header.image)
        }

        drawerToggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close)
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        router = Conductor.attachRouter(this, mainContainer, savedInstanceState)
        if (!router.hasRootController())
            router.setRoot(RouterTransaction.with(NewsController()))
        val menu = navView.menu
        for (i in 0 until menu.size()) {
            val mi = menu.getItem(i)
            val subMenu = mi.subMenu
            if (subMenu != null && subMenu!!.size() > 0) {
                for (j in 0 until subMenu!!.size()) {
                    val subMenuItem = subMenu!!.getItem(j)
                    if (j == 1 || j == 2 || j == 4) {
                        subMenuItem.isCheckable = false
                        subMenuItem.isEnabled = false
                    }
                    applyFontToMenuItem(subMenuItem)
                }
            }
            applyFontToMenuItem(mi)
        }
        //first screen
        menu.getItem(0).isChecked = true
        title = menu.getItem(0).title
    }

    private fun selectDrawerItem(itemId: Int) {
        when (itemId) {
            R.id.nav_news -> router.setRoot(RouterTransaction.with(NewsController()))
        //R.id.nav_friends -> router.setRoot(RouterTransaction.with(FriendsController()))
        //R.id.nav_message -> router.setRoot(RouterTransaction.with(MessagesController()))
            R.id.nav_search -> router.setRoot(RouterTransaction.with(SearchController()))
            R.id.nav_map -> router.setRoot(RouterTransaction.with(MapController()))
            R.id.nav_settings -> router.setRoot(RouterTransaction.with(SettingsController()))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (drawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }

    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)
        drawerToggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        drawerToggle.onConfigurationChanged(newConfig)
    }

    private fun applyFontToMenuItem(mi: MenuItem) {
        val font = Typeface.createFromAsset(assets, "main.otf")
        val title = SpannableString(mi.title)
        title.setSpan(CustomTypefaceSpan("", font), 0, title.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        mi.title = title
    }

    override fun onBackPressed() {
        if (!router.handleBack()) {
            super.onBackPressed()
        }
    }

    override fun getParentView(): View {
        return parentLayout
    }

    fun supportFragmentManager(): FragmentManager? {
        return supportFragmentManager
    }
}