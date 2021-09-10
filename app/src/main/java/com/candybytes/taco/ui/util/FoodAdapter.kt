package com.candybytes.taco.ui.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.candybytes.taco.R
import com.candybytes.taco.vo.Food

class FoodAdapter: RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {
    private val items: ArrayList<Food> = ArrayList()

    class FoodViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var amount: TextView = view.findViewById(R.id.qtyAndUnit)
        var id: TextView = view.findViewById(R.id.food_id)
        var description: TextView = view.findViewById(R.id.description)

        fun bind(food: Food) {
            amount.text = food.baseQty.toString() + food.baseUnity
            id.text = "#" + food.id.toString()
            description.text = food.description
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_food, viewGroup, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: FoodViewHolder, position: Int) {
        viewHolder.amount.text = items[position].baseQty.toString() + " " + items[position].baseUnity
        viewHolder.id.text = "#" + items[position].id.toString()
        viewHolder.description.text = items[position].description
    }

    fun updateFoodList(food: List<Food>?) {
        if (food != null) {
            items.clear()
            items.addAll(food)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}