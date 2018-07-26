package com.example.vikaslandge.sharedpref_test

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.login_frag.*
import android.widget.Toast
import kotlinx.android.synthetic.main.login_frag.view.*

class LoginFrag : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var v = inflater.inflate(R.layout.login_frag,container,false)

        v.registerbtn.setOnClickListener{
            val fmanager = activity!!.supportFragmentManager
            var tx = fmanager.beginTransaction()
            tx.replace(R.id.frag1,RegisterFrag())
            tx.addToBackStack(null)
            tx.commit()

        }
        v.loginbtn.setOnClickListener{
            var sprf = activity!!.getSharedPreferences("sprf",Context.MODE_PRIVATE)
            var uname = sprf.getString("uname","")
            var passwd = sprf.getString("passwd","")
                if (uname.equals(v.et1.text.toString()) && passwd.equals(v.et2.text.toString())){

                    var fmanager = activity!!.supportFragmentManager
                    var tx = fmanager.beginTransaction()
                    tx.replace(R.id.frag1, WelcomeFrag())
                    tx.addToBackStack(null)
                    tx.commit()
            }else{
                    Toast.makeText(activity,"login credential is wrong",Toast.LENGTH_LONG).show()
                }
        }
        return v
    }
}