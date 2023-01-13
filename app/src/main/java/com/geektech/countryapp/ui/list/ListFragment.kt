package com.geektech.countryapp.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.geektech.countryapp.core.BaseFragment
import com.geektech.countryapp.databinding.FragmentListBinding

class ListFragment : BaseFragment<FragmentListBinding, ListViewModel>() {
    override val viewModel: ListViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentListBinding {
        return FragmentListBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        viewModel.getCountries()
        viewModel.countries.observe(viewLifecycleOwner) {
            val adapter = it.data?.let { it1 -> ListAdapter(it1) }
            binding?.recycler?.adapter = adapter
        }
    }

    override fun initListener() {
        binding?.btnUpdate?.setOnClickListener {
            viewModel.getCountries()
            viewModel.countries.observe(viewLifecycleOwner) {
                val adapter = it.data?.let { it1 -> ListAdapter(it1) }
                binding!!.recycler.adapter = adapter
            }
        }
    }

}