package com.example.myapplication.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.CharacterClass
import com.example.myapplication.R
import com.example.myapplication.databinding.PartyLevelFragmentBinding
import com.example.myapplication.viewModels.GameViewModel
/**
 * PartyLevelFragment class
 *
 * Party level Fragment contains the basic logic as well as methods to ensure the correct display
 * and function of a party level, or in other words a list of LevelFragments
 */
class PartyLevelFragment : Fragment() {
    private lateinit var binding: PartyLevelFragmentBinding
    private lateinit var viewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PartyLevelFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(GameViewModel::class.java)
        return binding.root
    }
    /**
     * On view Creation this method will generate the list with the different types of LevelFragment
     * to be displayed and played with.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configura los 4 fragmentos (como en tu GameActivity.onResume())
        val bruteFragment = LevelFragment.newInstance(CharacterClass.BRUTE)
        val rogueFragment = LevelFragment.newInstance(CharacterClass.ROGUE)
        val mageFragment = LevelFragment.newInstance(CharacterClass.MAGE)
        val clericFragment = LevelFragment.newInstance(CharacterClass.CLERIC)

        childFragmentManager.beginTransaction()
            .replace(R.id.brute_level_fragment, bruteFragment)
            .replace(R.id.mage_level_fragment, mageFragment)
            .replace(R.id.cleric_level_fragment, clericFragment)
            .replace(R.id.rogue_level_fragment, rogueFragment)
            .commit()

    }
}