package com.yasuion.opengldemo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yasuion.opengldemo1.views.GLFView;

public class MainActivity extends AppCompatActivity {

    private GLFView glfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        glfView = (GLFView) findViewById(R.id.glfview);
    }

    @Override
    protected void onResume() {
        super.onResume();
        glfView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        glfView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
