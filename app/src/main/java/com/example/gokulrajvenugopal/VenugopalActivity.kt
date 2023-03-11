package com.example.gokulrajvenugopal


import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gokulrajvenugopal_comp304_004_hands_on_test1_w23.R

/*
Student Name: Gokulraj Venugopal
Student ID: 301202722
 */

class VenugopalActivity : AppCompatActivity() {

    private val selectedExercises: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brain_challenge)
        setTitle(resources.getString(R.string.header));

        val exercise1CheckBox = findViewById<CheckBox>(R.id.exercise1CheckBox)
        val exercise2CheckBox = findViewById<CheckBox>(R.id.exercise2CheckBox)
        val exercise3CheckBox = findViewById<CheckBox>(R.id.exercise3CheckBox)
        val exercise4CheckBox = findViewById<CheckBox>(R.id.exercise4CheckBox)

        exercise1CheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                selectedExercises.add(resources.getString(R.string.exercise1))
            } else {
                selectedExercises.remove(resources.getString(R.string.exercise1))
            }
        }

        exercise2CheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                selectedExercises.add(resources.getString(R.string.exercise2))
            } else {
                selectedExercises.remove(resources.getString(R.string.exercise2))
            }
        }

        exercise3CheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                selectedExercises.add(resources.getString(R.string.exercise3))
            } else {
                selectedExercises.remove(resources.getString(R.string.exercise3))
            }
        }

        exercise4CheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                selectedExercises.add(resources.getString(R.string.exercise4))
            } else {
                selectedExercises.remove(resources.getString(R.string.exercise4))
            }
        }

        val nextButton = findViewById<Button>(R.id.nextButton)
        nextButton.setOnClickListener {
            val sb = StringBuilder()
            for (item in selectedExercises) {
                sb.append(item)
                sb.append("\n")
            }
            val selectedExercisesString = sb.toString()

            Toast.makeText(this, selectedExercisesString, Toast.LENGTH_SHORT).show()
        }

        val zigzagImageView = findViewById<ImageView>(R.id.zigzagImageView)
        val memoryCycle = resources.getStringArray(R.array.memoryCycleArray)


        var x = 0
        var y : Int
        val paint = Paint()

        paint.color = Color.WHITE
        paint.strokeWidth = 5f

        val width = resources.getDimension(R.dimen.img_width).toInt()
        val height = resources.getDimension(R.dimen.img_height).toInt()

        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)

        var flip = true

        for (yCoordinateString in memoryCycle) {
            y = yCoordinateString.toInt()
            canvas.drawLine(x.toFloat(), y.toFloat(), x.toFloat() + 100, (if (flip) y - 30 else y + 30).toFloat(), paint)
            x += 100
            flip = !flip
        }

        zigzagImageView.setImageBitmap(bitmap)


    }

    override fun onDestroy() {
        super.onDestroy()
        println("Brain Activity Destroyed")
    }
}