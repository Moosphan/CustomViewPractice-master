package com.moos.practice.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.moos.practice.R;

/**
 * by moos on 2018/03/04
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button1_1,button1_2,button1_3,button1_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView(){
        button1_1 = findViewById(R.id.practice1_1);
        button1_2 = findViewById(R.id.practice1_2);
        button1_3 = findViewById(R.id.practice1_3);
        button1_4 = findViewById(R.id.practice1_4);
        button1_1.setOnClickListener(this);
        button1_2.setOnClickListener(this);
        button1_3.setOnClickListener(this);
        button1_4.setOnClickListener(this);
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

            case R.id.practice1_3:
                Intent intent1_3 = new Intent(this,Practice1_3Activity.class);
                startActivity(intent1_3);
                break;

            case R.id.practice1_4:
                Intent intent1_4 = new Intent(this,Practice1_4Activity.class);
                startActivity(intent1_4);
                break;

        }
    }
}
