package com.example.challenge.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.challenge.databinding.FragmentCarrouselBinding
import com.example.challenge.model.PhoneListItem

private const val PHONE_DETAILS = "phoneDetails"

class CarrouselFragment :Fragment() {

    private lateinit var binding: FragmentCarrouselBinding

    private lateinit var phoneDetails: PhoneListItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            phoneDetails = it.getParcelable(PHONE_DETAILS)!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCarrouselBinding.inflate(layoutInflater)
        binding.legalTextVire.text = phoneDetails.legal
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(response: PhoneListItem) =
            CarrouselFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(PHONE_DETAILS, response)
                }
            }
    }
}