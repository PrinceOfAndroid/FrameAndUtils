package com.base.compoentone;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.base.baselib.ImgUtils;

import java.io.File;


@Route(path = "/compeoentone/main")
public class ModuleActivity extends AppCompatActivity {

    Bitmap inputBitmap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("sda", "组件模块");
        setContentView(R.layout.activity_module);
        TextView tvMoudle = findViewById(R.id.tv_module);
        File input = new File(Environment.getExternalStorageDirectory(), "girl.jpg");
        inputBitmap = BitmapFactory.decodeFile(input.getAbsolutePath());
        tvMoudle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImgUtils imgUtils = new ImgUtils();
                imgUtils.nativeCompress(inputBitmap, 10, Environment.getExternalStorageDirectory() + "/girl2.jpg");
                Toast.makeText(ModuleActivity.this, "执行完成", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
