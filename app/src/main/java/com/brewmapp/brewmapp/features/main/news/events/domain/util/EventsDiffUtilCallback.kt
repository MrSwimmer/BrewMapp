package com.brewmapp.brewmapp.features.main.news.events.domain.util

import androidx.recyclerview.widget.DiffUtil
import com.brewmapp.brewmapp.features.main.news.events.data.model.Model


class EventsDiffUtilCallback : DiffUtil.ItemCallback<Model>() {
    override fun areItemsTheSame(oldItem: Model, newItem: Model): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Model, newItem: Model): Boolean {
        return oldItem.like == newItem.like
    }
}