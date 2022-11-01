package com.conamobile.lightanddarkcolordeegrecheck

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.conamobile.lightanddarkcolordeegrecheck.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.dark.setOnClickListener {
            Toast.makeText(this,
                "${isColorDark((binding.dark.background as ColorDrawable).color)}",
                Toast.LENGTH_SHORT).show()
        }
        binding.light.setOnClickListener {
            Toast.makeText(this,
                "${isColorDark((binding.light.background as ColorDrawable).color)}",
                Toast.LENGTH_SHORT).show()
        }
    }

    private fun isColorDark(color: Int): Boolean {
        val darkness =
            1 - (0.299 * Color.red(color) + 0.587 * Color.green(color) + 0.114 * Color.blue(color)) / 255
        return darkness >= 0.5
    }
}