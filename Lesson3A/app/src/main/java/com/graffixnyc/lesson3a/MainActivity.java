package com.graffixnyc.lesson3a;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView=new TextView(this);
        textView.setText("Bitch");
        textView.setTextColor(Color.RED);
        textView.setTextSize(22);
        setContentView(textView);
    }
}
