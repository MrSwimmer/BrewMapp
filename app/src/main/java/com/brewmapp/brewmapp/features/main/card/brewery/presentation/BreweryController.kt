package com.brewmapp.brewmapp.features.main.card.brewery.presentation

import android.content.Intent
import android.net.Uri
import android.support.v7.widget.LinearLayoutManager
import android.text.Html
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BaseController
import com.brewmapp.brewmapp.features.main.card.resto.data.AdditionalData
import com.brewmapp.brewmapp.features.main.card.resto.presentation.recycler.ReviewAdapter
import com.bumptech.glide.Glide
import com.google.gson.Gson
import kotlinx.android.synthetic.main.controller_brewery.view.*
import org.jsoup.Jsoup
import java.util.*

class BreweryController() : BaseController<BreweryContract.View, BreweryContract.Presenter>(), BreweryContract.View {
    lateinit var id: String
    var isAllReviewShowed = false
    var reviewList = mutableListOf<com.brewmapp.brewmapp.features.main.card.product.data.model.review.Model>()

    constructor(id: String) : this() {
        this.id = id
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_brewery, container, false)
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
        presenter.getBrewery(id)
    }

    override fun createPresenter(): BreweryContract.Presenter {
        return BreweryPresenter()
    }

    override fun setBrewery(model: com.brewmapp.brewmapp.features.main.card.brewery.data.model.Model) {
        Glide.with(activity!!)
                .load("https://brewmapp.com/${model.getThumb}")
                .into(view!!.image)
        view!!.likes.text = model.like
        view!!.dislikes.text = model.disLike
        view!!.text.text = Jsoup.parse(model.text.get1()).text()

        //location
        val location = model.country.get1()
        view!!.location.text = location
        view!!.location.setOnClickListener({
            val uri = String.format(Locale.ENGLISH, "geo:0,0?q=$location")
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
            startActivity(intent)
        })

        //add
        val gson = Gson()
        val add = gson.fromJson(model.additionalData, AdditionalData::class.java)

        //site
        if (add.sites.isNotEmpty()) {
            view!!.site.movementMethod = LinkMovementMethod.getInstance()
            val siteText = "<a href=${add.sites[0]}> ${add.sites[0]} </a>"
            view!!.site.text = Html.fromHtml(siteText)
        }

        //phone
        if (add.phones.isNotEmpty()) {
            view!!.phone.setOnClickListener({
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+${add.phones[0]}"))
                startActivity(intent)
            })
            view!!.phone.text = "+${add.phones[0]}"
        }

        //socials
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