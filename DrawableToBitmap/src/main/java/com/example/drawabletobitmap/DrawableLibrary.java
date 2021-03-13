package com.example.drawabletobitmap;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

public class DrawableLibrary {

    public static String listAllImages(AssetManager assetManager, String[] imgPath, InputStream is) {
        try {
            imgPath = assetManager.list("img");
            for (int i = 0; i < imgPath.length; i++) {
                is = assetManager.open("img/" + imgPath[i]);
                Log.d("TAG", imgPath[i]);
                bitmapImage(is);
            }
        } catch (IOException e) {
            Log.e("TAG", e.getMessage());
        }
        return String.valueOf(is);
    }

    public static String bitmapImage(InputStream is) {
        Bitmap bitmap = BitmapFactory.decodeStream(is);
        return String.valueOf(bitmap);
    }

}
