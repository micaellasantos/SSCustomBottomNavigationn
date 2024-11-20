package com.sscustombottomnavigation.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.sscustombottomnavigation.R
import java.util.Calendar

class TourFragment : Fragment() {

    private lateinit var dateInput: EditText
    private lateinit var timeInput: EditText
    private lateinit var schoolInput: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tour, container, false)

        dateInput = view.findViewById(R.id.dateInput)
        timeInput = view.findViewById(R.id.timeInput)
        schoolInput = view.findViewById(R.id.schoolInput)
        val submitButton: Button = view.findViewById(R.id.submitButton)

        dateInput.setOnClickListener {
            showDatePickerDialog()
        }

        timeInput.setOnClickListener {
            showTimePickerDialog()
        }

        submitButton.setOnClickListener {
            // Handle reservation logic here
            val first = view.findViewById<EditText>(R.id.firstnameInput).text.toString()
            val last = view.findViewById<EditText>(R.id.lastnameInput).text.toString()
            val email = view.findViewById<EditText>(R.id.emailInput).text.toString()
            val date = dateInput.text.toString()
            val time = timeInput.text.toString()
            val school = schoolInput.text.toString()

            // You can now use these values to make a reservation
        }

        return view
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(requireContext(), { _, selectedYear, selectedMonth, selectedDay ->
            // Set the selected date in the EditText
            dateInput.setText("$selectedDay/${selectedMonth + 1}/$selectedYear")
        }, year, month, day)

        datePickerDialog.show()
    }

    private fun showTimePickerDialog() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(requireContext(), { _, selectedHour, selectedMinute ->
            // Set the selected time in the EditText
            timeInput.setText(String.format("%02d:%02d", selectedHour, selectedMinute))
        }, hour, minute, true)

        timePickerDialog.show()
    }
}