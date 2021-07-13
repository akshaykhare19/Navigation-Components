package com.learning.navigatingfragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.navOptions
import com.learning.navigatingfragments.R


/**
 * A simple [Fragment] subclass.
 * Use the [Fragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)
        val button = view.findViewById<Button>(R.id.fragment_2_btn)

        button.setOnClickListener {

            //send data from fragment 1 to fragment 2
            val frag2data: EditText = view.findViewById(R.id.data)
            val data = frag2data.text.toString()
            val action = Fragment1Directions.actionFragment1ToFragment2(data)

            view.findNavController().navigate(action)

//            navOptions{
//                //To remove all the backstack when the user comes back to fragment 1
//                NavOptions.Builder().setPopUpTo(R.id.fragment1, true).build()
//            }
        }

    }

}