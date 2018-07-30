package com.brewmapp.brewmapp.features.main.search.main.presentation.recycler

import android.app.Activity
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.ViewGroup
import android.view.LayoutInflater
import com.bluelinelabs.conductor.RouterTransaction
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.features.main.profile.ParamActivity
import com.brewmapp.brewmapp.features.main.profile.SearchController
import kotlinx.android.synthetic.main.item_search.view.*

class SearchAdapter(private val searches: MutableList<Search>, val activity: Activity?) : RecyclerView.Adapter<SearchViewHolder>() {

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
            Mode.BEER.name -> {
                if (SearchController.beerFieldMap[search.typeSearch.field] != null)
                    if (SearchController.beerFieldMap[search.typeSearch.field]!!.size > 0)
                        holder.itemView.howMuch.text = "С параметрами"
            }
            Mode.BREWERY.name -> {
                if (SearchController.breweryFieldMap[search.typeSearch.field] != null)
                    if (SearchController.breweryFieldMap[search.typeSearch.field]!!.size > 0)
                        holder.itemView.howMuch.text = "С параметрами"
            }
            Mode.RESTO.name -> {
                if (SearchController.restoFieldMap[search.typeSearch.field] != null)
                    if (SearchController.restoFieldMap[search.typeSearch.field]!!.size > 0)
                        holder.itemView.howMuch.text = "С параметрами"
            }
        }
        holder.itemView.setOnClickListener({
            Log.i("code", "item click ${search.typeSearch.type}")
            val intent = Intent(activity, ParamActivity::class.java)
            intent.putExtra("field", search.typeSearch.field)
            intent.putExtra("type", search.typeSearch.type)
            activity!!.startActivity(intent)
            //router.pushController(RouterTransaction.with(ParamActivity(search.typeSearch.type, search.typeSearch.field)))
        })
    }
}