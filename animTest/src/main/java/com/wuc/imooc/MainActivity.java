package com.wuc.imooc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * @author: wuchao
 * @date: 2018/7/21 23:27
 * @desciption:
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_vertical_menu).setOnClickListener(this);
        findViewById(R.id.btn_arc_menu).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_vertical_menu:
                startActivity(new Intent(this, VerticalMenuActivity.class));
                break;
            case R.id.btn_arc_menu:
                startActivity(new Intent(this, ArcMenuActivity.class));
                break;
            default:
                break;
        }
    }

}
