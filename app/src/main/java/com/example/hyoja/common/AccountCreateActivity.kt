package com.example.hyoja.common

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hyoja.common.util.CommonUi
import com.example.hyoja.common.util.api.RetrofitUtil
import com.example.hyoja.databinding.ActivityAccountCreateBinding

class AccountCreateActivity : AppCompatActivity() {
    lateinit var binding: ActivityAccountCreateBinding
    val commonUi = CommonUi()
    lateinit var id: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val view = this

        //로고 누르면 처음으로
        binding.hyojaLogo.setOnClickListener {
            commonUi.goToLogin(view)
        }
        binding.hyojaText.setOnClickListener {
            commonUi.goToLogin(view)
        }

        binding.accountStartButton.setOnClickListener{
            //회원가입 성공해야 넘어갈 수 있음
            if(createUser()){

                commonUi.goToHome(view)
                finish() // 뒤로 다시 들어오지 못하게 종료해주세요
            }

        }
    }

    private fun createUser():Boolean{
        val id = ""
        val name = binding.name.text.toString()
        val password:String = binding.password.text.toString()
        val confirm = binding.confirm.text.toString()

        return if (password == confirm){
            this.id = RetrofitUtil().createUser(id, password, name)

            val sharedPreferences = getSharedPreferences("HyoJaPreference", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("ID", id)
            editor.putString("PassWord", password)
            editor.apply()
            true
        } else{
            this.id = "fail"
            Toast.makeText(this@AccountCreateActivity,"비밀번호를 다시 확인해주세요",Toast.LENGTH_SHORT).show()
            false
        }
    }
}