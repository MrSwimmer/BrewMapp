package com.brewmapp.brewmapp.features.main.news.domain.util

import android.support.v7.util.DiffUtil
import com.brewmapp.brewmapp.features.main.news.data.model.Model


class NewsDiffUtilCallback : DiffUtil.ItemCallback<Model>() {
    override fun areItemsTheSame(oldItem: Model, newItem: Model): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Model, newItem: Model): Boolean {
        return oldItem.like == newItem.like
    }
}