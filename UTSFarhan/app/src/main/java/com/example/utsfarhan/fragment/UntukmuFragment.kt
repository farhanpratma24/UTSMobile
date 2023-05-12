package com.example.utsfarhan.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.utsfarhan.R
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.utsfarhan.DetaillKomikActivity
import com.example.utsfarhan.Komik
import com.example.utsfarhan.komikAdapter

class UntukmuFragment : Fragment() {
    private lateinit var adapter: komikAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var komikArrayList: ArrayList<Komik>

    lateinit var image: Array<Int>
    lateinit var detailimage: Array<Int>
    lateinit var title: Array<String>
    lateinit var description: Array<String>
    lateinit var chapter: Array<String>

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_untukmu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_komik)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = context?.let {
            komikAdapter(it, komikArrayList){
                val intent = Intent(context, DetaillKomikActivity::class.java)
                intent.putExtra(INTENT_PARCELABLE, it)
                startActivity(intent)
            }
        }

    }
    private fun dataInitialize(){
        komikArrayList = arrayListOf<Komik>()

        detailimage = arrayOf(
            R.drawable.gambar1,
            R.drawable.gambar2,
            R.drawable.gambar3,
            R.drawable.gambar4,
            R.drawable.gambar5,
            R.drawable.gambar6,
            R.drawable.gambar7,
            R.drawable.gambar8,
            R.drawable.gambar9,
            R.drawable.gambar10,
        )

        image = arrayOf(
            R.drawable.gambar1,
            R.drawable.gambar2,
            R.drawable.gambar3,
            R.drawable.gambar4,
            R.drawable.gambar5,
            R.drawable.gambar6,
            R.drawable.gambar7,
            R.drawable.gambar8,
            R.drawable.gambar9,
            R.drawable.gambar10,
        )

        title = arrayOf(
            "kaka",
            "Van basten",
            "Gunnar Nordahl",
            "Mauro Tassotti",
            "Andriy Shevchenko",
            "Alessandro Costacurta",
            "Gianni Rivera",
            "Paolo Maldini",
            "Franco Baresi",
            "Farhan pratama",

            )

        description = arrayOf(
            "Ricardo Izecson dos Santos Leite adalah nama lengkapnya. Dunia mengenalnya dengan nama Kaka.",
            "Marco Van Basten adalah satu di antara pemain hebat yang pernah ada.",
            "Nordahl dianggap sebagai salah satu pemain terbaik dalam sejarah sepak bola Swedia.",
            "Mauro Tassotti bermain untuk AC Milan selama 17 tahun.",
            "satu di antara striker paling hebat dalam sejarah AC Milan.",
            "bek sentral tangguh dan merupakan salah satu jebolan terbaik akademi AC Milan.",
            "bek sentral tangguh dan merupakan salah satu jebolan terbaik akademi AC Milan.",
            "satu di antara pemain paling loyal dalam sejarah AC Milan. ",
            "satu di antara bek terbaik dalam sejarah sepak bola dunia.",
            "Pemain berdarah campuran Indonesia dan surga. Memiliki stamina dan power di luar nalar, bahkan bahkan pelatih legendaris seperti johan cruffj juga mengakui ke lihain dalam mengocek bola bunda, namun sayang nya di memutuskan untuk pensiun dini agar memberi pentas persaigan kepada mesi dan Ronaldo, ",
        )

        chapter = arrayOf(
            "Chapter 2",
            "Chapter 5",
            "Chapter 4",
            "Chapter 2",
            "Chapter 6",
            "Chapter 3",
            "Chapter 5",
            "Chapter 4",
            "Chapter 4",
            "Chapter 5",
        )
        for (i in image.indices){
            val komik = Komik(image[i], title[i], description[i], detailimage[i], chapter[i],)
            komikArrayList.add(komik)
        }
    }


}