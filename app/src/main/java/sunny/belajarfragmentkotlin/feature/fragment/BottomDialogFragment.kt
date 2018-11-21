package sunny.belajarfragmentkotlin.feature.fragment

import android.os.Bundle
import android.support.annotation.Nullable
import android.view.ViewGroup
import android.view.LayoutInflater
import android.support.design.widget.BottomSheetDialogFragment
import android.view.View
import sunny.belajarfragmentkotlin.R


class AddPhotoBottomDialogFragment : BottomSheetDialogFragment() {

    @Nullable
    override fun onCreateView(inflater: LayoutInflater,
                              @Nullable container: ViewGroup?,
                              @Nullable savedInstanceState: Bundle?): View? {

// get the views and attach the listener

        return inflater.inflate(R.layout.content_bottom_sheet, container,
                false)

    }

    companion object {

        fun newInstance(): AddPhotoBottomDialogFragment {
            return AddPhotoBottomDialogFragment()
        }
    }
}