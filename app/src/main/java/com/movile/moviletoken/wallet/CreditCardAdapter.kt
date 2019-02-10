package com.movile.moviletoken.wallet

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.movile.moviletoken.R

class CreditCardAdapter(ctx : Context,
                        list: MutableList<CreditCard>): RecyclerView.Adapter<CreditCardAdapter.ViewHolder>() {

    val ctx = ctx
    val creditCardList = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(ctx).inflate(R.layout.credit_card_item_list, parent, false))
    }

    override fun getItemCount(): Int {
        return creditCardList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val creditCard = creditCardList.get(position)
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }
}