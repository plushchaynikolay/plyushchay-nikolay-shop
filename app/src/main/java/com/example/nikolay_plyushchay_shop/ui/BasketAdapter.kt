package com.example.nikolay_plyushchay_shop.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nikolay_plyushchay_shop.R
import kotlinx.android.synthetic.main.basket_item.view.*

class BasketAdapter(
    private val onDelete: (string: String) -> Unit
) : RecyclerView.Adapter<BasketAdapter.ViewHolder>() {
    private var products: List<String> = listOf()

    override fun getItemCount(): Int = products.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketAdapter.ViewHolder =
        ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.basket_item, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(products[position])
    }

    fun setItems(products: List<String>) {
        this.products = products
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(text: String) {
            itemView.basketTv.text = text
            itemView.basketDeleteIb.setOnClickListener { onDelete(text) }
        }
    }
}
