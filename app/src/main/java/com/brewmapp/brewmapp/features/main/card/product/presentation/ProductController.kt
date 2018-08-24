package com.brewmapp.brewmapp.features.main.profile

import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BaseController
import com.brewmapp.brewmapp.features.main.card.product.data.model.product.Model
import com.brewmapp.brewmapp.features.main.card.product.presentation.param_recycler.Param
import com.brewmapp.brewmapp.features.main.card.product.presentation.param_recycler.ParamAdapter
import com.brewmapp.brewmapp.features.main.card.product.presentation.param_recycler.RestoAdapter
import com.brewmapp.brewmapp.features.main.card.product.presentation.param_recycler.ReviewAdapter
import com.brewmapp.brewmapp.features.main.card.product.presentation.resto_recycler.Resto
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.controller_product.view.*
import org.jsoup.Jsoup

class ProductController() : BaseController<ProductContract.View, ProductContract.Presenter>(), ProductContract.View {

    lateinit var id: String

    constructor(id: String) : this() {
        this.id = id
    }

    var isAllReviewShowed = false
    var isAllRestoShowed = false

    var restoList = mutableListOf<Resto>()
    var reviewList = mutableListOf<com.brewmapp.brewmapp.features.main.card.product.data.model.review.Model>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_product, container, false)
        view.paramRecycler.layoutManager = LinearLayoutManager(activity!!)
        view.recyclerResto.layoutManager = LinearLayoutManager(activity!!)
        view.recyclerReview.layoutManager = LinearLayoutManager(activity!!)
        view.showAllResto.setOnClickListener({
            if (isAllRestoShowed)
                hideAllResto()
            else
                showAllResto()
            isAllRestoShowed = !isAllRestoShowed
        })
        view.showAllReview.setOnClickListener({
            if (isAllReviewShowed)
                hideAllReview()
            else
                showAllReview()
            isAllReviewShowed = !isAllReviewShowed
        })
        return view
    }

    override fun createPresenter(): ProductContract.Presenter {
        return ProductPresenter()
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        presenter.getProduct(id)
    }

    override fun setParams(paramsList: MutableList<Param>) {
        view!!.paramRecycler.adapter = ParamAdapter(paramsList)
    }

    override fun setProduct(model: Model) {
        view!!.text.text = Jsoup.parse(model.text.get1()).text()
        view!!.likes.text = model.like
        view!!.dislikes.text = model.disLike
        view!!.strength.text = "${model.relations.beerStrength.name}%"
        Glide.with(activity!!)
                .load(model.getThumb)
                .into(view!!.image)
    }

    override fun setResto(restoList: MutableList<Resto>) {
        this.restoList = restoList
        if (restoList.size > 0)
            view!!.noinresto.visibility = View.GONE
        if (restoList.size > 3) {
            view!!.showAllResto.visibility = View.VISIBLE
        }
        view!!.recyclerResto.adapter = RestoAdapter(restoList.subList(0, 2))
    }

    override fun setReview(models: MutableList<com.brewmapp.brewmapp.features.main.card.product.data.model.review.Model>) {
        reviewList = models
        if (models.size > 0)
            view!!.noreviews.visibility = View.GONE
        if (models.size > 1) {
            view!!.showAllReview.visibility = View.VISIBLE
        }
        view!!.recyclerReview.adapter = ReviewAdapter(models.subList(0, 1))
    }

    fun showAllReview() {
        view!!.showAllReviewText.text = "Скрыть все отзывы"
        view!!.recyclerReview.adapter = ReviewAdapter(reviewList)
    }

    fun hideAllReview() {
        view!!.showAllReviewText.text = "Все отзывы"
        view!!.recyclerReview.adapter = ReviewAdapter(reviewList.subList(0, 1))
    }

    fun showAllResto() {
        view!!.showAllRestoText.text = "Скрыть все заведения"
        view!!.recyclerResto.adapter = RestoAdapter(restoList)
    }

    fun hideAllResto() {
        view!!.showAllRestoText.text = "Все заведения"
        view!!.recyclerResto.adapter = RestoAdapter(restoList.subList(0, 2))
    }
}