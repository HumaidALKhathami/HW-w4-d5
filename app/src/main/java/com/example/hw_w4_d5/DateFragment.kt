package com.example.hw_w4_d5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import java.util.*

const val DATE_KEY = "dateKey"

class DateFragment : Fragment() {

    private lateinit var dateTv : TextView
    private lateinit var dateBtn : Button

    private var date = Date()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_date, container, false)

        dateTv = view.findViewById(R.id.date_tv)
        dateBtn = view.findViewById(R.id.date_btn)


        dateBtn.text = date.toString()




        return view
    }

    override fun onStart() {
        super.onStart()


        dateBtn.setOnClickListener{

            val args = Bundle()

            args.putSerializable(DATE_KEY,date)

            val datePicker = DatePickerDialog()

            datePicker.arguments = args
            datePicker.setTargetFragment(this,0)

            datePicker.show(this.parentFragmentManager, "datePicker")

            dateTv.text = date.toString()

        }

    }


}