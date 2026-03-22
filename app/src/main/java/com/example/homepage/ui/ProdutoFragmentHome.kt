package com.example.homepage.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.homepage.R
import com.example.homepage.ui.adapter.MyPagerAdapterHome

class ProdutoFragmentHome : Fragment(R.layout.fragment_produto_home) {

    private lateinit var viewPager: ViewPager2
    private lateinit var dotIndictor: LinearLayout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializa as Views
        viewPager = view.findViewById(R.id.viewPagerProdutos) // Verifique se o ID bate com o XML
        dotIndictor = view.findViewById(R.id.tabDots)       // Verifique se o ID bate com o XML

        // Lista de imagens (IDs do drawable)
        val items = listOf(
            R.drawable.panela_home,
            R.drawable.passaro_croche,
            R.drawable.escultura_preguica
        )

        // Configura o Adapter
        val adapter = MyPagerAdapterHome(items)
        viewPager.adapter = adapter

        // Cria as bolinhas (dots)
        setupDotIndictor(items.size)

        // Listener para mudar a cor da bolinha quando arrastar o carrossel
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updateIndicator(position)
            }
        })
    }

    private fun setupDotIndictor(count: Int) {
        dotIndictor.removeAllViews() // Garante que não duplique ao recriar a view
        for (i in 0 until count) {
            val dot = ImageView(requireContext())
            dot.setImageResource(R.drawable.dot_selector)

            // Adiciona uma margem entre as bolinhas
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(8, 0, 8, 0)
            }

            dot.layoutParams = params
            dotIndictor.addView(dot)
        }
        updateIndicator(0) // Começa na primeira
    }

    private fun updateIndicator(position: Int) {
        for (i in 0 until dotIndictor.childCount) {
            val dot = dotIndictor.getChildAt(i) as ImageView
            dot.isSelected = (i == position)
        }
    }
}