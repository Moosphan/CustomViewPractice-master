package com.moos.practice;

import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.moos.practice.base.PageFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * by moos on 2018/03/04
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button1_1,button1_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1_1 = findViewById(R.id.practice1_1);
        button1_2 = findViewById(R.id.practice1_2);
        button1_1.setOnClickListener(this);
        button1_2.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.practice1_1:
                Intent intent1_1 = new Intent(this,Practice1_1Activity.class);
                startActivity(intent1_1);
                break;

            case R.id.practice1_2:
                Intent intent1_2 = new Intent(this,Practice1_2Activity.class);
                startActivity(intent1_2);
                break;
        }
    }
}
