package com.vcarart.digimondex.ui.digimonInfo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.vcarart.digimondex.R
import kotlinx.android.synthetic.main.activity_digimoninfo.*

class DigimonInfoActivity : AppCompatActivity() {

    lateinit var viewModel: DigimonInfoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_digimoninfo)

        viewModel = ViewModelProvider(this).get(DigimonInfoViewModel::class.java)

        initUI()
    }

    @SuppressLint("SetTextI18n")
    private fun initUI(){
        val id = intent.extras?.get("id") as Int

        viewModel.getDigimonInfo(id)

        viewModel.digimonInfo.observe(this, Observer { digimon ->
            idText.text = digimon.id
            nameText.text = "Nombre: " + digimon.name
            if(digimon.types.isNotEmpty()){
                typeText.text = "Tipo: " + digimon.types[0].type
            }
            if(digimon.attributes.isNotEmpty()){
                attributeDigiText.text = "Atributo: " + digimon.attributes[0].attribute
            }
            if(digimon.images.isNotEmpty()){
                Glide.with(this).load(digimon.images[0].href).into(imageView)
            }

        })
    }
}