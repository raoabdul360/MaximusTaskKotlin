package com.maximustaskkotlin.ui

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.maximustaskkotlin.R
import com.maximustaskkotlin.databinding.ActivityMainBinding
import com.maximustaskkotlin.viewModel.MyViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var myViewModel: MyViewModel
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        progressDialog = ProgressDialog(this, R.style.AppCompatAlertDialogStyle)
        progressDialog.setMessage("Please Wait....")
        progressDialog.setCancelable(false)
        progressDialog.show()

        myViewModel = ViewModelProvider(this)[MyViewModel::class.java]


        myViewModel.loadFact()

        myViewModel.factModel.observe(this, Observer {

            progressDialog.dismiss()
            binding.factTextView.text = it.fact

        })

        binding.loadfact.setOnClickListener {
            progressDialog.show()
            myViewModel.loadFact()
        }


    }

    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setMessage("Are you sure you want to exit?")
            .setCancelable(false)
            .setPositiveButton(
                "Yes"
            ) { _, _ -> super@MainActivity.onBackPressed() }
            .setNegativeButton("No", null)
            .show()
    }


}