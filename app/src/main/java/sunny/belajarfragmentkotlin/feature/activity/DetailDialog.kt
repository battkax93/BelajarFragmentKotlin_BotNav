package sunny.belajarfragmentkotlin.feature.activity

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.setContentView
import sunny.belajarfragmentkotlin.R

/**
 * Created by Wayan-MECS on 11/12/2018.
 */
class DetailDialog {

    fun showDialog(context: Context, urlAva: String, name: String, userId: String, userType: String) {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.detail_dialog)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val ivAva = dialog.findViewById<ImageView>(R.id.iv_ava2)
        val tvDisplayName = dialog.findViewById<TextView>(R.id.display_name2)
        val tvUserType = dialog.findViewById<TextView>(R.id.user_type2)
        val tvUserID = dialog.findViewById<TextView>(R.id.user_id2)

        Picasso.get().load(urlAva).into(ivAva)
        tvDisplayName.text = name
        tvUserType.text = userType
        tvUserID.text = userId
        dialog.show()
    }

}