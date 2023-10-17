package com.example.hyoja.cafe.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.hyoja.R
import com.example.hyoja.cafe.model.CafeModel
import com.example.hyoja.cafe.model.Coffee5
import com.example.hyoja.cafe.model.Coffee6
import com.example.hyoja.cafe.model.Coffee7
import com.example.hyoja.cafe.model.Coffee8
import com.example.hyoja.cafe.model.DrinkDataInterface
import com.example.hyoja.cafe.model.NewMenu1
import com.example.hyoja.cafe.model.NewMenu2
import com.example.hyoja.cafe.model.NewMenu3
import com.example.hyoja.cafe.model.NewMenu4
import com.example.hyoja.cafe.model.NewMenu5
import com.example.hyoja.cafe.model.NewMenu6
import com.example.hyoja.cafe.model.NewMenu7
import com.example.hyoja.cafe.model.NewMenu8
import com.example.hyoja.cafe.model.Ready
import com.example.hyoja.cafe.viewmodel.MenuListViewModel
import com.example.hyoja.databinding.FragmentDrinkListNewMenuOneBinding
import com.example.hyoja.databinding.FragmentDrinkListNewMenuTwoBinding

// 나중에 하실분께 죄송... 처음하고 계획이 달라져서 이름이 이렇게 되었습니다.
class DrinkListNewMenuTwoFragment : Fragment() {
    lateinit var binding: FragmentDrinkListNewMenuTwoBinding
    private lateinit var viewModel: MenuListViewModel

    //음료버튼에 들어갈 음료들의 정보를 받는 변수
    lateinit var drinkData5: DrinkDataInterface
    lateinit var drinkData6: DrinkDataInterface
    lateinit var drinkData7: DrinkDataInterface
    lateinit var drinkData8: DrinkDataInterface

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val Tag:String = "DrinkListNewMenuTwoFragment"

        //뷰모델을 이용한 옵저버 패턴
        viewModel = ViewModelProvider(requireActivity())[MenuListViewModel::class.java]
        viewModel.categoryLiveData.observe(viewLifecycleOwner, Observer {
            Log.d(Tag,"categoryLiveData observe")
            checkDrinkCategory(it)
            setUI()
        })

        // 믿기지 않겠지만 newMenu가 버튼 이름입니다.
        // 5번 음료버튼
        binding.newMenu5.setOnClickListener{
            CafeModel.drinkSelected = "newMenu5"
            viewModel.drinkSelectChanged()
            Log.d(Tag,"drinkSelected= "+ CafeModel.drinkSelected)
        }
        // 6번 음료 버튼
        binding.newMenu6.setOnClickListener{
            CafeModel.drinkSelected = "newMenu6"
            viewModel.drinkSelectChanged()
            Log.d(Tag,"drinkSelected= "+ CafeModel.drinkSelected)
        }
        // 7번 음료 버튼
        binding.newMenu7.setOnClickListener{
            CafeModel.drinkSelected = "newMenu7"
            viewModel.drinkSelectChanged()
            Log.d(Tag,"drinkSelected= "+ CafeModel.drinkSelected)
        }
        // 8번 음료 버튼
        binding.newMenu8.setOnClickListener{
            CafeModel.drinkSelected = "newMenu8"
            viewModel.drinkSelectChanged()
            Log.d(Tag,"drinkSelected= "+ CafeModel.drinkSelected)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDrinkListNewMenuTwoBinding.inflate(inflater, container, false)

        //처음 create할떄는 newMenu로
        drinkData5 = NewMenu5()
        drinkData6 = NewMenu6()
        drinkData7 = NewMenu7()
        drinkData8 = NewMenu8()

        setUI()

        return binding.root
    }

    fun checkDrinkCategory(category: String){
        when(category){
            "newMenu" -> {
                drinkData5 = NewMenu5()
                drinkData6 = NewMenu6()
                drinkData7 = NewMenu7()
                drinkData8 = NewMenu8()
            }
            "coffee" -> {
                drinkData5 = Coffee5()
                drinkData6 = Coffee6()
                drinkData7 = Coffee7()
                drinkData8 = Coffee8()
            }
            else ->{
                drinkData5 = Ready()
                drinkData6 = Ready()
                drinkData7 = Ready()
                drinkData8 = Ready()
            }

        }
    }
    fun setUI(){
        binding.newMenu5Image.setImageResource(drinkData5.drinkImage)
        binding.newMenu5Name.text = drinkData5.name
        binding.newMenu5Price.text = drinkData5.price.toString()

        binding.newMenu6Image.setImageResource(drinkData6.drinkImage)
        binding.newMenu6Name.text = drinkData6.name
        binding.newMenu6Price.text = drinkData6.price.toString()

        binding.newMenu7Image.setImageResource(drinkData7.drinkImage)
        binding.newMenu7Name.text = drinkData7.name
        binding.newMenu7Price.text = drinkData7.price.toString()

        binding.newMenu8Image.setImageResource(drinkData8.drinkImage)
        binding.newMenu8Name.text = drinkData8.name
        binding.newMenu8Price.text = drinkData8.price.toString()
    }

}