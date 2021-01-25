package com.dean.tombasinproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dean.tombasinproject.R
import com.dean.tombasinproject.model.Tumbasin
import kotlinx.android.synthetic.main.list_item.view.*

class TumbasinAdapter(private val listener: (Tumbasin) ->Unit)
    : RecyclerView.Adapter<TumbasinAdapter.ViewHolder>() {
    private val listData = ArrayList<Tumbasin>()

    fun setData(items: ArrayList<Tumbasin>){
        listData.clear()
        listData.addAll(items)
        //syncron data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listData[position], listener)
    }

    override fun getItemCount(): Int = listData.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tumbasin: Tumbasin, listener: (Tumbasin) -> Unit) {
            with(itemView){
                Glide.with(itemView.context).load(tumbasin.image)
                    .apply(RequestOptions().override(300)).into(img_product)

                tv_name.setText(tumbasin.name)
                tv_price.setText(tumbasin.price)

                itemView.setOnClickListener { listener(tumbasin) }

            }
        }
    }
}