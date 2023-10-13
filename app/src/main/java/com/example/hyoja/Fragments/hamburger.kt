 package com.example.hyoja.Fragments

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.GridLayout
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.hyoja.R


 class hamburger : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_hamburger, container, false)
//        val setMenuView = inflater.inflate(R.layout.dialog_show_set_or_one, container, false)

        rootView.findViewById<View>(R.id.burger1).setOnClickListener {
            showBurgerDetailsDialog(R.drawable.burger1)
        }

        rootView.findViewById<View>(R.id.burger2).setOnClickListener {
            showBurgerDetailsDialog(R.drawable.burger2)
        }

        rootView.findViewById<View>(R.id.burger3).setOnClickListener {
            showBurgerDetailsDialog(R.drawable.burger3)
        }

        rootView.findViewById<View>(R.id.burger4).setOnClickListener {
            showBurgerDetailsDialog(R.drawable.burger4)
        }

        rootView.findViewById<View>(R.id.burger5).setOnClickListener {
            showBurgerDetailsDialog(R.drawable.burger5)
        }

        rootView.findViewById<View>(R.id.burger6).setOnClickListener {
            showBurgerDetailsDialog(R.drawable.burger6)
        }

        return rootView
    }

    private fun showBurgerDetailsDialog(imageResId: Int) {

        val dialogView = layoutInflater.inflate(R.layout.dialog_show_set_or_one, null)
        dialogView.setBackgroundColor(Color.TRANSPARENT);

        // 다이얼로그 뷰에 내용 설정
//        dialogView..setImageResource(imageResId)
//        dialogView.dialog_burger_name.text = burgerName
//        dialogView.dialog_burger_price.text = "가격: $burgerPrice"

        // AlertDialog를 생성하고 설정
        val alertDialogBuilder = AlertDialog.Builder(requireContext())
        alertDialogBuilder.setView(dialogView)

        // 다이얼로그를 표시
        val alertDialog = alertDialogBuilder.create()

        // 다이얼로그 외부를 터치해도 닫히지 않도록 설정
        alertDialog.setCanceledOnTouchOutside(false)

        // "X" 버튼 클릭 시 다이얼로그 닫기
        val closeButton = dialogView.findViewById<ImageView>(R.id.dialog_x_button)
        closeButton.setOnClickListener {
            alertDialog.dismiss()
        }

        val onlyBurger = dialogView.findViewById<GridLayout>(R.id.only_burger_grid)
        onlyBurger.setOnClickListener {
            alertDialog.dismiss()
        }

        val setBurger = dialogView.findViewById<GridLayout>(R.id.set_grid)
        setBurger.setOnClickListener {
            alertDialog.dismiss()
            Log.d("burger","burger button")
            showSetMenuChoiceDialog(imageResId)
        }

        alertDialog.show()
    }

    private fun showSetMenuChoiceDialog(imageResId: Int){
        val dialogView = layoutInflater.inflate(R.layout.dialog_set_menu_choice, null)
//        val dialogView = layoutInflater.inflate(R.layout.activity_fastfood_home2, null)
        dialogView.setBackgroundColor(Color.TRANSPARENT);

        // AlertDialog를 생성하고 설정
        val alertDialogBuilder = AlertDialog.Builder(requireContext())
        alertDialogBuilder.setView(dialogView)

        // 다이얼로그를 표시
        val alertDialog = alertDialogBuilder.create()


        val cancalButton = dialogView.findViewById<View>(R.id.setmenu_cancel_button)
        cancalButton.setOnClickListener {
            alertDialog.dismiss()
        }

        //다이얼로그 크기 조정
//        val width = (resources.displayMetrics.widthPixels * 0.96).toInt()
//        val height = WindowManager.LayoutParams.WRAP_CONTENT
//
//        val window = alertDialog.window
//        val layoutParams = window?.attributes
//        layoutParams?.width = width
//        layoutParams?.height = height
//        window?.attributes = layoutParams

        // 다이얼로그 외부를 터치해도 닫히지 않도록 설정
        alertDialog.setCanceledOnTouchOutside(false)

        alertDialog.show()

    }
}