package uz.sanjar.weatheruz.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import uz.sanjar.weatheruz.R
import uz.sanjar.weatheruz.core.cache.CityCache

class CitiesSheetFragment : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.cities_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<LinearLayout>(R.id.tashkent).setOnClickListener(View.OnClickListener {
            Toast.makeText(view.context, "Tashkent", Toast.LENGTH_SHORT).show()
            CityCache.getCache().city = "tashkent"
        })
        view.findViewById<LinearLayout>(R.id.andijan).setOnClickListener(View.OnClickListener {
            Toast.makeText(view.context, "Andijan", Toast.LENGTH_SHORT).show()
            CityCache.getCache().city = "andijon"
        })
        view.findViewById<LinearLayout>(R.id.fargana).setOnClickListener(View.OnClickListener {
            Toast.makeText(view.context, "Fargana", Toast.LENGTH_SHORT).show()
            CityCache.getCache().city = "fargana"
        })
        view.findViewById<LinearLayout>(R.id.namangan).setOnClickListener(View.OnClickListener {
            Toast.makeText(view.context, "Namangan", Toast.LENGTH_SHORT).show()
            CityCache.getCache().city = "namangan"
        })
        view.findViewById<LinearLayout>(R.id.sirdaryo).setOnClickListener(View.OnClickListener {
            Toast.makeText(view.context, "Sirdaryo", Toast.LENGTH_SHORT).show()
            CityCache.getCache().city = "sirdaryo"
        })
        view.findViewById<LinearLayout>(R.id.jizzakh).setOnClickListener(View.OnClickListener {
            Toast.makeText(view.context, "Jizzakh", Toast.LENGTH_SHORT).show()
            CityCache.getCache().city = "jizzakh"
        })
        view.findViewById<LinearLayout>(R.id.samarqand).setOnClickListener(View.OnClickListener {
            Toast.makeText(view.context, "Samarkand", Toast.LENGTH_SHORT).show()
            CityCache.getCache().city = "samarqand"
        })
        view.findViewById<LinearLayout>(R.id.qashqadaryo).setOnClickListener(View.OnClickListener {
            Toast.makeText(view.context, "Qashqadaryo", Toast.LENGTH_SHORT).show()
            CityCache.getCache().city = "qashqadaryo"
        })
        view.findViewById<LinearLayout>(R.id.surkhandaryo).setOnClickListener(View.OnClickListener {
            Toast.makeText(view.context, "Surkhandaryo", Toast.LENGTH_SHORT).show()
            CityCache.getCache().city = "surhandaryo"
        })
        view.findViewById<LinearLayout>(R.id.navoiy).setOnClickListener(View.OnClickListener {
            Toast.makeText(view.context, "Navoiy", Toast.LENGTH_SHORT).show()
            CityCache.getCache().city = "navoiy"
        })
        view.findViewById<LinearLayout>(R.id.bukhara).setOnClickListener(View.OnClickListener {
            Toast.makeText(view.context, "Bukhara", Toast.LENGTH_SHORT).show()
            CityCache.getCache().city = "buxoro"
        })

        view.findViewById<LinearLayout>(R.id.khorazm).setOnClickListener(View.OnClickListener {
            Toast.makeText(view.context, "Khorazm", Toast.LENGTH_SHORT).show()
            CityCache.getCache().city = "xorazm"
        })
        view.findViewById<LinearLayout>(R.id.qoraqalpogiston)
            .setOnClickListener(View.OnClickListener {
                Toast.makeText(view.context, "Karakalpakstan", Toast.LENGTH_SHORT).show()
                CityCache.getCache().city = "qoraqalpoq"
            })

    }

}