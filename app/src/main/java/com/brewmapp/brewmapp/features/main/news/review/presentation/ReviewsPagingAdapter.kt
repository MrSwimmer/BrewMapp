package com.brewmapp.brewmapp.features.main.news.review.presentation

import android.arch.paging.PagedListAdapter
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bluelinelabs.conductor.Router
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.features.main.news.core.presentation.recycler.BaseViewHolder
import com.brewmapp.brewmapp.features.main.news.review.data.model.Model
import com.brewmapp.brewmapp.features.main.news.review.domain.util.ReviewsDiffUtilCallback
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_review.view.*
import kotlinx.android.synthetic.main.item_review_resto.view.*

class ReviewsPagingAdapter(diffUtilCallback: ReviewsDiffUtilCallback, val router: Router) : PagedListAdapter<Model, BaseViewHolder>(diffUtilCallback) {
    val RESTO = 0
    val BEER = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val layout: Int
        if (viewType == BEER)
            layout = R.layout.item_review
        else
            layout = R.layout.item_review_resto
        val v = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return BaseViewHolder(v)
    }

    override fun getItemViewType(position: Int): Int {
        val model = getItem(position)
        if (model!!.relatedModel == "Beer")
            return BEER
        else
            return RESTO
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val type = getItemViewType(position)
        val model = getItem(position)
        if (model!!.relatedModelData.title != null) {
            Log.i("code", "1 ${model.relatedModelData.title._1}")
            Log.i("code", "58 ${model.relatedModelData.title._58}")
        }
        if (type == BEER) {
            if (model.relatedModelData.title != null) {
                if (model.relatedModelData.title._1 == null)
                    holder.itemView.title.text = model.relatedModelData.title._58
                else
                    holder.itemView.title.text = model.relatedModelData.title._1
            }
            holder.itemView.type.text = model.relatedModel

            holder.itemView.scent.text = model.relatedModelData.evaluation[0].evaluationValue
            holder.itemView.color.text = model.relatedModelData.evaluation[1].evaluationValue
            holder.itemView.taste.text = model.relatedModelData.evaluation[2].evaluationValue
            holder.itemView.aftertaste.text = model.relatedModelData.evaluation[3].evaluationValue
            holder.itemView.text.text = Html.fromHtml(model.text).toString()
            val firstName = if (model.userInfo.firstname == null)
                ""
            else
                model.userInfo.firstname
            val lastName = if (model.userInfo.lastname == null)
                ""
            else
                model.userInfo.lastname
            holder.itemView.titleProd.text = "$firstName $lastName"
            holder.itemView.date.text = model.relatedModelData.evaluation[0].createdAt
            holder.itemView.likes.text = model.like
            holder.itemView.dislikes.text = model.disLike

            if (model.userGetThumb != null)
                if (model.userGetThumb.url != null) {
                    Glide.with(holder.itemView)
                            .load(model.userGetThumb.urlPreview)
                            .into(holder.itemView.iconProd)
                }

            if (model.relatedModelData.getThumb != null)
                Glide.with(holder.itemView)
                        .load(model.relatedModelData.getThumb.urlPreview)
                        .into(holder.itemView.icon)
        } else {
            if (model.relatedModelData.name != null) {
                if (model.relatedModelData.name._1 == null)
                    holder.itemView.titleresto.text = model.relatedModelData.name._58
                else
                    holder.itemView.titleresto.text = model.relatedModelData.name._1
            }
            holder.itemView.typeresto.text = model.relatedModel

            holder.itemView.textresto.text = Html.fromHtml(model.text).toString()
            val firstName = if (model.userInfo.firstname == null)
                ""
            else
                model.userInfo.firstname
            val lastName = if (model.userInfo.lastname == null)
                ""
            else
                model.userInfo.lastname
            holder.itemView.titleProdresto.text = "$firstName $lastName"
            holder.itemView.dateresto.text = model.relatedModelData.evaluation[0].createdAt
            holder.itemView.likesresto.text = model.like
            holder.itemView.dislikesresto.text = model.disLike

            if (model.userGetThumb != null)
                if (model.userGetThumb.url != null) {
                    Glide.with(holder.itemView)
                            .load(model.userGetThumb.urlPreview)
                            .into(holder.itemView.iconProdresto)
                }

            if (model.relatedModelData.getThumb != null)
                Glide.with(holder.itemView)
                        .load(model.relatedModelData.getThumb.urlPreview)
                        .into(holder.itemView.iconresto)
        }
    }
}