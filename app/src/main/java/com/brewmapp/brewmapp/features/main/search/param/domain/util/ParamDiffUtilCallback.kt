package com.brewmapp.brewmapp.features.main.search.param.domain.util

import android.support.v7.util.DiffUtil
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Model

class ParamDiffUtilCallback : DiffUtil.ItemCallback<Model>() {
    override fun areItemsTheSame(oldItem: Model, newItem: Model): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Model, newItem: Model): Boolean {
        return oldItem.name == newItem.name
    }
}