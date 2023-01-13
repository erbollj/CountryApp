package com.geektech.countryapp.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.geektech.countryapp.core.BaseFragment
import com.geektech.countryapp.databinding.FragmentDetailBinding
import com.geektech.countryapp.model.CountryItem

class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>() {
    override val viewModel: DetailViewModel by viewModels()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(inflater, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun initView() {
        val result = arguments?.getParcelable<CountryItem>("key")
        binding?.apply {
            txtCapital.text = result?.capital.toString()
            txtCurrency.text =
                result?.currencies?.last()?.code + " " + result?.currencies?.last()?.name +
                        " " + result?.currencies?.last()?.symbol
            txtName.text = result?.name.toString()
            txtRegion.text = result?.region.toString()
            txtTimezone.text = result?.timezones.toString()
            Glide.with(imgCountry).load(result?.flags?.png.toString()).into(imgCountry)
        }
    }

    override fun initListener() {
        requireActivity().onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (isEnabled)
                    findNavController().navigateUp()
            }
        })
    }

}