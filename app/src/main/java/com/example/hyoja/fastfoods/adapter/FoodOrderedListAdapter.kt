import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hyoja.databinding.FragmentFoodAddedBinding
import com.example.hyoja.fastfoods.model.FastFoodModel
import com.example.hyoja.fastfoods.model.OrderingFood

class FoodOrderedListAdapter(private val itemClickListener: ItemClickListener) :
    RecyclerView.Adapter<FoodOrderedListAdapter.ViewHolder>() {

    interface ItemClickListener {
        fun onItemPlusClick(position: Int)
        fun onItemMinusClick(position: Int)
    }

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
        holder.bind(FastFoodModel.foodSelectedList[position])

        // itemPlus 버튼 클릭 시
        holder.binding.plusItem.setOnClickListener {
            // 해당 아이템의 인덱스를 클릭 리스너를 통해 전달
            itemClickListener.onItemPlusClick(holder.adapterPosition)
        }
        holder.binding.miusItem.setOnClickListener {
            // 해당 아이템의 인덱스를 클릭 리스너를 통해 전달
            itemClickListener.onItemMinusClick(holder.adapterPosition)
        }
    }

    class ViewHolder(val binding: FragmentFoodAddedBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(orderingFood: OrderingFood) {
            binding.selectedItemName.text = orderingFood.food.name.toString()
            binding.selectedItemPrice.text = orderingFood.price.toString()
            binding.selectedItemCount.text = orderingFood.foodCount.toString()
        }
    }
}
