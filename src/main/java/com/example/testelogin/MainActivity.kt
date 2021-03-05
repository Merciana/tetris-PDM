package com.example.testelogin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.testelogin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   lateinit var binding: ActivityMainBinding
    //lateinit  var viewmodel:MainActivityModelView

    lateinit var novojogoButton: Button
    lateinit var continuarButton: Button
    lateinit var configurationButton: Button
    //lateinit var tetrisEditText: EditText
    lateinit  var resultadoTextView : TextView

    val MY_REQUEST_CODE = 99

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =  DataBindingUtil.setContentView ( this,R.layout.activity_main)
        //viewmodel =  ViewModelProvider ( this ) .get ( MainActivityViewModel::class .java)

        //binding.viewmodel = viewmodel
        binding.lifecycleOwner =  this

       // R.drawable.Tetris4
        setContentView(R.layout.activity_main)

        novojogoButton = findViewById(R.id.novojogo)
        continuarButton = findViewById(R.id.continuar)
        configurationButton = findViewById(R.id.configuracao)


        configurationButton.setOnClickListener {
            var i = Intent(this, ActivityRecebe::class.java)
            val param = Bundle ()
            param.putString ("TEXTO", resultadoTextView.text.toString ())
            param.putDouble ("VALOR", 20.0)
            param.putString ("TETRIS", "PDM")
            i.putExtras (param)
            startActivityForResult(i, MY_REQUEST_CODE)
        }
        novojogoButton.setOnClickListener {
            var i = Intent(this, ActivityJogo::class.java)
            val param = Bundle()
            param.putString ("TEXTO", resultadoTextView.text.toString ())
            param.putDouble ("VALOR", 20.0)
            param.putString ("TETRIS", "PDM")
            i.putExtras (param)
            startActivityForResult(i, MY_REQUEST_CODE)
        }

        val botao:Button = findViewById(R.id.novojogo)
        botao.setOnClickListener {
            Toast.makeText(this, "Carregando...", Toast.LENGTH_SHORT).show()
            Log.i("PDM", "Jogo sendo iniciado")
        }
    }

        override fun onStart () {
            Log.i ("AULA", "onStart () invocado.")
            super.onStart ()
        }

        override fun onResume () {
            Log.i ("AULA", "onResume () invocado.")
            super.onResume ()
        }

        override fun onPause () {
            Log.i ("AULA", "onPause () invocado.")
            super.onPause ()
        }

        override fun onRestart () {
            Log.i ("AULA", "onRestart () invocado.")
            super.onRestart ()
        }

        override fun onStop () {
            Log.i ("AULA", "onStop () invocado.")
            super.onStop ()
        }

        override fun onDestroy () {
            Log.i ("AULA", "onDestroy () invocado.")
            super.onDestroy ()
        }

        override fun onActivityResult (requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult (requestCode, resultCode, data)
            Log.i ("AULA", "Código de resquest = $ requestCode, código de resultado = $ resultCode")
            when (requestCode) {
                MY_REQUEST_CODE->{
                when (resultCode) {
                    Activity.RESULT_OK-> {
                        val param = data?.extras
                        val textoResultado = param?.getString("DADOS_RESPOSTA")
                        Toast.makeText(this, " $textoResultado ", Toast.LENGTH_SHORT).show()
                    }
                    Activity.RESULT_CANCELED->{
                        Toast.makeText(this, "Alteração NÃO salva", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            }
        }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }

}





