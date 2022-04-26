package uz.sanjar.weatheruz.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.makeramen.roundedimageview.RoundedImageView
import uz.sanjar.weatheruz.R

class BottomSheetFragment : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<RoundedImageView>(R.id.image_my).setOnClickListener(View.OnClickListener {
            val dialog = Dialog(view.context)
            dialog.show()
        })
        view.findViewById<LinearLayout>(R.id.by_gmail).setOnClickListener(View.OnClickListener {
            gotoURL("mailto:sanjarisaboyev707@gmail.com")
        })
        view.findViewById<LinearLayout>(R.id.by_intagram).setOnClickListener(View.OnClickListener {
            gotoURL("https://instagram.com/sanjar_isaboev")
        })
        view.findViewById<LinearLayout>(R.id.by_telegram).setOnClickListener(View.OnClickListener {
            gotoURL("https://t.me/sanjar_isaboev")
        })
        view.findViewById<LinearLayout>(R.id.by_you_tube).setOnClickListener(View.OnClickListener {
            gotoURL("https://www.youtube.com/channel/UC5QRaLLvGmDYWBx59GEG6-g/featured")
        })
    }

    private fun gotoURL(s: String) {
        val uri: Uri = Uri.parse(s)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent);
    }

}