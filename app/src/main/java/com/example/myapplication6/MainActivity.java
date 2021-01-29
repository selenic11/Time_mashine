package com.example.myapplication6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MediaPlayer mediaPlayer;

    private ImageView iv_now, iv_f, iv_f2, iv_p1, iv_p2;

    private ImageButton button_f, button_p;

    TextView year;

    private TextView timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        iv_now = (ImageView) findViewById(R.id.iv_hv_now);
        iv_f = (ImageView) findViewById(R.id.iv_hv_f);
        iv_f2 = (ImageView) findViewById(R.id.iv_hv_f2);
        iv_p1 = (ImageView) findViewById(R.id.iv_hv_p1);
        iv_p2 = (ImageView) findViewById(R.id.iv_hv_p2);

        mediaPlayer = MediaPlayer.create(this,R.raw.silvestri_western_union);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);

        button_f = (ImageButton) findViewById(R.id.bottom_f);
        button_p = (ImageButton) findViewById(R.id.bottom_p);

        button_f.setOnClickListener(this);
        button_p.setOnClickListener(this);

        year = (TextView) findViewById(R.id.year);

        timer = (TextView)findViewById(R.id.timer);

        Calendar calendar = Calendar.getInstance();
        int sec = calendar.get(Calendar.SECOND);
        int min = calendar.get(Calendar.MINUTE);
        int hour = calendar.get(Calendar.HOUR);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);

        timer.setText("" + String.valueOf(day) +
                        ":" + String.valueOf(month + 1) +
                ":" + String.valueOf(hour) +
                ":" + String.valueOf(min) +
                ":" + String.valueOf(sec));

    }

    @Override
    public void onClick(View v) {

        FrameLayout view = (FrameLayout) findViewById(R.id.main_layout);

        if (v.getId() == R.id.bottom_f) {

            int s = (int) (Math.random() * 3);

            switch (s) {
                case 0:
                    view.setBackgroundResource(R.drawable.hill_valley_now_h);
                    year.setText("1985");
                    iv_f2.setScaleX(0);
                    iv_p1.setScaleX(0);
                    iv_p2.setScaleX(0);
                    iv_f.setScaleX(0);
                    break;

                case 1:
                    view.setBackgroundResource(R.drawable.hill_valley_f_h);
                    year.setText("2015");
                    iv_f2.setScaleX(0);
                    iv_p1.setScaleX(0);
                    iv_p2.setScaleX(0);
                    iv_now.setScaleX(0);
                    break;
                case 2:
                    view.setBackgroundResource(R.drawable.hill_valley_f2_h);
                    year.setText("5000");
                    iv_f.setScaleX(0);
                    iv_p1.setScaleX(0);
                    iv_p2.setScaleX(0);
                    iv_now.setScaleX(0);
                    break;
            }
        }

        if (v.getId() == R.id.bottom_p) {

            int s = (int) (Math.random() * 3);

            switch (s) {
                case 0:
                    view.setBackgroundResource(R.drawable.hill_valley_now_h);
                    year.setText("1985");
                    iv_f2.setScaleX(0);
                    iv_p1.setScaleX(0);
                    iv_p2.setScaleX(0);
                    iv_f.setScaleX(0);
                    break;

                case 1:
                    view.setBackgroundResource(R.drawable.hill_valley_past1_h);
                    year.setText("1955");
                    iv_f2.setScaleX(0);
                    iv_f.setScaleX(0);
                    iv_p2.setScaleX(0);
                    iv_now.setScaleX(0);
                    break;
                case 2:
                    view.setBackgroundResource(R.drawable.hill_valley_past2_h);
                    year.setText("1885");
                    iv_f.setScaleX(0);
                    iv_p1.setScaleX(0);
                    iv_f2.setScaleX(0);
                    iv_now.setScaleX(0);
                    break;
            }
        }

    }

    @Override
    protected void onPause() {
        mediaPlayer.stop();
        super.onPause();
    }

}
