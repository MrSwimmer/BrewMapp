package com.brewmapp.brewmapp.features.main.profile

import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BaseController
import com.brewmapp.brewmapp.features.main.card.product.data.model.product.Model
import com.brewmapp.brewmapp.features.main.card.product.presentation.recycler.param.Param
import com.brewmapp.brewmapp.features.main.card.product.presentation.recycler.param.ParamAdapter
import com.brewmapp.brewmapp.features.main.card.product.presentation.recycler.param.RestoAdapter
import com.brewmapp.brewmapp.features.main.card.product.presentation.recycler.param.ReviewAdapter
import com.brewmapp.brewmapp.features.main.card.product.presentation.recycler.resto.Resto
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
    var isAllParamsShowed = false

    var restoList = mutableListOf<Resto>()
    var reviewList = mutableListOf<com.brewmapp.brewmapp.features.main.card.product.data.model.review.Model>()
    var paramsList = mutableListOf<Param>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_product, container, false)
        view.paramRecycler.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(activity!!)
        view.recyclerResto.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(activity!!)
        view.recyclerReview.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(activity!!)
        view.showAllResto.setOnClickListener {
            if (isAllRestoShowed)
                hideAllResto()
            else
                showAllResto()
            isAllRestoShowed = !isAllRestoShowed
        }
        view.showAllReview.setOnClickListener {
            if (isAllReviewShowed)
                hideAllReview()
            else
                showAllReview()
            isAllReviewShowed = !isAllReviewShowed
        }
        view.showAllParams.setOnClickListener {
            if (isAllParamsShowed)
                hideAllParams()
            else
                showAllParams()
            isAllParamsShowed = !isAllParamsShowed
        }
        return view
    }

    override fun createPresenter(): ProductContract.Presenter {
        return ProductPresenter()
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        presenter.getProduct(id)
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
            view!!.recyclerResto.adapter = RestoAdapter(restoList.subList(0, 3), router)
        } else
            view!!.recyclerResto.adapter = RestoAdapter(restoList, router)
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

    override fun setParams(paramsList: MutableList<Param>) {
        this.paramsList = paramsList
        view!!.paramRecycler.adapter = ParamAdapter(paramsList.subList(0, 3))
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
        view!!.recyclerResto.adapter = RestoAdapter(restoList, router)
    }

    fun hideAllResto() {
        view!!.showAllRestoText.text = "Все заведения"
        view!!.recyclerResto.adapter = RestoAdapter(restoList.subList(0, 3), router)
    }

    private fun showAllParams() {
        view!!.showAllParams.setImageResource(R.drawable.ic_arrow_up)
        view!!.paramRecycler.adapter = ParamAdapter(paramsList)
    }

    private fun hideAllParams() {
        view!!.showAllParams.setImageResource(R.drawable.ic_arrow_down)
        view!!.paramRecycler.adapter = ParamAdapter(paramsList.subList(0, 3))
    }
}