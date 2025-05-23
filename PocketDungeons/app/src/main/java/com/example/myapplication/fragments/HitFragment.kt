package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.databinding.HitFragmentBinding
import com.example.myapplication.viewModels.GameViewModel

/**
 * HitFragment class
 * TODO
 * The hit fragment was initially thought out to be a fragment in charge of representing the hp of
 * the current party, however due to time constraints it will remain under construction.
 */
class HitFragment: Fragment() {
    private lateinit var binding: HitFragmentBinding
    private lateinit var viewModel: GameViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<HitFragmentBinding>(
            inflater,
            R.layout.hit_fragment,
            container,
            false)
        viewModel = ViewModelProvider(requireActivity()).get(GameViewModel::class.java)
        return binding.root
    }
}