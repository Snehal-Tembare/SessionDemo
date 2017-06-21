package com.example.synerzip.sessiondemo

import android.content.Intent
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

open class MainActivity : AppCompatActivity() {

    var mToolbar: Toolbar? = null
    var mEdtUserName: EditText? = null
    var mEdtPwd: EditText? = null
    var mBtnLogIn: Button? = null
    var string: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mToolbar = findViewById(R.id.toolbar) as Toolbar
        mBtnLogIn = findViewById(R.id.btn_log_in) as Button
        mEdtUserName = findViewById(R.id.edt_user_name) as EditText
        mEdtPwd = findViewById(R.id.edt_pwd) as EditText

        setSupportActionBar(mToolbar)
        supportActionBar!!.setTitle(getString(R.string.app_name))
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        mToolbar!!.setTitleTextColor(ContextCompat.getColor(this, R.color.common_white))

        mBtnLogIn!!.setOnClickListener {

            if (!mEdtUserName!!.text.toString().isEmpty() && !mEdtPwd!!.text.toString().isEmpty()) {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(getString(R.string.name), mEdtUserName!!.text.toString())
                intent.putExtra(getString(R.string.password), mEdtPwd!!.text.toString())
                string=mEdtPwd!!.getText().toString()
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext, getString(R.string.please_enter_data),
                        Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onResume() {
        super.onResume()
        mEdtUserName!!.setText("")
        mEdtPwd!!.setText("")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return true
    }

  }
