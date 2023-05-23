package com.example.warnawarni

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.warnawarni.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.util.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setListeners()
        setContentView(binding.root)
    }

    private fun setAllColors(warna: Int) {
        binding.box1.setBackgroundResource(warna)
        binding.box2.setBackgroundResource(warna)
        binding.box3.setBackgroundResource(warna)
        binding.box4.setBackgroundResource(warna)
        binding.box5.setBackgroundResource(warna)
    }

    private fun defaultColor() {
        binding.box1.setBackgroundResource(R.color.merah)
        binding.box2.setBackgroundResource(R.color.biru)
        binding.box3.setBackgroundResource(R.color.coklat)
        binding.box4.setBackgroundResource(R.color.hijau)
        binding.box5.setBackgroundResource(R.color.pink)
        binding.box1.setText("Merah")
        binding.box2.setText("Biru")
        binding.box3.setText("Coklat")
        binding.box4.setText("Hijau")
        binding.box5.setText("Pink")
    }

    private fun random() {
        var c1 = 0; var c2= 0; var c3 = 0; var color = 0;
//        var colors = mutableListOf(color)
//        var colors = arrayOf(1,2,3,4,5)
        var colors = mutableListOf<Int>(1,2,3,4,5)
        var parameter =0
        while(parameter<5){
            c1 = (0..256).random()
            c2= (0..256).random()
            c3 = (0..256).random()
            color = Color . argb (255, c1, c2, c3)
            colors[parameter] = color
            parameter++
        }

//        var color = Color . argb (255, para1, para2, para3);
        binding.box1.setBackgroundColor(colors[0])
        binding.box1.setText("")
        binding.box2.setBackgroundColor(colors[1])
        binding.box2.setText("")
        binding.box3.setBackgroundColor(colors[2])
        binding.box3.setText("")
        binding.box4.setBackgroundColor(colors[3])
        binding.box4.setText("")
        binding.box5.setBackgroundColor(colors[4])
        binding.box5.setText("")

//        when {
//            para1 < 200 && para2 < 200 && para3 < 200 -> {
//
//            }
//        }
    }

    @RequiresApi(Build.VERSION_CODES.P)
    private fun setListeners() {
        binding.box1.setOnClickListener() {
            setAllColors(R.color.merah)
        }
        binding.box2.setOnClickListener() {
            setAllColors(R.color.biru)
        }
        binding.box3.setOnClickListener() {
            setAllColors(R.color.coklat)
        }
        binding.box4.setOnClickListener() {
            setAllColors(R.color.hijau)
        }
        binding.box5.setOnClickListener() {
            setAllColors(R.color.pink)
        }
        binding.buttReset.setOnClickListener() {
            defaultColor()
        }
        binding.buttRandom.setOnClickListener() {
            random()
        }


//        Toast.makeText(this, "Baha", Toast.LENGTH_SHORT).show()

        val toast = Toast.makeText(this, "Hallow", Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.TOP,100,0)
        toast.show()

        val snackB = Snackbar.make(requireViewById(R.id.snack), "Ini Snack", Snackbar.LENGTH_SHORT)
        snackB.view.setBackgroundResource(R.color.sunflower)
        snackB.setTextColor(getColor(R.color.black))
        snackB.show()
    }

}

