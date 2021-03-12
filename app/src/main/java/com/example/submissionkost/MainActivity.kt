package com.example.submissionkost

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.submissionkost.Kost.Kost
import com.example.submissionkost.Kost.KostAdapter
import com.example.submissionkost.Kost.KostData
import com.example.submissionkost.about.About

class MainActivity : AppCompatActivity() {
    private lateinit var rvKost: RecyclerView
    private var list: ArrayList<Kost> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionbar = supportActionBar
        actionbar!!.title= "Kost"

        rvKost = findViewById(R.id.rv_kost)
        rvKost.setHasFixedSize(true)

        list.addAll(KostData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvKost.layoutManager = LinearLayoutManager(this)
        val kostAdapter = KostAdapter(list)
        rvKost.adapter = kostAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.miCompose -> {
                val iAbout = Intent(this@MainActivity,
                    About::class.java)
                startActivity(iAbout)
            }
        }
    }
}