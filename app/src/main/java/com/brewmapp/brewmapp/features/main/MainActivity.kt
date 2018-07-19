package com.brewmapp.brewmapp.features.main

import android.content.res.Configuration
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.ActionBarDrawerToggle
import android.text.Spannable
import android.text.SpannableString
import android.util.Log
import android.view.MenuItem
import com.bluelinelabs.conductor.Conductor
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.domain.CustomTypefaceSpan
import com.brewmapp.brewmapp.features.main.profile.SearchController


@Suppress("UNNECESSARY_NOT_NULL_ASSERTION")
class MainActivity : AppCompatActivity() {

    private lateinit var router: Router
    private lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        drawerToggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close)
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        router = Conductor.attachRouter(this, mainContainer, savedInstanceState)
        if (!router.hasRootController())
            router.setRoot(RouterTransaction.with(SearchController()))
        val menu = navView.menu
        for (i in 0 until menu.size()) {
            val mi = menu.getItem(i)
            val subMenu = mi.subMenu
            if (subMenu != null && subMenu!!.size() > 0) {
                for (j in 0 until subMenu!!.size()) {
                    val subMenuItem = subMenu!!.getItem(j)
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
            R.id.nav_feed -> router.replaceTopController(RouterTransaction.with(SearchController()))
            R.id.nav_message -> router.replaceTopController(RouterTransaction.with(SearchController()))
            else -> router.replaceTopController(RouterTransaction.with(SearchController()))
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
        val font = Typeface.createFromAsset(assets, "main.ttf")
        val title = SpannableString(mi.title)
        title.setSpan(CustomTypefaceSpan("", font), 0, title.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        mi.title = title
    }
}
