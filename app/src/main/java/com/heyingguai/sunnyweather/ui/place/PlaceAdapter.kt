package com.heyingguai.sunnyweather.ui.place

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.heyingguai.sunnyweather.R
import com.heyingguai.sunnyweather.databinding.PlaceItemBinding
import com.heyingguai.sunnyweather.login.model.Place
import com.heyingguai.sunnyweather.ui.WeatherActivity
import kotlinx.android.synthetic.main.activity_weather.*

class PlaceAdapter(private val fragment: PlaceFragment, private val placeList: List<Place>) :
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
        val holder = ViewHolder(
            PlaceItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        holder.itemView.setOnClickListener {
            val position = holder.adapterPosition
            val place = placeList[position]
            val activity = fragment.activity
            if (activity is WeatherActivity) {
                activity.drawerLayout.closeDrawers()
                activity.viewModel.locationLng = place.location.lng
                activity.viewModel.locationLat = place.location.lat
                activity.viewModel.placeName = place.name
                activity.refreshWeather()
            } else {
                val intent = Intent(parent.context, WeatherActivity::class.java).apply {
                    putExtra("location_lng", place.location.lng)
                    putExtra("location_lat", place.location.lat)
                    putExtra("place_name", place.name)
                }

                fragment.startActivity(intent)
                activity?.finish()
            }
            fragment.viewModel.savePlace(place)

        }
        return holder
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