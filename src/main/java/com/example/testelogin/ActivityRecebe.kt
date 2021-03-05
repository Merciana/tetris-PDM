package com.example.testelogin

import  android.app.Activity
import  android.content.Intent
import  androidx.appcompat.app.AppCompatActivity
import  android.os.Bundle
import  android.widget.Button
import  android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.testelogin.databinding.ActivityRecebeBinding

class  ActivityRecebe : AppCompatActivity () {

    private lateinit  var binding:ActivityRecebeBinding

    lateinit  var voltarButton:Button

    override fun  onCreate (savedInstanceState :  Bundle ? ) {
        super .onCreate (savedInstanceState)
        setContentView ( R .layout.activity_recebe)

        binding = DataBindingUtil.setContentView ( this , R .layout.activity_recebe)

        voltarButton = findViewById ( R .id.Voltar)

        voltarButton.setOnClickListener {
            val i =  Intent ()
            i.putExtra ( " DADOS_RESPOSTA " , "Alteração Salva" )
            setResult ( Activity . RESULT_OK , i)
            finish()
        }
    }
    override  fun  onStop () {
        super .onStop ()
    }
}