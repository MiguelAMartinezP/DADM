package com.example.myapplication.activities
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.CharacterClass
import com.example.myapplication.HeroCharacter
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityGameBinding
import com.example.myapplication.fragments.ClockFragment
import com.example.myapplication.fragments.LevelFragment
import com.example.myapplication.viewModels.GameViewModel
import timber.log.Timber

/**
 *Game activity screen*.
 *
 * Defines a the infomation flow, as well as the screen throughout the Game.
 *
 */
class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    private val viewModel: GameViewModel by lazy {
        ViewModelProvider(this)[GameViewModel::class.java]
    }

    /**
     * Part of this screen´s lifecycle, it defines the actions to be performed
     * on creation of said activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_game)

        viewModel.setTime(intent.getIntExtra("slider_value", 45))
        viewModel.setSavedTimeWindow(viewModel.getTime().value?:45)

    }

    override fun onResume() {
        super.onResume()
        val bruteFragment = LevelFragment.newInstance(CharacterClass.BRUTE)
        val rogueFragment = LevelFragment.newInstance(CharacterClass.ROGUE)
        val mageFragment = LevelFragment.newInstance(CharacterClass.MAGE)
        val clericFragment = LevelFragment.newInstance(CharacterClass.CLERIC)
        supportFragmentManager.beginTransaction()
            .replace(R.id.brute_level_fragment, bruteFragment)
            .replace(R.id.mage_level_fragment, mageFragment)
            .replace(R.id.cleric_level_fragment, clericFragment)
            .replace(R.id.rogue_level_fragment, rogueFragment)
            .commit()
    }
}