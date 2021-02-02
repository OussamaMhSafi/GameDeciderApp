package com.example.randomgamedecider

import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class GameAdapter(private val games:MutableList<Game>): RecyclerView.Adapter<GameAdapter.ViewHolder>() {


    override fun getItemCount(): Int= games.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view=LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        view.setOnClickListener(){
            
        }

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.gameImage.setImageDrawable(games[position].gameImage.drawable)
        holder.gameTitle.text=games[position].title
        holder.gameGenre.text=games[position].title
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val gameImage:ImageView=itemView.findViewById(R.id.game_image)
        val gameTitle:TextView=itemView.findViewById(R.id.title_text)
        val gameGenre:TextView=itemView.findViewById(R.id.genre_text)
    }



/*
class GameAdapter(fragment: ListFragment, gamesList: ArrayList<Game>): RecyclerView.Adapter<GameAdapter.GameHolder>(){



    var fragmentActivity:FragmentActivity = TODO()
    var games:ArrayList<Game> = TODO()
    lateinit var view:View

    interface ItemClicked{

        fun onItemCLicked(index:Int){}
    }

    init {
        val instance = fragmentActivity
        games=gamesList

    }

    class GameHolder(view: View, fragmentActivity: FragmentActivity) : RecyclerView.ViewHolder(view), View.OnClickListener {



        var gameText: TextView = TODO()

        init{

            gameText=view.findViewById(R.id.title_text)
            view.setOnClickListener(){

                //fragmentActivity.onItemClicked()


            }
        }

        override fun onClick(v: View?) {

            Log.e("RecyclerView clicked", "RV Click")
        }

        companion object{

            private val GAME_KEY="GAME"
        }
    }
    var itemClicked:ItemClicked = TODO()






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameHolder {
         view = LayoutInflater.from(parent.context)
                .inflate(R.layout.row_layout, parent, false)

                return GameHolder(view, fragmentActivity)
    }

    override fun onBindViewHolder(holder: GameHolder, position: Int) {
        holder.gameText.setTag(games[position])
        holder.gameText.setText(games[position].title)
    }

    override fun getItemCount(): Int {
        return 0
    }



     */


}
