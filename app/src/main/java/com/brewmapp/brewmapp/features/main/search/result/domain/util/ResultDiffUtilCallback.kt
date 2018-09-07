package com.brewmapp.brewmapp.features.main.search.result.domain.util

import android.support.v7.util.DiffUtil
import com.brewmapp.brewmapp.features.main.search.result.data.model.Model

class ResultDiffUtilCallback : DiffUtil.ItemCallback<Model>() {
    override fun areItemsTheSame(oldItem: Model, newItem: Model): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Model, newItem: Model): Boolean {
        return oldItem.title == newItem.title
    }

}