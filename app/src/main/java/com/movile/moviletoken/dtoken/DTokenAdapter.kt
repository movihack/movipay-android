package com.movile.moviletoken.dtoken

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.movile.moviletoken.R
import kotlinx.android.synthetic.main.dtoken_list_item.view.*

class DTokenAdapter(ctx : Context, list : MutableList<DToken>) : RecyclerView.Adapter<DTokenAdapter.DTokenViewHolder>() {
    val ctx = ctx
    val dTokenList = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DTokenAdapter.DTokenViewHolder {
        return DTokenViewHolder(LayoutInflater.from(ctx).inflate(R.layout.dtoken_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return dTokenList.size
    }

    override fun onBindViewHolder(holder: DTokenAdapter.DTokenViewHolder, position: Int) {
        val dToken = dTokenList.get(position)
        holder.id.text = dToken.id
        holder.value.text = "$"+dToken.value.toString()
        holder.time.text = dToken.time
    }

    class DTokenViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val id = itemView.dtoken_id
        val value = itemView.dtoken_value
        val time = itemView.dtoken_time

        init{
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
       }

    }
}