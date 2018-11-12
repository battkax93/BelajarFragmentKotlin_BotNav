package sunny.belajarfragmentkotlin.feature.activity

import android.graphics.Color
import android.graphics.PorterDuff
import android.support.v7.widget.CardView
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import sunny.belajarfragmentkotlin.R

class DetailUI : AnkoComponent<DetailActivity> {

    lateinit var profilePic: ImageView
    lateinit var userId: TextView
    lateinit var displayName: TextView
    lateinit var userType: TextView
    lateinit var cv: CardView

    override fun createView(ui: AnkoContext<DetailActivity>): View = with(ui) {
        verticalLayout {
            gravity = Gravity.CENTER_VERTICAL
            lparams(matchParent, matchParent)
            padding = dip(15)

            cv = cardView {
                lparams(matchParent, wrapContent) {
                    margin = dip(5)
                }
                elevation = dip(2).toFloat()
                radius = dip(5).toFloat()
                background.setColorFilter(resources.getColor(R.color.white), PorterDuff.Mode.SRC_ATOP)

                verticalLayout {
                    gravity = Gravity.CENTER_VERTICAL
                    lparams(matchParent, matchParent)
                    padding = dip(15)

                    profilePic = imageView().lparams(matchParent, matchParent)
                    displayName = textView().lparams(wrapContent, wrapContent)
                    userId = textView().lparams(wrapContent, wrapContent)
                    userType = textView().lparams(wrapContent, wrapContent)

                }
            }
        }
    }
}

