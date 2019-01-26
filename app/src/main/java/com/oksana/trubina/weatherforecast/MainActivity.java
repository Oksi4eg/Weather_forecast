package com.oksana.trubina.weatherforecast;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "myLogs";

    final private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, CityWeather.class));
            Log.d(TAG, "обработка нажатия кнопки");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.open_city_weather_button);
        button.setOnClickListener(onClickListener);
        ImageView image = findViewById(R.id.general_image);
        Log.d(TAG, "найдем View-элеменеты");
    }
}
