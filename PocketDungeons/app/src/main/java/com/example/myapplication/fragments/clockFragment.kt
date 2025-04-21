package com.example.myapplication.fragments

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.databinding.ClockFragmentBinding
import com.example.myapplication.databinding.HitFragmentBinding
import com.example.myapplication.viewModels.GameViewModel

class clockFragment : Fragment() {
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


        //startTimer(timerTextView, statusTextView)

        return view
    }
    private fun startTimer(timerView: TextView, statusView: TextView) {
        timer = object : CountDownTimer( ((viewModel.getTime().value?.toLong()?: 45) * 1000), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val secondsLeft = millisUntilFinished / 1000
                timerView.text = "Tiempo restante: $secondsLeft s"
            }

            override fun onFinish() {
                timerView.text = ""
                statusView.text = "¡Cambio de ronda!"
            }
        }

        timer.start()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        if (::timer.isInitialized) timer.cancel()
    }
}