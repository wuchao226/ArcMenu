package com.wuc.imooc;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class VerticalMenuActivity extends AppCompatActivity implements View.OnClickListener {

    private int[] res = new int[]{R.id.image_a, R.id.image_b, R.id.image_c, R.id.image_d,
            R.id.image_e, R.id.image_f, R.id.image_g, R.id.image_h};

    private List<AppCompatImageView> mImageViews = new ArrayList<>();

    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_menu);
        for (int i = 0; i < res.length; i++) {
            AppCompatImageView imageView = findViewById(res[i]);
            imageView.setOnClickListener(this);
            mImageViews.add(imageView);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_a:
                if (flag) {
                    startAnim();
                } else {
                    stopAnim();
                }
                break;
            default:
                Toast.makeText(this, "click" + view.getId(), Toast.LENGTH_LONG).show();
                break;
        }
    }

    private void startAnim() {
        for (int i = 1; i < res.length; i++) {
            ObjectAnimator animator = ObjectAnimator.ofFloat(mImageViews.get(i),
                    "translationY", 0L, i * 120);
            animator.setInterpolator(new LinearInterpolator());
            animator.setStartDelay(i * 300);
            animator.setDuration(500);
            animator.start();
        }
        flag = false;
    }

    private void stopAnim() {
        for (int i = 1; i < res.length; i++) {
            ObjectAnimator animator = ObjectAnimator.ofFloat(mImageViews.get(i),
                    "translationY", i * 150, 0L);
            animator.setInterpolator(new LinearInterpolator());
            animator.setStartDelay(i * 300);
            animator.setDuration(500);
            animator.start();
        }
        flag = true;
    }
}
