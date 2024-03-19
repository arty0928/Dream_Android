import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dream.hyoja.databinding.ActivityFastfoodHome2Binding
import com.dream.hyoja.databinding.FragmentFoodAddedBinding
import com.dream.hyoja.fastfoods.model.FastFoodModel
import com.dream.hyoja.fastfoods.util.ApplyFoodOrderList

class FoodOrderedListAdapter(private val binding: ActivityFastfoodHome2Binding) :
    RecyclerView.Adapter<FoodOrderedListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder =
        ViewHolder(
            FragmentFoodAddedBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = FastFoodModel.foodSelectedList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.binding.selectedItemName.text = FastFoodModel.foodSelectedList[position].food.name.toString()
        holder.binding.selectedItemPrice.text = FastFoodModel.foodSelectedList[position].totalPrice.toString()
        holder.binding.selectedItemCount.text = FastFoodModel.foodSelectedList[position].foodCount.toString()

//        토핑 추가
//        if(FastFoodModel.foodSelectedList[position].category == "Dessert" ||FastFoodModel.foodSelectedList[position].category == "Drink"){
//            holder.binding.selectedItemAddToping.visibility = View.INVISIBLE
//        }

        // itemPlus 버튼 클릭 시
        holder.binding.plusItem.setOnClickListener {
            FastFoodModel.foodSelectedList[position].foodCount++
            holder.setFoodCount(position)

            val setPrice = (FastFoodModel.foodSelectedList[position].totalPrice) * FastFoodModel.foodSelectedList[position].foodCount

            holder.setFoodPrice(position,setPrice)
            updateTotalOrderCount()

        }
        holder.binding.miusItem.setOnClickListener {
            if(FastFoodModel.foodSelectedList[position].foodCount>1){
                FastFoodModel.foodSelectedList[position].foodCount--
                holder.setFoodCount(position)

                val setPrice = (FastFoodModel.foodSelectedList[position].totalPrice) * FastFoodModel.foodSelectedList[position].foodCount

                holder.setFoodPrice(position,setPrice)
                updateTotalOrderCount()

            }

        }
        holder.binding.selectItemDelete.setOnClickListener {

            FastFoodModel.foodSelectedList.removeAt(position)
            Log.d("deleteItem",FastFoodModel.foodSelectedList.toString())
            val (count, price) = updateTotalOrderCount()

            binding.TotalOrderCount.text = count.toString()
            binding.TotalOrderPrice.text = price.toString()

            holder.deleteItem(position)
        }
    }

    private fun updateTotalOrderCount() : Pair<Int,Int>{

        var sumCount = 0
        var sumPrice = 0

        for (i in 0..FastFoodModel.foodSelectedList.size-1){
            sumCount += FastFoodModel.foodSelectedList[i].foodCount
            sumPrice += FastFoodModel.foodSelectedList[i].foodCount * FastFoodModel.foodSelectedList[i].totalPrice
        }
        binding.TotalOrderCount.text = sumCount.toString()+'개'
        binding.TotalOrderPrice.text = sumPrice.toString()

        return Pair(sumCount,sumPrice)

    }

    class ViewHolder(itemView: FragmentFoodAddedBinding) : RecyclerView.ViewHolder(itemView.root)
        {
        val binding = itemView
            val selectedItemName = binding.selectedItemName
            val selectedItemPrice = binding.selectedItemPrice
            val selectedItemCount = binding.selectedItemCount

        fun setFoodCount(position: Int) {
            selectedItemCount.text = FastFoodModel.foodSelectedList[position].foodCount.toString()
        }
        fun setFoodPrice(position: Int , account : Int){
            selectedItemPrice.text = account.toString()
        }

        fun deleteItem(position: Int) {
            ApplyFoodOrderList(FastFoodModel.currentActivity).foodSet()
        }
        }

}
