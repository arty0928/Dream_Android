import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hyoja.cafe.model.CafeModel
import com.example.hyoja.databinding.ActivityFastfoodHome2Binding
import com.example.hyoja.databinding.FragmentFoodAddedBinding
import com.example.hyoja.fastfoods.model.FastFoodModel
import com.example.hyoja.fastfoods.model.OrderingFood

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

        // itemPlus 버튼 클릭 시
        holder.binding.plusItem.setOnClickListener {
            FastFoodModel.foodSelectedList[position].foodCount++
            holder.setFoodCount(position)

            var account: Int = 0

            if(FastFoodModel.foodSelectedList[position].setDessert!=null){
                account += FastFoodModel.foodSelectedList[position].setDessert!!.price
            }

            if(FastFoodModel.foodSelectedList[position].setDrink!=null){
                account += FastFoodModel.foodSelectedList[position].setDrink!!.price
            }
            account += (FastFoodModel.foodSelectedList[position].totalPrice) * FastFoodModel.foodSelectedList[position].foodCount

            Log.d("plusItem",account.toString())
            holder.setFoodPrice(position,account)
            updateTotalOrderCount()

        }
        holder.binding.miusItem.setOnClickListener {
            if(FastFoodModel.foodSelectedList[position].foodCount>1){
                FastFoodModel.foodSelectedList[position].foodCount--
                holder.setFoodCount(position)

                var account: Int = 0

                account += FastFoodModel.foodSelectedList[position].setDessert?.price ?: 0
                account += FastFoodModel.foodSelectedList[position].setDrink?.price?:0

                account += (FastFoodModel.foodSelectedList[position].totalPrice+account) * FastFoodModel.foodSelectedList[position].foodCount

                Log.d("setFoodPrice",account.toString())
                Log.d("setFoodPrice",account.toString())

                Log.d("setFoodPrice",account.toString())
                holder.setFoodPrice(position,account)

            }

        }
    }

    private fun updateTotalOrderCount() {

        var sumCount = 0
        var sumPrice = 0

        for (i in 0..FastFoodModel.foodSelectedList.size-1){
            sumCount += FastFoodModel.foodSelectedList[i].foodCount
            sumPrice += FastFoodModel.foodSelectedList[i].foodCount * FastFoodModel.foodSelectedList[i].totalPrice
        }
        binding.TotalOrderCount.text = sumCount.toString()
        binding.TotalOrderPrice.text = sumPrice.toString()

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
    }

}
