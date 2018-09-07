package com.brewmapp.brewmapp.features.main.news.events.presentation

import android.arch.paging.PagedListAdapter
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.features.main.card.event.presentation.EventCardController
import com.brewmapp.brewmapp.features.main.news.core.presentation.recycler.BaseViewHolder
import com.brewmapp.brewmapp.features.main.news.events.data.model.Model
import com.brewmapp.brewmapp.features.main.news.events.domain.util.util.EventsDiffUtilCallback
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_event.view.*
import org.jsoup.Jsoup
import java.text.SimpleDateFormat

class EventsPagingAdapter(diffUtilCallback: EventsDiffUtilCallback, val router: Router) : PagedListAdapter<Model, BaseViewHolder>(diffUtilCallback) {
    val df = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val dfTime = SimpleDateFormat("yyyy.MM.dd")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false)
        return BaseViewHolder(v)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val model = getItem(position)
        Log.i("code", "image ${model!!.getThumb}")
        Glide.with(holder.itemView)
                .load(model.photo[0].urlPreview)
                .into(holder.itemView.image)
        if (model.text.get1() != null)
            holder.itemView.text.text = Jsoup.parse(model.text.get1()).text()
        val date = df.parse(model.dateFrom)
        holder.itemView.date.text = dfTime.format(date)
        holder.itemView.like.text = model.like
        holder.itemView.userName.text = model.userInfo.firstname
        holder.itemView.setOnClickListener({
            router.pushController(RouterTransaction.with(EventCardController(model.id)))
        })
    }
}