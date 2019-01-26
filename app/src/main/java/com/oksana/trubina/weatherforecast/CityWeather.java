package com.oksana.trubina.weatherforecast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class CityWeather extends AppCompatActivity {
//    TextView cityName = findViewById(R.id.city_name_text);
//    ImageView cityImage = findViewById(R.id.city_picture);
//    TextView date = findViewById(R.id.weather_details_date);
//    TextView temperature = findViewById(R.id.weather_details_temperature);
//    TextView precipitation = findViewById(R.id.weather_details_precipitation);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_view);
    }
}
