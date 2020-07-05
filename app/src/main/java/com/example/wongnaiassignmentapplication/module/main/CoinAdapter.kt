package com.example.wongnaiassignmentapplication.module.main

import android.graphics.drawable.PictureDrawable
import android.net.Uri
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.example.wongnaiassignmentapplication.databinding.CardNormalLayoutBinding
import com.example.wongnaiassignmentapplication.databinding.CardReverseLayoutBinding
import com.example.wongnaiassignmentapplication.model.CoinModel


private const val NORMAL_TYPE = 0
private const val REVERSE_TYPE = 1

class CoinAdapter(): PagedListAdapter<CoinModel, CoinAdapter.ViewHolder>(
    CoinDiffCallback
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if(viewType == NORMAL_TYPE) {
            ViewHolder(
                CardNormalLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        } else {
            ViewHolder(
                CardReverseLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return if(position % 5 != 4) {
            NORMAL_TYPE
        } else {
            REVERSE_TYPE
        }
    }

    class ViewHolder(private val binding: ViewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(model: CoinModel?) {
            when(binding) {
                 is CardNormalLayoutBinding -> {
                     binding.title.text = model?.name
                     if(!model?.description.isNullOrEmpty()) {
                         binding.desc.text = Html.fromHtml(model?.description)
                     }
                     Glide.with(binding.root)
                         .load(Uri.parse(model?.iconUrl))
                         .into(binding.icon)
                 }
                is CardReverseLayoutBinding -> {
                    binding.title.text = model?.name
                    Glide.with(binding.root)
                        .load(Uri.parse(model?.iconUrl))
                        .into(binding.icon)
                }
            }

        }

    }

    companion object {
        val CoinDiffCallback = object :   DiffUtil.ItemCallback<CoinModel>() {
            override fun areItemsTheSame(oldItem: CoinModel, newItem: CoinModel): Boolean {
                return oldItem.id == newItem.id && oldItem.description == newItem.description
            }

            override fun areContentsTheSame(oldItem: CoinModel, newItem: CoinModel): Boolean {
                return oldItem == newItem
            }
        }
    }

}