package com.example.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref = getPreferences(Context.MODE_PRIVATE)
        val fullname = pref.getString("FULL_NAME", "")
        val age = pref.getInt("AGE", 0)
        if (age == 0){
            eAge.setText(null)
        }else{
            eAge.setText(age.toString())
        }
        eFull_name.setText(fullname)


    }

    fun onSave(view: View) {

        val pref = getPreferences(Context.MODE_PRIVATE)
        val editor = pref.edit()

        editor.putString("FULL_NAME", eFull_name.text.toString())
        editor.putInt("AGE", eAge.text.toString().toInt())

        editor.commit()

        val toast = Toast.makeText(applicationContext, "Saved", Toast.LENGTH_LONG)
        toast.setGravity(Gravity.TOP, 0 , 1000)
        toast.show()

    }

    fun onClear(view: View) {

        val pref = getPreferences(Context.MODE_PRIVATE)
        val editor = pref.edit()

        editor.clear()
        editor.commit()

        eFull_name.setText("")
        eAge.setText(null)

    }
}
