package com.mercado.pago.integration

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.mercado.pago.integration.databinding.FragmentHomeBinding
import com.mercado.pago.integration.helpers.viewBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel: HomeViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        binding.preferencesButton.setOnClickListener {
            viewModel.createPreferences()
        }

        binding.subscriptionButton.setOnClickListener {
            viewModel.createSubscription()
        }
    }
}