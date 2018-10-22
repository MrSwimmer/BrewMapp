package com.brewmapp.brewmapp.features.main.card.product.presentation.recycler.param

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.features.main.card.product.presentation.recycler.resto.Resto
import com.brewmapp.brewmapp.features.main.profile.RestoController
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_beer_resto.view.*

class RestoAdapter(val restoList: MutableList<Resto>, private val router: Router) : RecyclerView.Adapter<RestoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestoViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_beer_resto, parent, false)
        return RestoViewHolder(v)
    }

    override fun getItemCount(): Int {
        return restoList.size
    }

    override fun onBindViewHolder(holder: RestoViewHolder, position: Int) {
        val resto = restoList[position]
        holder.itemView.title.text = resto.title
        holder.itemView.city.text = resto.city
        holder.itemView.metro.text = resto.metro
        holder.itemView.beerTitle.text = resto.titleBeer
        holder.itemView.beerPrice.text = resto.prices
        holder.itemView.mark.text = resto.mark
        Glide.with(holder.itemView)
                .load("https://www.brewmapp.com/${resto.icon}")
                .into(holder.itemView.icon)
        Glide.with(holder.itemView)
                .load(resto.iconBeer)
                .into(holder.itemView.iconBeer)
        holder.itemView.setOnClickListener {
            router.pushController(RouterTransaction.with(RestoController(resto.id)))
        }
    }
}