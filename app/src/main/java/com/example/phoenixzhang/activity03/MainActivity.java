package com.example.phoenixzhang.activity03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button mButton = null;
    private EditText EditText1;
    private EditText EditText2;
    private TextView symbol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText1 = (EditText)findViewById(R.id.editText2);
        EditText2 = (EditText)findViewById(R.id.editText3);
        symbol = (TextView)findViewById(R.id.textView4);
        mButton = (Button)findViewById(R.id.button);
//      使用R.String获取字符串便于国际化。
        symbol.setText(R.string.symbol);
        mButton.setOnClickListener(new MyButtonListener());
    }

//  复写菜单menu方法，设置菜单menu菜单。这样点击menu菜单程序中就会出现菜单选项。
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//      add方法增加菜单项，参数为（组id，组件id，排序顺序id，string文字调用）
        menu.add(0,1,1,R.string.exit);
        menu.add(0,2,2,R.string.about);
        return super.onCreateOptionsMenu(menu);
    }

//  复写optionsitemselected方法去设置点击相关菜单选项后的操作。
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//      当点击1的时候，finish应用。
        if (item.getItemId() == 1){
            finish();
        } else if (item.getItemId() == 2){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    class MyButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            //生成一个intend对象
            Intent intent = new Intent();
            String Str1 = EditText1.getText().toString();
            String Str2 = EditText2.getText().toString();
            intent.putExtra("one", Str1);
            intent.putExtra("two", Str2);
            //从main请求到second
            intent.setClass(MainActivity.this, SecondActivity.class);
            MainActivity.this.startActivity(intent);
            finish();
//         如果调用finish则第二个activity back不回来,back到再往前的activity，因为相当于调用了onDestroy方法。
        }
    }
}
