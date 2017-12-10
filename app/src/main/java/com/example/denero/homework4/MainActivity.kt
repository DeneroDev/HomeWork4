package com.example.denero.homework4

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.GridLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var planetNameArray:Array<String>
    lateinit var planetBitmapArray:Array<Bitmap>
    lateinit var planetLinkArray:Array<String>
    lateinit var planetDistanceArray:Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        planetNameArray = resources.getStringArray(R.array.planet)
        planetLinkArray = resources.getStringArray(R.array.linkPlanet)
        planetDistanceArray = resources.getStringArray(R.array.distancePlanet)
        planetBitmapArray = Array(8,{i->BitmapFactory.decodeResource(resources,R.drawable.one)})
        planetBitmapArray.set(0,BitmapFactory.decodeResource(resources,R.drawable.one))
        planetBitmapArray.set(1,BitmapFactory.decodeResource(resources,R.drawable.two))
        planetBitmapArray.set(2,BitmapFactory.decodeResource(resources,R.drawable.three))
        planetBitmapArray.set(3,BitmapFactory.decodeResource(resources,R.drawable.four))
        planetBitmapArray.set(4,BitmapFactory.decodeResource(resources,R.drawable.five))
        planetBitmapArray.set(5,BitmapFactory.decodeResource(resources,R.drawable.six))
        planetBitmapArray.set(6,BitmapFactory.decodeResource(resources,R.drawable.seven))
        planetBitmapArray.set(7,BitmapFactory.decodeResource(resources,R.drawable.eigth))
       // BitmapFactory.decodeResource(resources,R.drawable.user)
        var data = Array(8,
                {i -> when(i){
                    2 -> Planet(planetNameArray[i],planetBitmapArray[i],planetDistanceArray[i]+"km",BitmapFactory.decodeResource(resources,R.mipmap.life),planetLinkArray[i])
                    else
                            ->Planet(planetNameArray[i],planetBitmapArray[i],planetDistanceArray[i]+"km",BitmapFactory.decodeResource(resources,R.mipmap.nolife),planetLinkArray[i])
                }
                })

        var list = list
        list.layoutManager = GridLayoutManager(applicationContext,2)
        list.adapter = PlanetAdapter(data)
        list.adapter.notifyDataSetChanged()


    }
}

