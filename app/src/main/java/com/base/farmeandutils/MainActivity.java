package com.base.farmeandutils;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.base.farmeandutils.processprotect.LocalService;
import com.base.farmeandutils.processprotect.MyJobService;

@Route(path ="/app/main")
public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        Log.e("Main","主模块");
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText("测试跳转");
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/compeoentone/main").navigation();
            }
        });

        startService(new Intent(this,LocalService.class));
        startService(new Intent(this,LocalService.class));
        MyJobService.startJob(this);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
}
