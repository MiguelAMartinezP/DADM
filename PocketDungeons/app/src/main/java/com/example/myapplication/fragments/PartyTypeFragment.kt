package com.example.myapplication.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.viewModels.GameViewModel
import com.example.myapplication.databinding.PartyTypeFragmentBinding

/**
 * PartyTypeFragment class
 *
 * Contains the basic logic and methods to ensure the correct function and
 * display of an alternating informative fragment which will allow the user to identify which
 * character level to change.
 */
class PartyTypeFragment: Fragment() {
    private lateinit var viewModel: GameViewModel
    private lateinit var binding: PartyTypeFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PartyTypeFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        return binding.root
    }
    /**
    *Defines the basic logic to be performed when creating the view.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel= viewModel
    }
}