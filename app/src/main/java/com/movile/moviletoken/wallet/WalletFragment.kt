package com.movile.moviletoken.wallet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.movile.moviletoken.R
import com.movile.moviletoken.main.TokenFragment
import kotlinx.android.synthetic.main.wallet_fragment.*

class WalletFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.wallet_fragment, container, false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        credicard_list.layoutManager = LinearLayoutManager(activity,
            LinearLayoutManager.HORIZONTAL, false)
        credicard_list.adapter = CreditCardAdapter(activity!!.application, getCredCards())
    }

    companion object {
        fun newInstance(): WalletFragment = WalletFragment()
    }

    fun getCredCards(): MutableList<CreditCard> {

        return mutableListOf(CreditCard(), CreditCard())
    }

}