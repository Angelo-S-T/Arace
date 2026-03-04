package com.example.homepage

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.homepage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Onde vai implementar as telas do menu
        //Por exemplo:
        //R.id.explorar -> replaceFragment(fragmento1()) significa que o botão com id "explorar"
        //vai direcionar a um fragment "fragmento1"


        /*!replaceFragment(Home())

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

        }


    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }*/
    }
}