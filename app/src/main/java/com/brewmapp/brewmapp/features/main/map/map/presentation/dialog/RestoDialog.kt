package com.brewmapp.brewmapp.features.main.map.map.presentation.dialog

import android.app.Dialog
import android.app.DialogFragment
import android.os.Bundle
import android.view.View
import com.brewmapp.brewmapp.R

class RestoDialog: DialogFragment(), View.OnClickListener {
    override fun onClick(p0: View?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity.setContentView(R.layout.info_title)
    }
}