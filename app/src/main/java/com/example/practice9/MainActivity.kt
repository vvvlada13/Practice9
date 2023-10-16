package com.example.practice9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text: TextView = findViewById(R.id.textView3)
        text.setText("Copyright (C) 2021")

        val poemTextView: TextView = findViewById(R.id.textView4)
        val poemText: String = getString(R.string.poem_text)
        val poemSpannable = SpannableString(poemText)

// Установка стиля текста (жирный)
        poemSpannable.setSpan(StyleSpan(Typeface.BOLD), 0, poemText.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

// Установка размера текста (20sp)
        poemSpannable.setSpan(AbsoluteSizeSpan(20, true), 0, poemText.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

// Изменение начертания текста (курсив)
        poemSpannable.setSpan(StyleSpan(Typeface.ITALIC), 0, poemText.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

// Масштабирование отдельной строки (первая строка, заголовок)
        val titleStartIndex = 0
        val titleEndIndex = poemText.indexOf("\n") // Ищем символ перевода строки для определения конца заголовка
        poemSpannable.setSpan(RelativeSizeSpan(1.2f), titleStartIndex, titleEndIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        poemTextView.setText(poemSpannable, TextView.BufferType.SPANNABLE)
    }

}