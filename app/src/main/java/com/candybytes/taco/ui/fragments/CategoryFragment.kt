package com.candybytes.taco.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.candybytes.taco.databinding.FragmentCategoryBinding
import com.candybytes.taco.ui.vm.CategoryViewModel

class CategoryFragment : Fragment() {

    private val viewModel: CategoryViewModel by viewModels()

    private lateinit var binding: FragmentCategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        FragmentCategoryBinding.inflate(layoutInflater, container, false)
        binding.viewModel = this@CategoryFragment.viewModel
        binding.lifecycleOwner = this@CategoryFragment

        return binding.root
    }
}