package sunny.belajarfragmentkotlin.feature

import android.annotation.TargetApi
import android.os.Build
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.view.animation.TranslateAnimation
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo

class GestureListener(var v: View, var value: Boolean) : GestureDetector.SimpleOnGestureListener() {

    val TAG = "GestureListener"

    // BEGIN_INCLUDE(init_gestureListener)
    override fun onSingleTapUp(e: MotionEvent): Boolean {
        // Up motion completing a single tap occurred.
        Log.i(TAG, "Single Tap Up" + getTouchType(e))
        return false
    }

    override fun onLongPress(e: MotionEvent) {
        // Touch has been long enough to indicate a long press.
        // Does not indicate motion is complete yet (no up event necessarily)
        Log.i(TAG, "Long Press" + getTouchType(e))
    }

    override fun onScroll(e1: MotionEvent, e2: MotionEvent, distanceX: Float,
                          distanceY: Float): Boolean {
        // User attempted to scroll
        Log.i(TAG, "Scroll" + getTouchType(e1))
        animateViewDown(v)
//        v.visibility = View.GONE
        return false
    }

    override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float,
                         velocityY: Float): Boolean {
        // Fling event occurred.  Notification of this one happens after an "up" event.
        Log.i(TAG, "Fling" + getTouchType(e1))
        return false
    }

    override fun onShowPress(e: MotionEvent) {
        // User performed a down event, and hasn't moved yet.
        Log.i(TAG, "Show Press" + getTouchType(e))
        if (!value) {
            slideDown(v)
        } else {
            slideUp(v)
        }
    }

    override fun onDown(e: MotionEvent): Boolean {
        // "Down" event - User touched the screen.
        Log.i(TAG, "Down" + getTouchType(e))
        return false
    }

    override fun onDoubleTap(e: MotionEvent): Boolean {
        // User tapped the screen twice.
        Log.i(TAG, "Double tap" + getTouchType(e))
        return false
    }

    override fun onDoubleTapEvent(e: MotionEvent): Boolean {
        // Since double-tap is actually several events which are considered one aggregate
        // gesture, there's a separate callback for an individual event within the doubletap
        // occurring.  This occurs for down, up, and move.
        Log.i(TAG, "Event within double tap" + getTouchType(e))
        return false
    }

    override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
        // A confirmed single-tap event has occurred.  Only called when the detector has
        // determined that the first tap stands alone, and is not part of a double tap.
        Log.i(TAG, "Single tap confirmed" + getTouchType(e))
        return false
    }

    companion object {

        private fun getTouchType(e: MotionEvent): String {

            var touchTypeDescription = " "
            val touchType = e.getToolType(0)

            when (touchType) {
                MotionEvent.TOOL_TYPE_FINGER -> touchTypeDescription += "(finger)"
                MotionEvent.TOOL_TYPE_STYLUS -> {
                    touchTypeDescription += "(stylus, "
                    //Get some additional information about the stylus touch
                    val stylusPressure = e.pressure
                    touchTypeDescription += "pressure: " + stylusPressure

                    if (Build.VERSION.SDK_INT >= 21) {
                        touchTypeDescription += ", buttons pressed: " + getButtonsPressed(e)
                    }

                    touchTypeDescription += ")"
                }
                MotionEvent.TOOL_TYPE_ERASER -> touchTypeDescription += "(eraser)"
                MotionEvent.TOOL_TYPE_MOUSE -> touchTypeDescription += "(mouse)"
                else -> touchTypeDescription += "(unknown tool)"
            }

            return touchTypeDescription
        }

        /**
         * Returns a human-readable string listing all the stylus buttons that were pressed when the
         * input MotionEvent occurred.
         */
        @TargetApi(21)
        private fun getButtonsPressed(e: MotionEvent): String {
            var buttons = ""

            if (e.isButtonPressed(MotionEvent.BUTTON_PRIMARY)) {
                buttons += " primary"
            }

            if (e.isButtonPressed(MotionEvent.BUTTON_SECONDARY)) {
                buttons += " secondary"
            }

            if (e.isButtonPressed(MotionEvent.BUTTON_TERTIARY)) {
                buttons += " tertiary"
            }

            if (e.isButtonPressed(MotionEvent.BUTTON_BACK)) {
                buttons += " back"
            }

            if (e.isButtonPressed(MotionEvent.BUTTON_FORWARD)) {
                buttons += " forward"
            }

            if (buttons == "") {
                buttons = "none"
            }

            return buttons
        }
    }

    fun animateViewUp(v: View) {
        YoYo.with(Techniques.SlideInUp)
                .duration(1500)
                .playOn(v)
    }

    fun animateViewDown(v: View) {
        YoYo.with(Techniques.SlideInDown)
                .duration(1500)
                .pivot(0f, v.height.toFloat())
                .playOn(v)
    }

    fun slideUp(view: View) {
        val animate = TranslateAnimation(
                0f, // fromXDelta
                0f, // toXDelta
                view.height.toFloat(), // fromYDelta
                0f)                // toYDelta
        animate.duration = 1000
        animate.fillAfter = true
        view.startAnimation(animate)
    }

    fun slideDown(view: View) {
        val animate = TranslateAnimation(
                0f, // fromXDelta
                0f, // toXDelta
                0f, // fromYDelta
                view.height.toFloat()) // toYDelta
        animate.duration = 1000
        animate.fillAfter = true
        view.startAnimation(animate)
    }

}
