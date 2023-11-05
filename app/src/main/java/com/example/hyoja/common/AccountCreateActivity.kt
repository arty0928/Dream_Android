package com.example.hyoja.common

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hyoja.common.util.CommonUi
import com.example.hyoja.common.util.api.RetrofitUtil
import com.example.hyoja.databinding.ActivityAccountCreateBinding

class AccountCreateActivity : AppCompatActivity() {
    lateinit var binding: ActivityAccountCreateBinding
    val commonUi = CommonUi()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val view = this

        RetrofitUtil().createUser("","","")

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
            RetrofitUtil().createUser(id, password, name )
            true
        } else{
            Toast.makeText(this@AccountCreateActivity,"비밀번호를 다시 확인해주세요",Toast.LENGTH_SHORT).show()
            false
        }
    }
}