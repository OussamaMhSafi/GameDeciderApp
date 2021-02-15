package com.example.randomgamedecider

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class GameAdapter(exampleList: ArrayList<Game1>) : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {
    private val mExampleList: ArrayList<Game1>

    class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mImageView: ImageView
        var mTextView1: TextView
        var mTextView2: TextView

        init {
            mImageView = itemView.findViewById(R.id.game_image)
            mTextView1 = itemView.findViewById(R.id.title_text)
            mTextView2 = itemView.findViewById(R.id.genre_text)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        return GameViewHolder(v)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val currentItem: Game1 = mExampleList[position]
        holder.mImageView.setImageResource(currentItem.getImgResource())
        holder.mTextView1.setText(currentItem.title)
        holder.mTextView2.setText(currentItem.genre)
    }

    override fun getItemCount(): Int {
        return mExampleList.size
    }

    init {
        mExampleList = exampleList
    }
}
