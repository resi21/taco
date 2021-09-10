package com.candybytes.taco.ui.util

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.candybytes.taco.vo.Category
import com.candybytes.taco.vo.Food

@BindingAdapter("goneUnless")
fun goneUnless(view: View?, visible: Boolean?) {
    view?.visibility = if (visible == true) View.VISIBLE else View.GONE
}

@BindingAdapter("app:adapter", "app:data")
fun RecyclerView.setData(adapt: RecyclerView.Adapter<*>, data: List<*>?) {
    if (data != null) {
        adapter = if (adapt is CategoryAdapter) {
            var categoryAdapter = CategoryAdapter()
            val categories = data as List<Category>?
            categoryAdapter.updateCategories(categories)
            categoryAdapter
        } else {
            var foodAdapter = FoodAdapter()
            val food = data as List<Food>?
            foodAdapter.updateFoodList(food)
            foodAdapter
        }
    }
}

@BindingAdapter("app:onTextChange")
fun EditText.onChangeText(search: () -> Unit) {
    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable) {}

        override fun beforeTextChanged(s: CharSequence, start: Int,
                                       count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence, start: Int,
                                   before: Int, count: Int) {

        }
    })
}