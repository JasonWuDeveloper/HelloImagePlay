package com.example.helloimageplay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import androidx.core.widget.TintableImageSourceView;

public class BitmapTask extends AsyncTask<Integer,Void, Bitmap> {

    private Context context;
    private int res;
    private ImageView imageView;

    public BitmapTask(Context context, ImageView imageView) {
        this.context = context;
        this.imageView = imageView;
    }
    @Override
    protected Bitmap doInBackground(Integer... params) {
        res = params[0];
//        try {
//            Thread.sleep(2 *1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),res);
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
            imageView.setImageBitmap(bitmap);
    }
}
