package com.ismin.android

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun createBook(view: View) {
        startActivity2()
      }

    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val someData = result.data?.getSerializableExtra("extra-key")
        }
    }


    fun startActivity2() {
        val intent = Intent(this, CreateBookActivity::class.java)
        startForResult.launch(intent)
    }




}