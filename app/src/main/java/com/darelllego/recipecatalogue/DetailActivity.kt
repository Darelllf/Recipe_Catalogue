package com.darelllego.recipecatalogue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.darelllego.recipecatalogue.data.Recipes
import com.darelllego.recipecatalogue.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object{
        const val DATA_RECIPES = "data"

    }    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarDetail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val data = intent.getParcelableExtra<Recipes>(DATA_RECIPES) as Recipes

        binding.apply {
            Glide.with(applicationContext).load(data.photo).into(imgDetail)
            tvNameDetail.text = data.name
            tvCalories.text = data.calories
            tvCarbo.text = data.carbo
            tvProtein.text = data.protein
            tvDescription.text = data.description
            tvIngredientsDetail.text = data.ingredients
            tvDirectionsDetail.text = data.instructions

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}