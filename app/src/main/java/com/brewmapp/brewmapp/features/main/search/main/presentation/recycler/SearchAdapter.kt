package com.brewmapp.brewmapp.features.main.search.main.presentation.recycler

import android.app.Activity
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.core.data.TypeSearch
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
        search.select = isFiltered(search.typeSearch)
        if (search.select)
            holder.itemView.background = activity!!.resources.getDrawable(R.color.green_transparent)
        holder.itemView.setOnClickListener({
            val intent = Intent(activity, ParamActivity::class.java)
            SearchController.field = search.typeSearch
            //intent.putExtra("field", search.typeSearch.field)
            activity!!.startActivity(intent)
        })
    }

    private fun isFiltered(typeSearch: TypeSearch): Boolean {
        var map = hashMapOf<String, ArrayList<String>>()
        when (SearchController.mode) {
            Mode.BEER -> map = SearchController.beerFieldMap
            Mode.BREWERY -> map = SearchController.breweryFieldMap
            Mode.RESTO -> map = SearchController.restoFieldMap
        }
        return if (map[typeSearch.field] != null) {
            map[typeSearch.field]!!.size > 0
        } else
            false
    }
}