package com.dream.hyoja.common.util

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.dream.hyoja.R

@SuppressLint("StaticFieldLeak")
object ManualStepChecker{
    // 튜토리얼을 시작하는 boolean
    var first = false
    // 여기서 애니메이션을 사용하기 위한 context
    private lateinit var runningContext: Context
    // 버튼을 저장
    private var stepButtonArray = ArrayList<View>()
    // step들을 넣는 공간
    private var stepArray = ArrayList<Boolean>()
    // 현재 스텝
    var position = 0
    var size = 0

    fun contextSetting(context: Context){
        // 새로운 환경이기 때문에 clear를 해줘야한다.
        stepButtonArray.clear()
        stepArray.clear()
        // context세팅
        runningContext = context
    }

    fun setView(view: View){
        stepButtonArray.add(view)
        stepArray.add(false)
    }

    fun checkStep(step: Int): Boolean {
        var stepBoolean = true
        for (i in 0 until step){
            stepBoolean = stepBoolean and stepArray[i]
        }
        stepBoolean = stepBoolean and first
        Log.d("step",stepBoolean.toString())

        return stepBoolean
    }

    fun clickCallback(){
        if(position == 0){
            startBlink(position)
        }
        else{
            completeStep(position)
            cancelBlink(position)
            startBlink(position)
        }
    }

    private fun startBlink(position: Int){
        val buttonAnim: Animation = AnimationUtils.loadAnimation(runningContext, R.anim.blink)
    }

    private fun cancelBlink(position: Int){

    }

    private fun completeStep(position: Int){

    }

}