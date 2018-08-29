package com.brewmapp.brewmapp.features.main.profile

import android.support.v7.widget.LinearLayoutManager
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BaseController
import com.brewmapp.brewmapp.features.main.card.product.data.model.resto.Model
import com.brewmapp.brewmapp.features.main.card.product.presentation.recycler.param.Param
import com.brewmapp.brewmapp.features.main.card.product.presentation.recycler.param.ParamAdapter
import com.brewmapp.brewmapp.features.main.card.product.presentation.recycler.param.ReviewAdapter
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.controller_resto.view.*
import org.jsoup.Jsoup

class RestoController() : BaseController<RestoContract.View, RestoContract.Presenter>(), RestoContract.View {
    lateinit var id: String
    var isAllReviewShowed = false
    var reviewList = mutableListOf<com.brewmapp.brewmapp.features.main.card.product.data.model.review.Model>()

    constructor(id: String) : this() {
        this.id = id
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_resto, container, false)
        view.paramRecycler.layoutManager = LinearLayoutManager(activity!!)
        view.recyclerReview.layoutManager = LinearLayoutManager(activity!!)
        view.showAllReview.setOnClickListener({
            if (isAllReviewShowed)
                hideAllReview()
            else
                showAllReview()
            isAllReviewShowed = !isAllReviewShowed
        })
        return view
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        presenter.getResto(id)
    }

    override fun createPresenter(): RestoContract.Presenter {
        return RestoPresenter()
    }

    override fun setResto(model: Model) {
        val resto = model.resto[0]
        Glide.with(activity!!)
                .load(resto.getThumb)
                .into(view!!.image)
        view!!.likes.text = resto.like
        view!!.dislikes.text = resto.disLike
        view!!.text.text = Jsoup.parse(resto.text.get1()).text()
        val metro = if(resto.location.metro == null)
            resto.location.metro.name.get1()
        else
            ""
        val location = "г.${resto.location.cityId.get1()} $metro ${resto.location.location.street.get1()} ${resto.location.location.house.get1()}"
        view!!.location.text = location
        if(resto.site != "") {
            view!!.site.movementMethod = LinkMovementMethod.getInstance()
            view!!.site.text = resto.site
        }
        else
            view!!.site.text = "Не указан"
    }

    fun showAllReview() {
        view!!.showAllReviewText.text = "Скрыть все отзывы"
        view!!.recyclerReview.adapter = ReviewAdapter(reviewList)
    }

    fun hideAllReview() {
        view!!.showAllReviewText.text = "Все отзывы"
        view!!.recyclerReview.adapter = ReviewAdapter(reviewList.subList(0, 1))
    }

    override fun setReview(models: MutableList<com.brewmapp.brewmapp.features.main.card.product.data.model.review.Model>) {
        reviewList = models
        if (models.size > 0)
            view!!.noreviews.visibility = View.GONE
        if (models.size > 1) {
            view!!.showAllReview.visibility = View.VISIBLE
            view!!.recyclerReview.adapter = ReviewAdapter(models.subList(0, 1))
        } else
            view!!.recyclerReview.adapter = ReviewAdapter(models)
    }

    override fun setParams(params: MutableList<Param>) {
        view!!.paramRecycler.adapter = ParamAdapter(params)
    }
}