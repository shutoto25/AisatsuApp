package com.example.aisatsuapp

import android.app.TimePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mHourOfDay = 0
    private var mMinute = 0
    private val is24HourView = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btShowDialog.setOnClickListener {
            showTimePickerDialog()
        }
    }

    /**
     * TimePickerDialog表示.
     */
    private fun showTimePickerDialog() {

        val dialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
                setGreeting(hourOfDay)
                mHourOfDay = hourOfDay
                mMinute = minute
            },
            mHourOfDay,
            mMinute,
            is24HourView
        )
        dialog.show()
    }

    /**
     * 時刻に応じた挨拶をセット.
     *
     * @param hourOfDay Hour
     */
    private fun setGreeting(hourOfDay: Int) = when (hourOfDay) {

        // 2:00 ~ 9:59 では「おはよう」
        in 2..9 -> tvGreeting.text = "おはよう"
        // 10:00 ~ 17:59 では「こんにちは」
        in 10..17 -> tvGreeting.text = "こんにちは"
        // 18:00 ~ 1:59 では「こんばんは」
        in 18..23, 0, 1 -> tvGreeting.text = "こんばんは"
        // ありえないと思うがそれ以外
        else -> tvGreeting.text = "エラー"
    }
}

//以下の要件を満たすアプリを作成してください。
//
//画面内にButtonとTextViewを配置してください。
//ButtonをタッチするとTimePickerDialogを表示して，
//設定した時刻に応じてTextViewに表示されるあいさつを変化させてください。
//2:00 ~ 9:59 では「おはよう」
//10:00 ~ 17:59 では「こんにちは」
//18:00 ~ 1:59 では「こんばんは」
