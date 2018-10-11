package com.example.strive.messageinfo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.example.strive.messageinfo.R;

public class FunctionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = findViewById(R.id.title);
        view.setVisibility(view.GONE);
        setContentView(R.layout.activity_function);

        Display display = getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.height = (int) (display.getHeight()*0.35);
        params.width = (int) (display.getHeight()*1.0);
        params.alpha = 1.0f;
        params.dimAmount = 0.4f;
        getWindow().setAttributes(params);
    }
}
