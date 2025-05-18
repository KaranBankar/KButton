package com.karan.kbutton

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

import android.content.res.Resources

val Int.dp: Float
    get() = this * Resources.getSystem().displayMetrics.density


class KButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyle: Int = 0
) : CardView(context, attrs, defStyle) {

    private val textView = AppCompatTextView(context)

    init {
        radius = 10.dp
        elevation = 6.dp
        setCardBackgroundColor(Color.parseColor("#6200EE"))
        isClickable = true
        isFocusable = true

        val ripple = TypedValue()
        context.theme.resolveAttribute(android.R.attr.selectableItemBackground, ripple, true)
        foreground = ContextCompat.getDrawable(context, ripple.resourceId)

        textView.apply {
            gravity = Gravity.CENTER
            setTextColor(Color.WHITE)
            textSize = 16f
            typeface = Typeface.DEFAULT_BOLD
            layoutParams = LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER
            }
        }

        addView(textView)

        setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> animate().scaleX(0.95f).scaleY(0.95f).setDuration(100).start()
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> animate().scaleX(1f).scaleY(1f).setDuration(100).start()
            }
            false
        }

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.KButton)
            val text = typedArray.getString(R.styleable.KButton_kbutton_text) ?: "KButton"
            textView.text = text
            typedArray.recycle()
        }
    }

    fun setText(text: String) {
        textView.text = text
    }

    fun setButtonColor(color: Int) {
        setCardBackgroundColor(color)
    }

    fun setTextColor(color: Int) {
        textView.setTextColor(color)
    }

    fun setTextSize(sp: Float) {
        textView.textSize = sp
    }
}
