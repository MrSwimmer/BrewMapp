package com.brewmapp.brewmapp.features.main.search.presentation.recycler

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import com.bluelinelabs.conductor.Router
import com.brewmapp.brewmapp.R
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
        holder.itemView.setOnClickListener({
            when (search.image) {
                //R.drawable.ic_logo -> router.pushController()
            }
        })
    }
}