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

class CatalogAdapter(
    private val catalogProducts: List<Product>
) : RecyclerView.Adapter<CatalogAdapter.ViewHolder>() {
    override fun getItemCount(): Int = catalogProducts.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogAdapter.ViewHolder =
        ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.product_item_in_catalog, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(catalogProducts[position])
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
        }
    }
}