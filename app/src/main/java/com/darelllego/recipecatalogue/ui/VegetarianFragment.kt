package com.darelllego.recipecatalogue.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.darelllego.recipecatalogue.adapter.RecipesAdapter
import com.darelllego.recipecatalogue.data.DataRecipes
import com.darelllego.recipecatalogue.databinding.FragmentVegetarianBinding

class VegetarianFragment : Fragment() {


    private var _binding: FragmentVegetarianBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentVegetarianBinding.inflate(inflater, container, false)

        binding.rvVegetarian.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity, 2)
            adapter = RecipesAdapter(DataRecipes.listVegetarian)
        }


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}