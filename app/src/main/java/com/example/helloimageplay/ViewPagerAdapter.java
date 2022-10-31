package com.example.helloimageplay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private int[] datas;

    public ViewPagerAdapter(Context context, int[] datas) {
        this.context = context;
        this.datas = datas;
        layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
//        return datas.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    //渲染每一頁的數據
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View layout = layoutInflater.inflate(R.layout.viewpager_item, null);
        ImageView iv = (ImageView) layout.findViewById(R.id.item_iv);
//        iv.setImageResource(datas[position]);
        //設置顯示加載中等待圖片
        iv.setImageResource(R.drawable.images5);
        //AsyncTask 加載圖片
        BitmapTask bitmapTask = new BitmapTask(context,iv);
        bitmapTask.execute(datas[position % datas.length]);
        //取餘數 效果 0-1-2-3-0-1-2-3-0-1-2-3
        container.addView(layout);


        return layout;
    }
}
