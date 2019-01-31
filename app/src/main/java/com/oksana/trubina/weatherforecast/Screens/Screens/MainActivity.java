package com.oksana.trubina.weatherforecast.Screens.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.oksana.trubina.weatherforecast.R;

public class MainActivity<checkedTemp, Int> extends AppCompatActivity implements View.OnClickListener {

    public static String selectedMode = "day";
    public String[] cityNames;
    public String resultCityName;
    public ListView cities;
    public String statusTemp;
    public Boolean checkedTemp = false;
    public Boolean checkedWind = false;
    public Boolean checkedHum = false;
    public Boolean checkedPrec = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button night = findViewById(R.id.button_night_mode);
        Button day = findViewById(R.id.button_day_mode);
        night.setOnClickListener(checkMode);
        day.setOnClickListener(checkMode);

        ListView cities = findViewById(R.id.lv_cities);
        cities.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        ArrayAdapter<CharSequence> adapterCityList = ArrayAdapter.createFromResource(MainActivity.this,
                R.array.cities, android.R.layout.simple_list_item_single_choice);
        cities.setAdapter(adapterCityList);

//        cityNames = getResources().getStringArray(R.array.cities); - не смогла справиться с листом
//        resultCityName = cityNames[cities.getCheckedItemPosition()];

        final CheckBox temperature = findViewById(R.id.checkbox_temperature);
        temperature.setChecked(false);
        temperature.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (temperature.isChecked()) {
                    checkedTemp = isChecked;
                }
            }
        });
        final CheckBox wind = findViewById(R.id.checkbox_wind);
        wind.setChecked(false);
        wind.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (wind.isChecked()) {
                    checkedWind = isChecked;
                }
            }
        });

        final CheckBox precipitation = findViewById(R.id.checkbox_precipitation);
        precipitation.setChecked(false);
        precipitation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (precipitation.isChecked()) {
                    checkedPrec = isChecked;
                }
            }
        });
        final CheckBox humidity = findViewById(R.id.checkbox_humidity);
        humidity.setChecked(false);
        humidity.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (humidity.isChecked()) {
                    checkedHum = isChecked;
                }
            }
        });


        Button button = findViewById(R.id.button_know_the_weather);
        button.setOnClickListener(this);

    }

    View.OnClickListener checkMode = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            LinearLayout chooseMode = findViewById(R.id.layout_choose_mode);
            LinearLayout mainScreen = findViewById(R.id.layout_main_screen);
            switch (v.getId()) {

                case R.id.button_night_mode:
                     selectedMode = "night";
                    setTheme(R.style.NightTheme);
//                    setContentView(R.layout.activity_main);
                    break;
                case R.id.button_day_mode:
                     selectedMode = "day";
                    break;
            }

            chooseMode.setVisibility(View.GONE);
            mainScreen.setVisibility(View.VISIBLE);
        }
    };


    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, CityWeather.class);
//        resultCityName = cityNames[cities.getCheckedItemPosition()];
        intent.putExtra("selectedMode",selectedMode);
        intent.putExtra("cityName", "Все равно Москва");
        intent.putExtra("checkedTem", checkedTemp);
        intent.putExtra("checkedWind", checkedWind);
        intent.putExtra("checkedHum", checkedHum);
        intent.putExtra("checkedPrec", checkedPrec);
        startActivity(intent);
    }
}
