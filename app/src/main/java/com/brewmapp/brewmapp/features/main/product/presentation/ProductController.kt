package com.brewmapp.brewmapp.features.main.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BaseController

class ProductController : BaseController<ProductContract.View, ProductContract.Presenter>(), ProductContract.View {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.controller_product, container, false)
    }

    override fun createPresenter(): ProductContract.Presenter {
        return ProductPresenter()
    }
}