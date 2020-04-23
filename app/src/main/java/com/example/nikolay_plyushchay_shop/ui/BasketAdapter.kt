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
import kotlinx.android.synthetic.main.product_item.view.*

class BasketAdapter(
    private val onDelete: (string: String) -> Unit
) : RecyclerView.Adapter<BasketAdapter.ViewHolder>() {
    private var products: List<Product> = listOf()

    override fun getItemCount(): Int = products.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketAdapter.ViewHolder =
        ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.product_item, parent, false)
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
            itemView.productTvName.text = product.name
            if (product.discount > 0) {
                itemView.productTvOldPrice.text = format(product.price)
                itemView.productTvOldPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG

                itemView.productTvPrice.text = format(product.discountPrice)
                itemView.productTvPrice.setTextColor(Color.parseColor("#FFFF4444"))
                itemView.productTvPrice.setTypeface(null, Typeface.BOLD)
            } else {
                itemView.productTvOldPrice.text = ""
                itemView.productTvPrice.text = format(product.price)
            }
            itemView.basketDeleteIb.setOnClickListener { onDelete(product.name) }
        }
    }
}
