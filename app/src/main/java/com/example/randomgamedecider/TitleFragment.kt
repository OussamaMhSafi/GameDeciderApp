package com.example.randomgamedecider

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.randomgamedecider.databinding.FragmentTitleBinding
import java.util.*

class TitleFragment : Fragment() {

    private lateinit var gameTitleResult:TextView
    private lateinit var gameGenreResult:TextView
    private lateinit var gameSingleton: GameSingleton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentTitleBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)

        gameSingleton= GameSingleton.getInstance()
        gameTitleResult=binding.resultText
        gameGenreResult=binding.genreResultText
        val rollButton=binding.rollButton
        rollButton.setOnClickListener{

            rollDice()
        }

        /*
        val randImage=binding.gameImage

        binding.rollButton.setOnClickListener {
            getRandomGame(randImage)
        }


         */
        return  binding.root
    }

    private fun rollDice() {

        val random = Random().nextInt(gameSingleton.allGames.size)

        val resultGame=gameSingleton.allGames.get(random)


        gameTitleResult.setText(resultGame.title)
        gameGenreResult.setText(resultGame.genre)
    }
}