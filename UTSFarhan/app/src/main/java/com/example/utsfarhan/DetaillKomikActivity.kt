package com.example.utsfarhan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.utsfarhan.fragment.UntukmuFragment

class DetaillKomikActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_detaill_komik_activity)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val komik = intent.getParcelableExtra<Komik>(UntukmuFragment.INTENT_PARCELABLE)

        val imgDetail = findViewById<ImageView>(R.id.ivPhoto)
        val nameKomik = findViewById<TextView>(R.id.tvJudul)
//        val descKomik = findViewById<TextView>(R.id.tvDesc)

        imgDetail.setImageResource(komik?.imgDetail!!)
        nameKomik.text = komik.nameKomik
//        descKomik.text = komik.descKomik
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}