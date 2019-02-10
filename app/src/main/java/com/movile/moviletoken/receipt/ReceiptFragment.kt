package com.movile.moviletoken.receipt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.movile.moviletoken.R
import com.movile.moviletoken.wallet.WalletFragment
import kotlinx.android.synthetic.main.receip_fragment.*

class ReceiptFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.receip_fragment, container, false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        receipt_list.layoutManager = LinearLayoutManager(activity,
            RecyclerView.VERTICAL, false)
        receipt_list.adapter = ReceiptAdapter(activity!!.application, getData())
    }

    companion object {
        fun newInstance(): ReceiptFragment = ReceiptFragment()
    }

    fun getData(): MutableList<Receipt> {
        val list = mutableListOf<Receipt>()

        var rec = Receipt()
        rec.title = "Mercadinho da Dinda"
        rec.value = 12.0

        var rec2 = Receipt()
        rec2.title = "Loja de Bike"
        rec2.value = 30.0

        var rec3 = Receipt()
        rec3.title = "Buffet do tomas"
        rec3.value = 25.0

        var rec4 = Receipt()
        rec4.title = "Padaria do João"
        rec4.value = 15.0

        var rec5 = Receipt()
        rec5.title = "Açai da Beta"
        rec5.value = 35.0

        list.add(rec)
        list.add(rec2)
        list.add(rec3)
        list.add(rec4)
        list.add(rec5)

        return list
    }
}