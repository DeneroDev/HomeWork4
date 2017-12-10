package com.example.denero.homework4

import android.graphics.Bitmap
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.planet.view.*
import android.content.Intent
import android.net.Uri
import android.support.v4.content.ContextCompat.startActivity



/**
 * Created by DENERO on 10.12.2017.
 */
class PlanetAdapter(var data:Array<Planet>):RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder>() {
    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PlanetViewHolder {
       return PlanetViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.planet,parent,false))

    }

    override fun onBindViewHolder(holder: PlanetViewHolder?, position: Int) {
        holder?.name?.setText(data[position].name)
        holder?.img?.setImageBitmap(data[position].img)
        holder?.distance?.setText(data[position].distance)
        holder?.iconLife?.setImageBitmap(data[position].iconLife)
        holder?.link?.setText(data[position].link)
        holder?.v?.setOnClickListener(View.OnClickListener {

            var intent = Intent(holder.v.context,MyBrowserActivity::class.java)
            intent.putExtra("link",data[position].link)
            startActivity(holder.v.context,intent,null)
        })

    }


    class PlanetViewHolder(var v: View): RecyclerView.ViewHolder(v) {
        var name: TextView? = v.planet_name
        var img:ImageView = v.planet_bitmap
        var distance:TextView = v.planet_distance
        var iconLife:ImageView = v.planet_life_ico
        var link: TextView? = v.planet_link
    }
}