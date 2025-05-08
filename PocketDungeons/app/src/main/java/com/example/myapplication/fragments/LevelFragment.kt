package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.CharacterClass
import com.example.myapplication.R
import com.example.myapplication.databinding.LevelFragmentBinding
import com.example.myapplication.viewModels.GameViewModel
import timber.log.Timber

/**
 * LevelFragment class
 *
 * Contains the basic information and methods to ensure the correct function of a
 * level updating layer, which allows a character of whichever class selected to be upgraded.
 */
class LevelFragment: Fragment() {
    private lateinit var binding: LevelFragmentBinding
    private lateinit var viewModel: GameViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<LevelFragmentBinding>(
            inflater,
            R.layout.level_fragment,
            container,
            false)
        viewModel = ViewModelProvider(requireActivity())[GameViewModel::class.java]
        return binding.root
    }
    /**
     * Defines the basic logic to be established on view creation
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val characterClassName = arguments?.getString("character_class") ?: ""
        val characterClass = CharacterClass.valueOf(characterClassName)
        val character_map = viewModel.getCharacters()?.value?.toMutableMap() ?: mutableMapOf()

        binding.character = character_map[characterClass]

        binding.testLevelButton.setOnClickListener{
            binding.character = character_map[characterClass]
            character_map[characterClass]?.up_level()
            Timber.i("Nivel subido")
            viewModel.getCharacters()?.value = character_map
            Timber.i("Personajes: ${viewModel.getCharacters()?.value}")

        }
    }
    /**
     * Allows for the easy communication of characterClass information through bundles
     */
    companion object {
        fun newInstance(characterClass: CharacterClass): LevelFragment {
            val fragment = LevelFragment()
            val bundle = Bundle()
            bundle.putString("character_class", characterClass.name)
            fragment.arguments = bundle
            return fragment
        }
    }
}