package com.pprodev.werami.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.pprodev.werami.databinding.FragmentMapBinding


class MapFragment : Fragment() {
    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMapBinding.inflate(inflater, container, false)
        val view = binding.root

        viewModel.getGreetings().observe(viewLifecycleOwner, {
            binding.tvGreetingText.text = it
        })


        return view
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
