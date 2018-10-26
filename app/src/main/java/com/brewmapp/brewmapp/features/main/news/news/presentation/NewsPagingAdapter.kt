package com.brewmapp.brewmapp.features.main.news.news.presentation

import androidx.paging.PagedListAdapter
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.features.main.card.news.NewsCardController
import com.brewmapp.brewmapp.features.main.news.news.data.model.Model
import com.brewmapp.brewmapp.features.main.news.news.domain.util.NewsDiffUtilCallback
import com.brewmapp.brewmapp.features.main.news.core.presentation.recycler.BaseViewHolder
import com.brewmapp.brewmapp.features.main.news.share.ShareController
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_date.view.*
import kotlinx.android.synthetic.main.item_news.view.*
import org.jsoup.Jsoup
import java.text.SimpleDateFormat
import java.util.*

class NewsPagingAdapter(diffUtilCallback: NewsDiffUtilCallback, val router: Router) : PagedListAdapter<Model, BaseViewHolder>(diffUtilCallback) {
    var prevDate = Date()
    var day = ""
    val df = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val dfTime = SimpleDateFormat("HH:mm")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val idLayout = when (viewType) {
            0 -> R.layout.item_news
            else -> R.layout.item_date
        }
        val v = LayoutInflater.from(parent.context).inflate(idLayout, parent, false)
        return BaseViewHolder(v)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {

        Log.i("code", "item type ${getItemViewType(position)}")
        val model = getItem(position)
        if (getItemViewType(position) == 1) {
            holder.itemView.dateDelim.text = model!!.timestamp
        } else {
            Log.i("code", "image ${model!!.getThumb}")
            if (model.photo != null)
                Glide.with(holder.itemView)
                        .load(model.photo[0].urlPreview)
                        .into(holder.itemView.image)
            if (model.text["1"] != null)
                holder.itemView.text.text = Jsoup.parse(model.text["1"]).text()
            val date = df.parse(model.timestamp)
            holder.itemView.date.text = dfTime.format(date)
            holder.itemView.userName.text = model.userInfo.firstname
            holder.itemView.like.text = model.like
            holder.itemView.setOnClickListener({
                router.pushController(RouterTransaction.with(NewsCardController(model.id)))
            })
            /*holder.itemView.share.setOnClickListener({
                router.pushController(RouterTransaction.with(ShareController(model.id)))
            })*/
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position)!!.id == "-1") {
            1
        } else {
            0
        }
    }
}