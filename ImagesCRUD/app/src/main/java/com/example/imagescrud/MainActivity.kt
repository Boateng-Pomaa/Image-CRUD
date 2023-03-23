package com.example.imagescrud

import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.Images.Media.insertImage
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.imagescrud.databinding.ActivityMainBinding
import layout.DBhelper

abstract class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val databaseHelper = DBhelper(applicationContext)
    val db = databaseHelper.writableDatabase


    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.btnAdd.setOnClickListener {
            pickImageFromGallery(this, PICK_IMAGE_REQUEST_CODE)
        }
    }

    private fun pickImageFromGallery(activity: Activity, requestCode: Int) {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        activity.startActivityForResult(intent, requestCode)
    }

    companion object{
        const val PICK_IMAGE_REQUEST_CODE = 1000
    }



    }

