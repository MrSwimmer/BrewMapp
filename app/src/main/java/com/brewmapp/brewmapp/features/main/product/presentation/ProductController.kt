package com.brewmapp.brewmapp.features.main.profile

import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BaseController
import com.brewmapp.brewmapp.features.main.product.data.model.Model
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.controller_product.view.*

class ProductController() : BaseController<ProductContract.View, ProductContract.Presenter>(), ProductContract.View {

    lateinit var id: String

    constructor(id: String) : this() {
        this.id = id
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.controller_product, container, false)
    }

    override fun createPresenter(): ProductContract.Presenter {
        return ProductPresenter()
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        showProgress()
        presenter.getProduct(id)
    }

    override fun setProduct(model: Model) {
        Glide.with(view!!)
                .load("https://developer.brewmapp.com/${model.getThumb}")
                .into(view!!.image)
    }
}