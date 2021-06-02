package com.heyingguai.sunnyweather.ui.place

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.heyingguai.sunnyweather.R
import com.heyingguai.sunnyweather.databinding.PlaceItemBinding
import com.heyingguai.sunnyweather.login.model.Place

class PlaceAdapter(private val fragment: Fragment, private val placeList: List<Place>) :
    RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: PlaceItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(bean: Place) {
            binding.placeName.text = bean.name
            binding.placeAddress.text = bean.address
            binding.executePendingBindings()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i("TAG", "onCreateViewHolder: ")
        return ViewHolder(
            PlaceItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val place = placeList[position]
        val lp = holder.binding.cardView.layoutParams as ViewGroup.MarginLayoutParams
        if (position == placeList.size - 1 || position == 0) {
            when (position) {
                placeList.size - 1 ->
                    lp.setMargins(
                        holder.binding.root.context.resources.getDimensionPixelSize(R.dimen.margin_two),
                        holder.binding.root.context.resources.getDimensionPixelSize(R.dimen.margin_one),
                        holder.binding.root.context.resources.getDimensionPixelSize(R.dimen.margin_two),
                        holder.binding.root.context.resources.getDimensionPixelSize(R.dimen.margin_two)
                    )
                0 ->
                    lp.setMargins(
                        holder.binding.root.context.resources.getDimensionPixelSize(R.dimen.margin_two),
                        holder.binding.root.context.resources.getDimensionPixelSize(R.dimen.margin_two),
                        holder.binding.root.context.resources.getDimensionPixelSize(R.dimen.margin_two),
                        holder.binding.root.context.resources.getDimensionPixelSize(R.dimen.margin_one)
                    )
            }

        } else {
            lp.setMargins(
                holder.binding.root.context.resources.getDimensionPixelSize(R.dimen.margin_two),
                holder.binding.root.context.resources.getDimensionPixelSize(R.dimen.margin_one),
                holder.binding.root.context.resources.getDimensionPixelSize(R.dimen.margin_two),
                holder.binding.root.context.resources.getDimensionPixelSize(R.dimen.margin_one)
            )
        }
        holder.binding.cardView.layoutParams = lp
        holder.bind(place)
    }


    override fun getItemCount() = placeList.size
}