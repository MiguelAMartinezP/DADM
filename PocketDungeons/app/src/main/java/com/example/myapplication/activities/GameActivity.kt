package com.example.myapplication.activities
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityGameBinding
import com.example.myapplication.viewModels.GameViewModel
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
        viewModel.setSavedTimeWindow(viewModel.getTime().value ?: 45)

    }

    override fun onResume() {
        super.onResume()
        binding.btnToggleCharacters.setOnClickListener {
            val navController = findNavController(R.id.nav)
            if (navController.currentDestination?.id == R.id.charactersFragment) {
                navController.navigate(R.id.gameContainerFragment)
            } else {
                navController.popBackStack()
            }
        }
    }
}