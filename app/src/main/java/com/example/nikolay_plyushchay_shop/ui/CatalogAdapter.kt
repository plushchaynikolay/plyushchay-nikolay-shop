package com.example.nikolay_plyushchay_shop.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nikolay_plyushchay_shop.R
import kotlinx.android.synthetic.main.catalog_item.view.*

class CatalogAdapter(
    private val catalogList: List<String>
) : RecyclerView.Adapter<CatalogAdapter.ViewHolder>() {
    override fun getItemCount(): Int = catalogList.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogAdapter.ViewHolder =
        ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.catalog_item, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(catalogList[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(text: String) {
            itemView.catalogTv.text = text
        }
    }
}