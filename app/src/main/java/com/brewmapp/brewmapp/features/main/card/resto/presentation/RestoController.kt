package com.brewmapp.brewmapp.features.main.profile

import android.support.v7.widget.LinearLayoutManager
import android.text.Html
import android.text.method.LinkMovementMethod
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BaseController
import com.brewmapp.brewmapp.features.main.card.product.data.model.resto.Model
import com.brewmapp.brewmapp.features.main.card.resto.data.AdditionalData
import com.bumptech.glide.Glide
import com.google.gson.Gson
import kotlinx.android.synthetic.main.controller_resto.view.*
import org.jsoup.Jsoup
import android.content.Intent
import android.net.Uri
import com.brewmapp.brewmapp.features.main.card.resto.presentation.recycler.ReviewAdapter
import java.util.*


class RestoController() : BaseController<RestoContract.View, RestoContract.Presenter>(), RestoContract.View {
    lateinit var id: String
    var isAllReviewShowed = false
    var reviewList = mutableListOf<com.brewmapp.brewmapp.features.main.card.product.data.model.review.Model>()

    constructor(id: String) : this() {
        this.id = id
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_resto, container, false)
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
                .load("https://brewmapp.com/${resto.getThumb}")
                .into(view!!.image)
        view!!.likes.text = resto.like
        view!!.dislikes.text = resto.disLike
        view!!.text.text = Jsoup.parse(resto.text.get1()).text()
        val metro = if (resto.location.metro == null)
            "м. ${resto.location.metro.name.get1()}"
        else
            ""
        val location = "г.${resto.location.cityId.get1()} $metro ${resto.location.location.street.get1()} ${resto.location.location.house.get1()}"
        view!!.location.text = location
        view!!.location.setOnClickListener({
            val uri = String.format(Locale.ENGLISH, "geo:0,0?q=$location")
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
            startActivity(intent)
        })
        if (resto.site != "") {
            view!!.site.movementMethod = LinkMovementMethod.getInstance()
            val siteText = "<a href=${resto.site}> ${resto.site} </a>"
            view!!.site.text = Html.fromHtml(siteText)
        } else
            view!!.site.text = "Не указан"
        val gson = Gson()
        Log.i("code", "addit ${resto.additionalData}")
        val add = gson.fromJson(resto.additionalData, AdditionalData::class.java)
        Log.i("code", "$id ${add.emails} ${add.phones} ${add.socials}")
        if (add.phones.isNotEmpty()) {
            view!!.phone.setOnClickListener({
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+${add.phones[0]}"))
                startActivity(intent)
            })
            view!!.phone.text = "+${add.phones[0]}"
        }
        if (add.socials.isNotEmpty()) {
            view!!.inSocialNetsLayout.visibility = View.VISIBLE
            add.socials.forEach {
                val url = it
                if (it.contains("vk.com")) {
                    view!!.vk.visibility = View.VISIBLE
                    view!!.vk.setOnClickListener({
                        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        startActivity(browserIntent)
                    })
                }
                if (it.contains("facebook.com")) {
                    view!!.facebook.visibility = View.VISIBLE
                    view!!.facebook.setOnClickListener({
                        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        startActivity(browserIntent)
                    })
                }
                if (it.contains("instagram.com")) {
                    view!!.instagram.visibility = View.VISIBLE
                    view!!.instagram.setOnClickListener({
                        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        startActivity(browserIntent)
                    })
                }
            }
        }
        view!!.price.text = "Средний счет: ${model.resto[0].lunchPrice}"
        view!!.restoType.text = "Тип заведения: ${model.restoType[0].name.get1()}"
        view!!.kitchen.text = "Кухня: ${model.restoKitchen[0].name.get1()}"
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
}