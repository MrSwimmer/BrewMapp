package com.brewmapp.brewmapp.features.main.search.result.presentation.recycler

import android.arch.paging.PagedListAdapter
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.features.main.card.brewery.presentation.BreweryController
import com.brewmapp.brewmapp.features.main.profile.ProductController
import com.brewmapp.brewmapp.features.main.profile.RestoController
import com.brewmapp.brewmapp.features.main.profile.SearchController
import com.brewmapp.brewmapp.features.main.search.result.data.model.Model
import com.brewmapp.brewmapp.features.main.search.result.data.model.Text
import com.brewmapp.brewmapp.features.main.search.result.domain.util.ResultDiffUtilCallback
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.google.gson.internal.LinkedTreeMap
import kotlinx.android.synthetic.main.item_result.view.*
import org.json.JSONObject
import org.jsoup.Jsoup

class ResultPagingAdapter(diffUtilCallback: ResultDiffUtilCallback, val router: Router) : PagedListAdapter<Model, ResultViewHolder>(diffUtilCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_result, parent, false)
        return ResultViewHolder(v)
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val model = getItem(position)

        if (model!!.title != null)
            if (model.title.get1() != null)
                holder.itemView.title.text = model.title.get1()

        if (model.getThumb.urlPreview != null)
            Glide.with(holder.itemView)
                    .load(model.getThumb.urlPreview)
                    .into(holder.itemView.image)

        if (model.avgBall != null)
            holder.itemView.mark.text = model.avgBall

        val text = try {
            model.text.get1()
        } catch (e: Exception) {
            ""
        }

        holder.itemView.description.text = text

        holder.itemView.setOnClickListener({
            when (SearchController.mode) {
                Mode.BEER -> router.pushController(RouterTransaction.with(ProductController(model.id)))
                Mode.RESTO -> router.pushController(RouterTransaction.with(RestoController(model.id)))
                Mode.BREWERY -> router.pushController(RouterTransaction.with(BreweryController(model.id)))
            }
        })
    }
}