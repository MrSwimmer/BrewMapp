package com.brewmapp.brewmapp.features.main.search.main.presentation.recycler

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.ViewGroup
import android.view.LayoutInflater
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.features.main.profile.ParamController
import com.brewmapp.brewmapp.features.main.profile.SearchController
import kotlinx.android.synthetic.main.item_search.view.*

class SearchAdapter(private val searches: MutableList<Search>, val router: Router) : RecyclerView.Adapter<SearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_search, parent, false)
        return SearchViewHolder(v)
    }

    override fun getItemCount(): Int {
        return searches.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val search = searches[position]
        holder.itemView.title.text = search.title
        holder.itemView.icon.setImageResource(search.image!!)
        holder.itemView.howMuch.text = search.select
        when (SearchController.mode) {
            "beer" -> {
                if (SearchController.beerFieldMap[search.typeSearch.field] != null)
                    if (SearchController.beerFieldMap[search.typeSearch.field]!!.size > 0)
                        holder.itemView.howMuch.text = "С параметрами"
            }
            "brewery" -> {
                if (SearchController.breweryFieldMap[search.typeSearch.field] != null)
                    if (SearchController.breweryFieldMap[search.typeSearch.field]!!.size > 0)
                        holder.itemView.howMuch.text = "С параметрами"
            }
        }
        holder.itemView.setOnClickListener({
            Log.i("code", "item click ${search.typeSearch}")
            router.pushController(RouterTransaction.with(ParamController(search.typeSearch.type, search.typeSearch.field)))
        })
    }
}