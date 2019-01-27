package com.oksana.trubina.weatherforecast.Screens.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.oksana.trubina.weatherforecast.R;

import java.util.Random;

import static android.view.View.GONE;

public class CityWeather extends AppCompatActivity {

    int temperature = new Random().nextInt(100) - 50;
    int wind = new Random().nextInt(20);
    int humidity = new Random().nextInt(100);
    String[] precipitation = {"ясно", "облачно", "снег", "дождь"};
    int precipitationItem = new Random().nextInt(precipitation.length) + 1;
    String precipitationInCity = precipitation[precipitationItem];
    String temperatureValue = String.valueOf(temperature + " °C");
    String windValue = String.valueOf(wind + " м/с");
    String humidityValue = String.valueOf(humidity + " %");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_view);

        TextView cityNameTW = findViewById(R.id.city_name_text);
        Intent intent = getIntent();
        String cityName = intent.getStringExtra("cityName");
        cityNameTW.setText(cityName);



        Boolean temperatureVision = intent.getBooleanExtra("checkedTem", false);
        FrameLayout temp = findViewById(R.id.frame_tem);
        if (temperatureVision) {
            temp.setVisibility(View.VISIBLE);
        } else {temp.setVisibility(GONE);};

        Boolean windVision = intent.getBooleanExtra("checkedWind", false);
        FrameLayout wind = findViewById(R.id.frame_wind);
        if (!windVision) {
            wind.setVisibility(View.GONE);
        } ;

        Boolean humidityVision = intent.getBooleanExtra("checkedHum", false);
        FrameLayout hum = findViewById(R.id.frame_hum);
        if (!humidityVision) {
            hum.setVisibility(View.GONE);
        } ;

        Boolean precipitationVision = intent.getBooleanExtra("checkedPrec", false);
        FrameLayout prec = findViewById(R.id.frame_prec);
        if (!precipitationVision) {
            prec.setVisibility(View.GONE);
        } ;


        TextView temperatureValueTW = findViewById(R.id.criteria_value_temperature);
        temperatureValueTW.setText(temperatureValue);
        TextView windValueTW = findViewById(R.id.criteria_value_wind);
        windValueTW.setText(windValue);
        TextView humidityValueTW = findViewById(R.id.criteria_value_humidity);
        humidityValueTW.setText(humidityValue);
        TextView precipitationValue = findViewById(R.id.criteria_value_precipitation);
        precipitationValue.setText(precipitationInCity);
    }
}
