package com.example.drappoinmentapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.example.drappoinmentapp.Activity.DetailActivity
import com.example.drappoinmentapp.Model.DoctorsModel
import com.example.drappoinmentapp.databinding.ViewholderNearbyDoctorBinding

class NearDoctorAdapter(val items: MutableList<DoctorsModel>) :
    RecyclerView.Adapter<NearDoctorAdapter.ViewHolder>() {
    private var context: Context? = null

    class ViewHolder(val binding: ViewholderNearbyDoctorBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NearDoctorAdapter.ViewHolder {
        context = parent.context
        return ViewHolder(
            ViewholderNearbyDoctorBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NearDoctorAdapter.ViewHolder, position: Int) {
        holder.binding.nameTxt.text = items[position].Name
        holder.binding.specialTxt.text = items[position].Special
        holder.binding.costTxt.text = items[position].Cost
        Glide.with(holder.itemView.context)
            .load(items[position].Picture)
            .apply { RequestOptions().transform(CenterCrop()) }
            .into(holder.binding.img)

        holder.binding.root.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("0", items[position])
            context?.startActivity(intent)
        }

    }

    override fun getItemCount(): Int = items.size

}