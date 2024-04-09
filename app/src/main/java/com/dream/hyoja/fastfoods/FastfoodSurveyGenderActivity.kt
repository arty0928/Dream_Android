package com.dream.hyoja.fastfoods

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dream.hyoja.R
import com.dream.hyoja.databinding.ActivityFastFoodSurveyGenderBinding
import com.dream.hyoja.databinding.ActivitySurveyGenderBinding

class FastfoodSurveyGenderActivity : AppCompatActivity() {

    private val Tag : String = " FastFoodSurveyGenderActivity"

    //Binding 선언
    lateinit var binding : ActivityFastFoodSurveyGenderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFastFoodSurveyGenderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.surveyGenderFemaleBtn.setOnClickListener {

        }

        binding.surveyGenderMaleBtn.setOnClickListener{

        }

    }
}