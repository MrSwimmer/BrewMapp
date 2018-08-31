package com.brewmapp.brewmapp.features.main.news.review.domain.util

import android.support.v7.util.DiffUtil
import com.brewmapp.brewmapp.features.main.news.review.data.model.Model


class ReviewsDiffUtilCallback : DiffUtil.ItemCallback<Model>() {
    override fun areItemsTheSame(oldItem: Model, newItem: Model): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Model, newItem: Model): Boolean {
        return oldItem.like == newItem.like
    }
}