package com.example.synerzip.sessiondemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 * Created by Snehal Tembare on 21/6/17.
 * Copyright © 2017 Synerzip. All rights reserved
 */

public class MainActivityJava extends AppCompatActivity {

    @BindView(R.id.toolbar)
    protected Toolbar mToolbar;

    @BindView(R.id.edt_user_name)
    protected EditText mEdtUserName;

    @BindView(R.id.edt_pwd)
    protected EditText mEdtPwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(getString(R.string.app_name));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.common_white));
        mEdtPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    @OnClick(R.id.btn_log_in)
    public void logIn() {
        if (!mEdtUserName.getText().toString().isEmpty() && !mEdtPwd.getText().toString().isEmpty()) {
            Intent intent=new Intent(this,ResultActivity.class);
            intent.putExtra(getString(R.string.name),mEdtUserName.getText().toString());
            intent.putExtra(getString(R.string.password),mEdtPwd.getText().toString());
            startActivity(intent);
        }else {
            Toast.makeText(getApplicationContext(), getString(R.string.please_enter_data),
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mEdtPwd.setText("");
        mEdtUserName.setText("");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }

}