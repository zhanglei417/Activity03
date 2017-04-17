package com.example.phoenixzhang.activity03;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView mtest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        mtest = (TextView)findViewById(R.id.textView2);
//      新建intent对象
        Intent intent = getIntent();
//      创建value获取intent中传递的相关键值队的值。
        String value1 = intent.getStringExtra("one");
        String value2 = intent.getStringExtra("two");
//      通过integer包装类方法转换string to int。
        int testvalue1 = Integer.parseInt(value1);
        int testvalue2 = Integer.parseInt(value2);
//      通过加一个空字符串将int转换为string。java的特性。
        mtest.setText(testvalue1 * testvalue2 + "");
    }

}
