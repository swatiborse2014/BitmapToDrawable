package com.example.mydrawabletobitmap;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends Activity {
    private final static String TAG = "MainActivity";
    private RecyclerView recyDrawableName;
    private AssetManager assetManager;
    String[] imgPath;
    private Button button1;
    InputStream is;
    ShowImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyDrawableName = (RecyclerView) findViewById(R.id.recyDrawableName);
        assetManager = getAssets();

        List<Model> data = listAllImages(assetManager, imgPath, is);
        adapter = new ShowImageAdapter(data);
        recyDrawableName.setHasFixedSize(true);
        recyDrawableName.setLayoutManager(new LinearLayoutManager(this));
        recyDrawableName.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public List<Model> listAllImages(AssetManager assetManager, String[] imgPath, InputStream is) {
        List<Model> data = new ArrayList<>();
        Model model = new Model();
        try {
            imgPath = assetManager.list("img");
            for (int i = 0; i < imgPath.length; i++) {
                is = assetManager.open("img/" + imgPath[i]);
                Bitmap bitmap = BitmapFactory.decodeStream(is);
                model = new Model(imgPath[i],bitmap);
                data.add(model);
                Log.d(TAG, model.getName());
            }
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
        }
        return data;
    }
}