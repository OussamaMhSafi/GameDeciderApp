package com.example.randomgamedecider

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.randomgamedecider.databinding.FragmentAddGameBinding
import com.google.android.material.textfield.TextInputEditText


class AddGameFragment : Fragment() {

    private lateinit var selectImage:ImageView
    private lateinit var gameImage:ImageButton
    private lateinit var newGameText:TextInputEditText
    private lateinit var newGenreText:TextInputEditText

    private val pickImage = 100
    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding:FragmentAddGameBinding=DataBindingUtil.inflate(inflater, R.layout.fragment_add_game, container, false)


        newGameText=binding.nameEditText
        newGenreText=binding.genreEditText

        val addGameBtn: Button = binding.addGameButton
        gameImage=binding.selectGameImage

        binding.selectGameImage.setOnClickListener {

            selectGameImage()
        }

        addGameBtn.setOnClickListener {

            addNewGame()
        }

        return binding.root
    }

    private fun selectGameImage() {

        val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        startActivityForResult(gallery, pickImage)

        //GameSingleton.instance.allGames()
    }

    private fun addNewGame() {

        if (newGameText.text.isNullOrEmpty() or newGenreText.text.isNullOrEmpty() or (selectImage.drawable == null)){

            if(newGameText.text.isNullOrEmpty()){
                Toast.makeText(context, "Please enter the name of the Game", Toast.LENGTH_SHORT).show()
            }
            if( newGenreText.text.isNullOrEmpty()){
                Toast.makeText(context, "Please enter the genre of the Game", Toast.LENGTH_SHORT).show()
            }
            if(selectImage.drawable==null){
                Toast.makeText(context, "Please select an image to represent the Game", Toast.LENGTH_SHORT).show()
            }
        }
        else
        {
            val newGame= Game(
                newGameText.text.toString(),
                newGenreText.text.toString(),
                selectImage
            )
            GameSingleton.instance.allGames.add(newGame)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode==RESULT_OK && requestCode==pickImage)
            imageUri=data?.data
            gameImage.setImageURI(imageUri)
            selectImage.setImageURI(imageUri)


    }

}