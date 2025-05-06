package com.example.myapplication.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import com.example.myapplication.data.database.DatabaseProvider
import com.example.myapplication.databinding.ActivityPlayMenuBinding
import com.example.myapplication.viewModels.LoginViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

/**
 * Contains the logic for the first menu screen where the game's parameters are given by the user.
 */
class PlayMenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlayMenuBinding

    /**
     * Defines the basic logic to perform when creating the view.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_play_menu)


    }

    override fun onResume() {
        super.onResume()
        binding.StartGame.setOnClickListener{
            val game = Intent(this, GameActivity::class.java)
            game.putExtra("slider_value", binding.sliderValue.text.toString().toInt())
            startActivity(game)
            Timber.i("Game starting")
        }
        binding.backButton.setOnClickListener{
            finish()
        }
        binding.slider.addOnChangeListener{ _, value, _ ->
            binding.sliderValue.text = "${value.toInt()}"


        }
        /*
        binding.popupButton.setOnClickListener { view ->
            val popup = PopupMenu(this, view)
            popup.menuInflater.inflate(R.menu.user_popup, popup.menu)
            // Personaliza el ítem del usuario con el nombre real
            val menuUser = popup.menu.findItem(R.id.menu_user)
            menuUser.title = "Usuario: ${viewModel.user}"

            popup.show()
        }
         */
    }
}