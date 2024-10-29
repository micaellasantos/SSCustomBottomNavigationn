package com.sscustombottomnavigation.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.sscustombottomnavigation.R

class CoursesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_courses, container, false)

        val btnShowMore: Button = view.findViewById(R.id.btnShowMore)
        btnShowMore.setOnClickListener {
            openUrl("https://ntc-erp.campus-erp.com/Admission/OLAdmission.php")
        }

        val btnShowMore2: Button = view.findViewById(R.id.btnShowMore2)
        btnShowMore2.setOnClickListener {
            openUrl("https://ntc-erp.campus-erp.com/Admission/OLAdmission.php")
        }

        val btnShowMore3: Button = view.findViewById(R.id.btnShowMore3)
        btnShowMore3.setOnClickListener {
            openUrl("https://ntc-erp.campus-erp.com/Admission/OLAdmission.php")
        }

        val btnShowMore4: Button = view.findViewById(R.id.btnShowMore4)
        btnShowMore4.setOnClickListener {
            openUrl("https://ntc-erp.campus-erp.com/Admission/OLAdmission.php")
        }

        val btnShowMore5: Button = view.findViewById(R.id.btnShowMore5)
        btnShowMore5.setOnClickListener {
            openUrl("https://ntc-erp.campus-erp.com/Admission/OLAdmission.php")
        }

        val btnShowMore6: Button = view.findViewById(R.id.btnShowMore6)
        btnShowMore6.setOnClickListener {
            openUrl("https://ntc-erp.campus-erp.com/Admission/OLAdmission.php")
        }

        val btnShowMore7: Button = view.findViewById(R.id.btnShowMore7)
        btnShowMore7.setOnClickListener {
            openUrl("https://ntc-erp.campus-erp.com/Admission/OLAdmission.php")
        }

        return view
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)

        startActivity(intent)
    }
}
