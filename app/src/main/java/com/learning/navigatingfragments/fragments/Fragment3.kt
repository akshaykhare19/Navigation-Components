package com.learning.navigatingfragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.learning.navigatingfragments.R


/**
 * A simple [Fragment] subclass.
 * Use the [Fragment3.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment3 : Fragment() {

    val args: Fragment2Args by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_3, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //receive data from fragment 2
        val receivedData: TextView = view.findViewById(R.id.data_received)
        val data = args.message
        receivedData.text = data

        //navigate from fragment 2 to fragment 3
        val button = view.findViewById<Button>(R.id.fragment_1_btn)

        button.setOnClickListener {
            val action = Fragment3Directions.actionFragment3ToFragment1()
            view.findNavController().navigate(action)
        }

    }

}