package com.brewmapp.brewmapp.features.main.card.event.presentation

import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.RouterTransaction
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BaseController
import com.brewmapp.brewmapp.features.main.map.map.presentation.MapController
import com.brewmapp.brewmapp.features.main.news.events.data.model.Model
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.controller_card_event.view.*

class EventCardController(): BaseController<EventCardContract.View, EventCardContract.Presenter>(), EventCardContract.View {
    lateinit var id: String
    constructor(id: String) : this() {
        this.id = id
    }

    override fun createPresenter(): EventCardContract.Presenter {
        return EventCardPresenter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_card_event, container, false)
        view.recyclerReview.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(activity!!)
        return view
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        presenter.getEvent(id)
    }

    override fun setEvent(model: Model) {
        view!!.text.text = model.text.get1()
        view!!.likes.text = model.like
        view!!.dislikes.text = model.disLike
        view!!.locationName.text = model.location.location.name
        view!!.date.text = model.dateFrom
        val metro = if (model.location.metro != null)
            "м. ${model.location.metro.name.get1()}"
        else
            ""
        val location = "г.${model.location.cityId.get1()} $metro ${model.location.location.street.get1()} ${model.location.location.house.get1()}"
        view!!.location.text = location
        /*view!!.location.setOnClickListener {
            router.pushController(RouterTransaction.with(MapController(model.locationId)))
        }*/
        view!!.interested.text = model.interested
        view!!.invited.text = model.invited
        view!!.willGo.text = model.iWillCo

        Glide.with(activity!!)
                .load(model.photo[0].urlPreview)
                .into(view!!.image)
    }
}