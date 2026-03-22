package com.example.homepage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.homepage.databinding.ActivityMainBinding
import com.example.homepage.ui.home_page

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Carregar o fragment inicial
        if (savedInstanceState == null) {
            replaceFragment(home_page())
        }

        //Onde vai implementar as telas do menu
        //Por exemplo:
        //R.id.explorar -> replaceFragment(fragmento1()) significa que o botão com id "explorar"
        //vai direcionar a um fragment "fragmento1"

        /*
            binding.bottomNavigationView.setOnItemSelectedListener {
                when(it.itemId){
                    R.id.explorar -> replaceFragment(fragmento1())
                    R.id.home -> replaceFragment(fragmento2())
                    R.id.fav -> replaceFragment(fragmento2())

                    else ->{

                    }
                }
                true
            }
        */
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}