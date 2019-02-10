package com.movile.moviletoken.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.movile.moviletoken.R
import com.movile.moviletoken.receipt.ReceiptFragment
import com.movile.moviletoken.wallet.WalletFragment
import kotlinx.android.synthetic.main.main_activity.*
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        navigation_view.setSelectedItemId(R.id.navigation_1)
        navigation_view.setOnNavigationItemSelectedListener(this)

        openFragment(TokenFragment.newInstance())
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.navigation_1 -> {
                openFragment(TokenFragment.newInstance())
            }
            R.id.navigation_2 -> {
                openFragment(WalletFragment.newInstance())
            }
            R.id.navigation_3 -> {
                openFragment(ReceiptFragment.newInstance())
            }
        }
        return true
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.push, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.receive_push) {

            val builder = AlertDialog.Builder(this)
            //define o titulo
            builder.setTitle("Confirmação de Compra")
            builder.setMessage("Sua compra no estabelecimento do seu zé foi confirmada")
            builder.setPositiveButton("OK",
                DialogInterface.OnClickListener { arg0, arg1 ->

                })

            builder.show()

            return true
        }

        return super.onOptionsItemSelected(item)
    }

}