package com.example.vikaslandge.sharedpref_test

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.login_frag.*
import kotlinx.android.synthetic.main.register_frag.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fmanager = supportFragmentManager
        var tx = fmanager.beginTransaction()
        tx.add(R.id.frag1,LoginFrag())
        tx.commit()

    }

}
