package com.movile.moviletoken.main

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.movile.moviletoken.R
import com.movile.moviletoken.dtoken.DTokenAdapter
import com.movile.moviletoken.dtoken.NewDTokenActivity
import com.movile.moviletoken.repository.DTokenRepository
import com.movile.moviletoken.repository.WalletRepository
import com.movile.moviletoken.utilities.NetworkUtils
import kotlinx.android.synthetic.main.token_fragment.*
import org.jetbrains.anko.doAsync


class TokenFragment : Fragment() {

    val dTokenRepository : DTokenRepository = DTokenRepository
    val walletRepository : WalletRepository = WalletRepository

    var server : Boolean = true

    val handler: Handler =  Handler()
    var progressStatus = 100
    val progressThread : Thread = Thread(Runnable {
        while (progressStatus > 0) {
            progressStatus -= 1
            handler.post(Runnable {
                token_progress_bar.setProgress(progressStatus, true)
            })
            Thread.sleep(300)
        }

        progressStatus = 100
        loadToken()
    })

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.token_fragment, container, false)
        return v
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bt_create_token.setOnClickListener(View.OnClickListener {
            startActivity(Intent(activity, NewDTokenActivity::class.java))
        })

        token_progress_bar.max = progressStatus
        token_progress_bar.isIndeterminate = true
        token_progress_bar.getProgressDrawable().setColorFilter(
            Color.WHITE, android.graphics.PorterDuff.Mode.SRC_IN)

        static_token_list.layoutManager = LinearLayoutManager(activity)


    }

    fun loadToken() {
        val url = NetworkUtils.getURL("http://10.98.0.170:8000/obter-token/8.060554,34.871832")
        //ServeTask().execute(url)
        Log.d("MAIN2","requitando ")



         doAsync {
                                    //Execute all the lon running tasks here

                   /*Log.d("MAIN2","teste ")
                   val s: String = NetworkUtils.getResponseFromHttpUrl(url)
                   uiThread {
                        Log.d("MAIN2","result "+s)
                             if (TextUtils.isEmpty(s)) {
                                JSONObject j = Jso
                             }

                             if(server) {
                                 loadToken()
                             }
                        }
                   }*/
         }
    }

    override fun onStop() {
        super.onStop()
        server = false

    }

    override fun onResume() {
        super.onResume()

        server =true
        loadData()
        loadToken()

    }

    companion object {
        fun newInstance(): TokenFragment = TokenFragment()
    }

    fun loadData() {
        simbol.text = "$"
        value.text = walletRepository.value.toString()
        dynamic_token.text = walletRepository.getToken()

        static_token_list.adapter = DTokenAdapter(activity!!.application, dTokenRepository.getAllDToken())
    }


    /*class ServeTask : AsyncTask<URL, Void, String>() {
        override fun doInBackground(vararg params: URL?): String {

            val moviesUrl = params[0]
            var moviesResults: String = ""
            try {
                moviesResults = NetworkUtils.getResponseFromHttpUrl(moviesUrl)
            } catch (e: IOException) {
                e.printStackTrace()
            }

            return moviesResults

        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

            if (!TextUtils.isEmpty(result)) {
                try {
                    val token = JSONObject(result)

                } catch (e : JSONException) {

                }

                Log.d("MAIN","result : "+result)

            }
        }

        override  fun onCancelled() {
            super.onCancelled()
        }

    }*/

}