package br.com.renner.app.ui.components

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import br.com.renner.app.R

class CustomButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var type = Type.RED

    init {
        val a = getContext().theme.obtainStyledAttributes(
            attrs, R.styleable.CustomButton,
            0, 0
        )

        type = Type.values()[a.getInt(R.styleable.CustomButton_type, 0)]

        when (type) {
            Type.RED -> {
                val view = View.inflate(context, R.layout.custom_button_red, this)
                val txtTitle = view.findViewById<TextView>(R.id.title)
                val txtSubtitle = view.findViewById<TextView>(R.id.subtitle)
                txtTitle.text = a.getString(R.styleable.CustomButton_title)
                txtSubtitle.text = a.getString(R.styleable.CustomButton_subtitle)
            }
            else -> {
                val view = View.inflate(context, R.layout.custom_button_grey, this)
                val txtTitle = view.findViewById<TextView>(R.id.title)
                val txtSubtitle = view.findViewById<TextView>(R.id.subtitle)
                txtTitle.text = a.getString(R.styleable.CustomButton_title)
                txtSubtitle.text = a.getString(R.styleable.CustomButton_subtitle)
            }
        }

    }

    private enum class Type {
        RED, GREY
    }
}