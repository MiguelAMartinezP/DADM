package com.example.myapplication.fragments

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.databinding.ClockFragmentBinding
import com.example.myapplication.viewModels.GameViewModel
import timber.log.Timber

class ClockFragment : Fragment() {
    private lateinit var timer: CountDownTimer
    private lateinit var binding: ClockFragmentBinding
    private lateinit var viewModel: GameViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<ClockFragmentBinding>(
            inflater,
            R.layout.clock_fragment,
            container,
            false)
        viewModel = ViewModelProvider(requireActivity())[GameViewModel::class.java]

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        Timber.i("arranco")
        startTimer()

        return binding.root
    }
    private fun startTimer() {
        timer = object : CountDownTimer( ((viewModel.getTime().value?.toLong()?: 45) * 1000), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val secondsLeft = millisUntilFinished / 1000
                viewModel.setTime(secondsLeft.toInt())
            }

            override fun onFinish() {
                viewModel.addRound()
                Timber.i("ronda: ${viewModel.getRound().value}")
                startTimer()
            }
        }

        timer.start()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        if (::timer.isInitialized) timer.cancel()
    }
}