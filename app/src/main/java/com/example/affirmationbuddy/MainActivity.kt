package com.example.affirmationbuddy

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var dailyAffirmation: TextView
    private lateinit var moodSpinner: Spinner
    private lateinit var saveMoodButton: Button
    private lateinit var moodListView: ListView
    private lateinit var moodList: ArrayList<String>
    private lateinit var moodAdapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dailyAffirmation = findViewById(R.id.dailyAffirmation)
        moodSpinner = findViewById(R.id.moodSpinner)
        saveMoodButton = findViewById(R.id.saveMoodButton)
        moodListView = findViewById(R.id.moodListView)

        // Set up Spinner with mood options
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.moods_array,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        moodSpinner.adapter = adapter

        // Initialize mood list and adapter
        moodList = ArrayList()
        moodAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, moodList)
        moodListView.adapter = moodAdapter

        // Set Spinner item selected listener
        moodSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // Handle item selection
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Handle no item selected
            }
        }

        // Set Button click listener
        saveMoodButton.setOnClickListener {
            val selectedMood = moodSpinner.selectedItem.toString()
            moodList.add(selectedMood)
            moodAdapter.notifyDataSetChanged()
        }
    }
}