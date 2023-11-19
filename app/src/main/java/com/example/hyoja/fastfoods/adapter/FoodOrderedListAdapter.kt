import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hyoja.databinding.FragmentFoodAddedBinding
import com.example.hyoja.fastfoods.model.FastFoodModel
import com.example.hyoja.fastfoods.model.OrderingFood

class FoodOrderedListAdapter : RecyclerView.Adapter<FoodOrderedListAdapter.ViewHolder>() {

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
    }

    class ViewHolder(private val binding: FragmentFoodAddedBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(orderingFood: OrderingFood) {
            binding.selectedItemName.text = orderingFood.food.name.toString()
            binding.selectedItemPrice.text = orderingFood.price.toString()
            binding.selectedItemCount.text = orderingFood.foodCount.toString()
        }
    }
}
