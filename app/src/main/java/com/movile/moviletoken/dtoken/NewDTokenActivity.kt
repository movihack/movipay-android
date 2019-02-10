package com.movile.moviletoken.dtoken

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.model.LatLng
import com.movile.moviletoken.R
import com.movile.moviletoken.repository.DTokenRepository
import com.movile.moviletoken.repository.WalletRepository
import kotlinx.android.synthetic.main.ndtoken_activity.*

class NewDTokenActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener, AdapterView.OnItemSelectedListener {

    var value = 0
    var dynamicEnabled = false
    var maxLimitValue = 1000
    var dTokenValue = 0;
    var dTokenTime : String = ""
    var dTokenLatLng : LatLng? = null

    val walletRepository = WalletRepository
    val dTokenRepository = DTokenRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ndtoken_activity)

        limit_bar.setOnSeekBarChangeListener(this)
        limit_bar.max = walletRepository.value.toInt()

        val times = resources.getStringArray(R.array.times)
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, times)
        spinner!!.setAdapter(aa)

        bt_create_dtoken.setOnClickListener(View.OnClickListener {
            save()
        })

        val sourceOp : ArrayList<String> = arrayListOf<String>("Conta","Cartão 1", "Cartão 2")
        val ab = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, sourceOp)
        source!!.setAdapter(ab)
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        dTokenValue = progress
        limit_txt.text = "$"+dTokenValue;
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        //limit_txt.text = "$"+dTokenValue;
  }
    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        //dTokenTime = spinner.selectedItem.toString()
    }

    fun save() {
        var dToken = DToken()
        dToken.dynamicLimit = dynamicEnabled
        dToken.value = dTokenValue.toDouble()
        dToken.location = dTokenLatLng
        dToken.time = spinner.selectedItem.toString()

        if(source.selectedItemPosition == 0) {
            walletRepository.debit(dTokenValue.toDouble())
        }

        dTokenRepository.save(dToken)

        finish()

    }


}