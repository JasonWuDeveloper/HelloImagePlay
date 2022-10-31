package com.example.helloimageplay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ViewPager vp;
    private ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            vp = (ViewPager) findViewById(R.id.vp);

            viewPagerAdapter = new ViewPagerAdapter(this, Images.imageArray);
            //綁定適配器
        vp.setAdapter(viewPagerAdapter);
        //選擇一個較大的條目選中
        vp.setCurrentItem(Images.imageArray.length * 1000,true);
    }
}