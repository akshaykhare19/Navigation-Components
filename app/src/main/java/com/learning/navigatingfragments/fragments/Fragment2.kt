package com.learning.navigatingfragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.learning.navigatingfragments.R


/**
 * A simple [Fragment] subclass.
 * Use the [Fragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment2 : Fragment() {

    val args: Fragment2Args by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //receive data from fragment 1
        val receivedData: TextView = view.findViewById(R.id.data_received2)
        val data1 = args.message
        receivedData.text = data1

        //navigate to fragment 3
        val button = view.findViewById<Button>(R.id.fragment_3_btn)

        button.setOnClickListener {

            //To send data from fragment 2 to fragment 3
            val frag3data: EditText = view.findViewById(R.id.data2)
            val data = frag3data.text.toString()
            val action = Fragment2Directions.actionFragment2ToFragment3(data)

            //To navigate from fragment 2 to fragment 3
            view.findNavController().navigate(action)


        }

    }

}