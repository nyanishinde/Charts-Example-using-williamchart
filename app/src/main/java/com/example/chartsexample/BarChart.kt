package com.example.chartsexample

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.db.williamchart.view.BarChartView

class BarChart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bar_chart)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val barChart : BarChartView = findViewById(R.id.chart)

        barChart.animation.duration = animationDuaration
        barChart.animate(barSet)
        barChart.spacing = 80.0f
        barChart.labelsSize=32.0f

    }
    companion object{
        private val barSet = listOf(
            "Mon" to 5.0f,
            "Tue" to 5.3f,
            "Wed" to 4.2f,
            "Thurs" to 6.5f,
            "Fri" to 3.7f,
            "Sat" to 1.0f,
            "Sun" to 0.0f
        )
        private const val animationDuaration = 1000L
    }
}