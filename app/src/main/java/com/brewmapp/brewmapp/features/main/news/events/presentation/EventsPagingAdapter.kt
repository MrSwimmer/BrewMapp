package com.brewmapp.brewmapp.features.main.news.events.presentation

import android.arch.paging.PagedListAdapter
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bluelinelabs.conductor.Router
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.features.main.news.core.presentation.recycler.BaseViewHolder
import com.brewmapp.brewmapp.features.main.news.events.data.model.Model
import com.brewmapp.brewmapp.features.main.news.events.domain.util.util.EventsDiffUtilCallback

class EventsPagingAdapter(diffUtilCallback: EventsDiffUtilCallback, val router: Router) : PagedListAdapter<Model, BaseViewHolder>(diffUtilCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false)
        return BaseViewHolder(v)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val model = getItem(position)
    }
}