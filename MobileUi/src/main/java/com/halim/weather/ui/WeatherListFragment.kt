package com.halim.weather.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.halim.presentation.base.Resource
import com.halim.presentation.base.ResourceState
import com.halim.presentation.models.weather.WeatherPresentationModel
import com.halim.presentation.viewmodels.WeatherViewModel
import com.halim.weather.base.gone
import com.halim.weather.base.visible
import com.halim.weather.databinding.FragmentWeatherBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherListFragment : Fragment() {
    private lateinit var binding: FragmentWeatherBinding
    private lateinit var adaptor: WeatherAdapter
    private val viewModel by viewModels<WeatherViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setupObservers()
    }

    private fun setupObservers() {
        setupWeatherObserver()

    }

    private fun setupWeatherObserver() {
        viewModel.getWeatherLiveData().observe(viewLifecycleOwner) {
            it?.let {
                handleDataState(it)
            }
        }
        viewModel.fetchData()


    }

    private fun handleDataState(resource: Resource<WeatherPresentationModel>?) {
        when (resource?.state) {
            ResourceState.SUCCESS -> {
                binding.progressBar.gone()
                binding.recyclerview.visible()
            }

            ResourceState.LOADING -> {
                binding.progressBar.visible()
                binding.recyclerview.gone()

            }

            else -> {
                binding.progressBar.visible()
                binding.recyclerview.gone()
            }
        }
    }

    private fun initView() {
        setupPhotosRecyclerView()

    }

    private fun setupPhotosRecyclerView() {
        binding.recyclerview.layoutManager = LinearLayoutManager(context)
        adaptor = WeatherAdapter()
        binding.recyclerview.adapter = adaptor
    }

}

