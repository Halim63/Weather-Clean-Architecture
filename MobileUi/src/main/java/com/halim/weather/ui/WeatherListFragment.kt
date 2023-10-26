package com.halim.weather.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.halim.presentation.base.Resource
import com.halim.presentation.base.State
import com.halim.presentation.models.weather.WeatherDetailsPresentationModel
import com.halim.presentation.models.weather.WeatherPresentationModel
import com.halim.presentation.viewmodels.WeatherViewModel
import com.halim.weather.R
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
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setupObservers()
        fetchData()

    }

    private fun setupObservers() {
        setupWeatherObserver()
        setupViewObserver()

    }

    private fun setupViewObserver() {
        viewModel.liveData.observe(viewLifecycleOwner) {
            adaptor.submitList(it.list)
        }
    }

    private fun fetchData() = viewModel.getWeather()


    private fun setupWeatherObserver() {
        viewModel.weatherLiveData.observe(viewLifecycleOwner) { result ->
            when (result.state) {
                State.LOADING -> onShowWeatherLoading()
                State.SUCCESS -> onShowWeatherSuccess(result.result)
                State.ERROR -> onShowWeatherError(result.errorMessage)
            }

        }


    }

    private fun onShowWeatherError(errorMessage: String?) {
        binding.progressBar.visible()
        binding.recyclerview.gone()
        showSnakeBarMessage(errorMessage ?: getString(R.string.something_went_wrong))

    }

    private fun showSnakeBarMessage(message: String) {
        Snackbar.make(
            binding.root,
            message,
            Snackbar.LENGTH_LONG
        ).show()
    }

    private fun onShowWeatherSuccess(result: WeatherDetailsPresentationModel?) {
        if (result == null) {
            binding.progressBar.visible()
        }
        binding.progressBar.gone()
        binding.recyclerview.visible()

    }

    private fun onShowWeatherLoading() {
        binding.progressBar.visible()
        binding.recyclerview.gone()
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

