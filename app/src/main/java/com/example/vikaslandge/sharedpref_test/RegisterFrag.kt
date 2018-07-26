package com.example.vikaslandge.sharedpref_test

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.register_frag.*
import kotlinx.android.synthetic.main.register_frag.view.*

class RegisterFrag : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var v = inflater.inflate(R.layout.register_frag,container,false)

        v.registerbtn.setOnClickListener{

            var sprf =activity!!.getSharedPreferences("sprf",Context.MODE_PRIVATE)
            var spre = sprf.edit()

            spre.putString("uname",et1.text.toString())
            spre.putString("passwd",et2.text.toString())
            spre.putString("email",et3.text.toString())
            spre.putString("mob",et4.text.toString())
            spre.commit()

            var fmanager = activity!!.supportFragmentManager
            var tx = fmanager.beginTransaction()
            tx.replace(R.id.frag1, LoginFrag())
            //tx.addToBackStack(null)
            tx.commit()
        }

        return v
    }
}