package com.movile.moviletoken.receipt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.movile.moviletoken.R
import kotlinx.android.synthetic.main.receipt_list_item.view.*

class ReceiptAdapter(ctx : Context, list : MutableList<Receipt>) : RecyclerView.Adapter<ReceiptAdapter.ViewHolder>() {

    val ctx = ctx
    val receiptList = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(ctx).inflate(R.layout.receipt_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return receiptList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val receipt : Receipt = receiptList.get(position)

        holder.title.text = receipt.title
        holder.value.text = "$"+receipt.value

    }


    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.title
        var value = itemView.value
    }
}