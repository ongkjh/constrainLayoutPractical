package com.example.constrainlayoutpractical

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import javax.sql.RowSetListener

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListener()

        //#1 create object for spinner
        val spinner: Spinner = findViewById(R.id.spinnerColorSelection)
        spinner.onItemSelectedListener = this

        //#2 create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.ColorSelection,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    //for spinner item selected listener
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
        val selectionTv : TextView = findViewById(R.id.colorSelectedText)
        selectionTv.text = parent?.getItemAtPosition(pos).toString()

    }
    //for spinner item selected listener
    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    private fun makeColored(view: View){
        when (view.id){
            //Boxes using Color Class colors for background
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GREEN)
            R.id.box_three_text -> view.setBackgroundColor(Color.CYAN)
            R.id.box_four_text -> view.setBackgroundColor(Color.YELLOW)
            R.id.box_five_text -> view.setBackgroundColor(Color.MAGENTA)
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    private fun setListener(){
        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)

        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)

        val clickableView: List<View> =
            listOf(boxOneText,boxTwoText,boxThreeText,boxFourText
                ,boxFiveText,rootConstraintLayout)

        for (item in clickableView){
            item.setOnClickListener { makeColored(it) }
        }
    }
}