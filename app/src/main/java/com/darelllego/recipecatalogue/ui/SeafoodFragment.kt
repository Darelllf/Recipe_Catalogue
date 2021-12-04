package com.darelllego.recipecatalogue.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.darelllego.recipecatalogue.R
import com.darelllego.recipecatalogue.adapter.RecipesAdapter
import com.darelllego.recipecatalogue.data.Recipes
import com.darelllego.recipecatalogue.databinding.FragmentSeafoodBinding


class SeafoodFragment : Fragment() {

    private lateinit var _binding: FragmentSeafoodBinding
    private val binding get() = _binding

    private var listRecipes: ArrayList<Recipes> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSeafoodBinding.inflate(layoutInflater, container, false)
        initData()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvSeafood.apply {
            layoutManager = GridLayoutManager(activity, 2)
            adapter = RecipesAdapter(listRecipes)
        }
    }

    private fun initData() {
        activity?.resources?.apply {
            val name = getStringArray(R.array.name_seafood)
            val category = getStringArray(R.array.category_seafood)
            val description = getStringArray(R.array.description_seafood)
            val ingredients = getStringArray(R.array.ingredients_seafood)
            val instructions = getStringArray(R.array.instructions_seafood)
            val photo = getStringArray(R.array.photo_seafood)
            val price = getStringArray(R.array.price_seafood)
            val calories = getStringArray(R.array.calories_seafood)
            val carbo = getStringArray(R.array.carbo_seafood)
            val protein = getStringArray(R.array.protein_seafood)

            for (data in protein.indices) {
                val seafood = Recipes(
                     name[data],
                    category[data],
                    description[data],
                    ingredients[data],
                    instructions[data],
                    photo[data],
                    price[data],
                    calories[data],
                    carbo[data],
                    protein[data]
                )
                listRecipes.add(seafood)
            }
        }
    }

}