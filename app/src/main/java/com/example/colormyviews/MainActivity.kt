package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding =  DataBindingUtil.setContentView(this, R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        binding.apply {
            val clickableViews: List<View> =
                listOf(
                    boxOneText, boxTwoText, boxThreeText,
                    boxFourText, boxFiveText, constraintLayout,
                    greenButton, yellowButton, redButton,
                )
            invalidateAll()
            for (item in clickableViews) {
                item.setOnClickListener { makeColored(it)}
            }
        }


    }

    private fun makeColored(view: View) {
        when(view.id) {
            // Boxes using Color class colors for background
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)
//            R.id.green_button -> boxFiveText.setBackgroundResource(android.R.color.holo_green_light)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}
