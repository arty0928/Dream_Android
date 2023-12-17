package com.dream.hyoja.common.util

object ManualStepChecker{
    var cafeForHereStep = false // 0
    var cafeRightStep = false // 1
    var cafeLeftStep = false // 2
    var cafeRightDrinkStep = false // 3
    var cafeLeftDrinkStep = false // 4
    var cafeDrinkSelectStep = false // 5
    var selectCompleteStep = false //6

    private var cafeStepArray = ArrayList<Boolean>().apply {
        add(cafeForHereStep)
        add(cafeRightStep)
        add(cafeLeftStep)
        add(cafeRightDrinkStep)
        add(cafeLeftDrinkStep)
        add(cafeDrinkSelectStep)
        add(selectCompleteStep)
    }


    fun checkStep(step: Int): Boolean {
        var stepBoolean = true
        for (i in 0 until step){
            stepBoolean = stepBoolean and cafeStepArray[i]
        }

        return stepBoolean
    }
}