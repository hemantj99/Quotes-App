package com.hemant.ShareQuotes;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import android.os.Bundle;
import android.view.WindowManager;
import com.hemant.ShareQuotes.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this , MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}
