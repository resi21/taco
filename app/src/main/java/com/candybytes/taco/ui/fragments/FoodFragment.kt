package com.candybytes.taco.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.candybytes.taco.databinding.FragmentFoodBinding
import com.candybytes.taco.ui.vm.FoodViewModel

class FoodFragment : Fragment() {

    private val viewModel: FoodViewModel by viewModels()

    private lateinit var binding: FragmentFoodBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFoodBinding.inflate(layoutInflater, container, false)
        binding.viewModel = this@FoodFragment.viewModel
        binding.lifecycleOwner = this@FoodFragment.viewLifecycleOwner
        return binding.root
    }
}