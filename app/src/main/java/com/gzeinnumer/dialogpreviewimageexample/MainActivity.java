package com.gzeinnumer.dialogpreviewimageexample;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.gzeinnumer.dpi.DialogPreviewImage;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.img);
        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(v -> {
            String imgUrl = "https://avatars3.githubusercontent.com/u/45892408?s=460&u=94158c6479290600dcc39bc0a52c74e4971320fc&v=4";
            Glide.with(getApplicationContext()).load(imgUrl).error(R.mipmap.ic_launcher).into(imageView);
        });
        imageView.setOnClickListener(v -> {
            Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();

//                Bitmap
            new DialogPreviewImage(getSupportFragmentManager()).setImage(bitmap).show();

//                Path
//                new DialogPreviewImage(getSupportFragmentManager()).setImage("path").show();

//                Add Content
//                new DialogPreviewImage(getSupportFragmentManager()).setImage(bitmap).setContent("ini content").show();

//                Enable Zoom
//                new DialogPreviewImage(getSupportFragmentManager()).setImage(bitmap).setContent("ini content").enableZoom().show();
        });
    }
}