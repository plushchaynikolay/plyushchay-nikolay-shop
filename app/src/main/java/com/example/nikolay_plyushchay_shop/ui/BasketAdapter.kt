package com.example.nikolay_plyushchay_shop.ui

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nikolay_plyushchay_shop.R
import com.example.nikolay_plyushchay_shop.model.Product
import com.example.nikolay_plyushchay_shop.presenter.format
import kotlinx.android.synthetic.main.basket_item.view.*

class BasketAdapter(
    private val onDelete: (string: String) -> Unit
) : RecyclerView.Adapter<BasketAdapter.ViewHolder>() {
    private var products: List<Product> = listOf()

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

    fun setItems(products: List<Product>) {
        this.products = products
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(product: Product) {
            itemView.basketTvName.text = product.name
            if (product.discount > 0) {
                itemView.basketTvOldPrice.text = format(product.price)
                itemView.basketTvOldPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG

                itemView.basketTvPrice.text = format(product.discountPrice)
                itemView.basketTvPrice.setTextColor(Color.parseColor("#FFFF4444"))
                itemView.basketTvPrice.setTypeface(null, Typeface.BOLD)
            } else {
                itemView.basketTvOldPrice.text = ""
                itemView.basketTvPrice.text = format(product.price)
            }
            itemView.basketDeleteIb.setOnClickListener { onDelete(product.name) }
        }
    }
}
