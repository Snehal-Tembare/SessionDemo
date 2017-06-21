package com.example.synerzip.sessiondemo

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    var name: String? = null
    var mToolbar: Toolbar? = null
    var mTxtResult: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        mTxtResult = findViewById(R.id.txt_result) as TextView
        mToolbar = findViewById(R.id.toolbar) as Toolbar

        setSupportActionBar(mToolbar)
        supportActionBar!!.setTitle(getString(R.string.result))
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        mToolbar!!.setTitleTextColor(ContextCompat.getColor(this, R.color.common_white))


        val bundle = intent.extras
        if (bundle != null) {
            name = bundle.getString(getString(R.string.name))
            if (name != null)
                mTxtResult!!.text = getString(R.string.logged_in_as) + " " + name
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return true
    }

    companion object{
        fun newIntent(context:Context,name:String):Intent{
            val intent=Intent(context, ResultActivity::class.java)
            val NAME = "name"
            intent.putExtra(NAME, name)
            return intent
        }
    }
}
