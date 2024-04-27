package com.example.simpleapicall

import android.app.ProgressDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.simpleapicall.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

      findViewById<Button>(R.id.btnmeme).setOnClickListener {
          findViewById<LinearLayout>(R.id.ll_progress).visibility= View.VISIBLE
          getdata()
      }

    }

    private fun getdata() {

        Retrofitobject.apiservice.getdata().enqueue(object : Callback<responseDataclass?> {
            override fun onResponse(
                call: Call<responseDataclass?>,
                response: Response<responseDataclass?>
            ) {
                findViewById<LinearLayout>(R.id.ll_progress).visibility=View.GONE
                findViewById<TextView>(R.id.memeTitle).text=response.body()?.title


                Glide.with(this@MainActivity2).load(response.body()?.url).into(findViewById(R.id.memeImg) );


            }

            override fun onFailure(call: Call<responseDataclass?>, t: Throwable) {
                Toast.makeText(this@MainActivity2,"${t.localizedMessage}",Toast.LENGTH_LONG)
                    .show()
                findViewById<LinearLayout>(R.id.ll_progress)

            }
        })
    }

}


