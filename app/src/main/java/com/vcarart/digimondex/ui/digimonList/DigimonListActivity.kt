package com.vcarart.digimondex.ui.digimonList

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.vcarart.digimondex.R
import com.vcarart.digimondex.ui.digimonInfo.DigimonInfoActivity
import kotlinx.android.synthetic.main.activity_digimonlist.*

class DigimonListActivity : AppCompatActivity() {
    
    private lateinit var viewModel: DigimonListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_digimonlist)

        viewModel = ViewModelProvider(this).get(DigimonListViewModel::class.java)

        initUI()
    }

    private fun initUI(){
        pokelistRecyclerView.layoutManager = LinearLayoutManager(this)
        pokelistRecyclerView.adapter = DigimonListAdapter{
            val intent = Intent(this, DigimonInfoActivity::class.java)
            intent.putExtra("id", it)
            startActivity(intent)
        }

        viewModel.getPokemonList()

        viewModel.pokemonList.observe(this, Observer { list ->
            (pokelistRecyclerView.adapter as DigimonListAdapter).setData(list)
        })
    }
}