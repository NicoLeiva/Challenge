package com.example.challenge

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.example.challenge.databinding.ActivityMainBinding
import com.example.challenge.model.PhoneListItem
import com.example.challenge.ui.view.PhoneAdapter
import com.example.challenge.ui.view.CarrouselAdapter
import com.example.challenge.ui.viewmodel.PhoneViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PhoneAdapter
    private var phoneList = arrayListOf<PhoneListItem>()
    private lateinit var builder: AlertDialog.Builder
    private lateinit var dialog: AlertDialog

    private val viewmodel: PhoneViewModel by viewModels()

    private fun initRecyclerView(){
        adapter = PhoneAdapter(phoneList) { id -> getDetailsInfo(id) }
        binding.listPhones.layoutManager = LinearLayoutManager(this)
        binding.listPhones.adapter = adapter

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getDataPhones()
        initRecyclerView()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun getDataPhones() {
            viewmodel.getAllPhones().observe(this) { response ->
                if (response != null) {
                    //phoneList.clear()
                    phoneList.addAll(response)
                    adapter.notifyDataSetChanged()
                } else {
                    showError()
                }
            }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun getDetailsInfo(id:String){
       // viewmodel.getPhoneDetails(id)
        var phoneDetails: PhoneListItem
        var firstTime = true
            viewmodel.getPhoneDetails(id).observe(this) { response ->
                if (response != null && firstTime) {
                        phoneDetails = response
                        firstTime = false
                        openCarrouselDialog(phoneDetails)
                    }
            }

    }

    private fun setViewPager(view:View, phoneDetails: PhoneListItem){
        val viewPager: ViewPager = view.findViewById(R.id.viewPager)
        val adapter = CarrouselAdapter(phoneDetails.images,this)
        viewPager.adapter = adapter
    }

    @SuppressLint("ResourceType")
    private fun openCarrouselDialog(phoneDetails: PhoneListItem) {
                builder = AlertDialog.Builder(this)
                val view = layoutInflater.inflate(R.layout.fragment_carrousel, null)
                view.findViewById<TextView>(R.id.legalTextVire)?.text = phoneDetails.legal
                setViewPager(view, phoneDetails)
                builder.setView(view)
                builder.setNegativeButton(
                    "Cerrar",
                ) { dialog, _ -> dialog.dismiss() }
                dialog = builder.create()
                dialog.show()

    }

    private fun showError() {
        Toast.makeText(this, "ERROR", Toast.LENGTH_LONG).show()
    }


}