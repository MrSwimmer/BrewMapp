package com.brewmapp.brewmapp.features.main.search.main.presentation.recycler

import android.app.Activity
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.ViewGroup
import android.view.LayoutInflater
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.features.main.profile.AdSearchActivity
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
        holder.itemView.setOnClickListener({
            Log.i("code", "item click ${search.type}")
            val intent = Intent(activity, AdSearchActivity::class.java)
            intent.putExtra("type", search.type)
            activity!!.startActivity(intent)
        })
    }
}