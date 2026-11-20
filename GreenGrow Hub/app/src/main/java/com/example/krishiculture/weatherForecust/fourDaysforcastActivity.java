package com.example.krishiculture.weatherForecust;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.krishiculture.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class fourDaysforcastActivity extends AppCompatActivity {
    private TextView[] days = new TextView[5];
    private ImageView[] weatherLogos = new ImageView[5];
    private TextView[] weatherDescriptions = new TextView[5];
    private TextView[] maxTemps = new TextView[5];
    private TextView[] minTemps = new TextView[5];
    private TextView today, cityname;

    //https://api.openweathermap.org/data/2.5/forecast?q=barasat&appid=be504fe48503424158bd54d0590723f2

    private final String API_KEY = "74955d1d4c857e6209a6639ba67d96b6"; // Replace with your API key
    private final String BASE_URL = "https://api.openweathermap.org/data/2.5/forecast?q=";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_four_daysforcust);

        // Retrieve the passed string
        String receivedString = getIntent().getStringExtra("EXTRA_KEY");
        String receivedTemp = getIntent().getStringExtra("Temp");
        today = findViewById(R.id.today);
        today.setText(receivedTemp);
        cityname = findViewById(R.id.cityname);
        cityname.setText(receivedString);

        // Bind arrays
        int[] dayIds = {R.id.day1, R.id.day2, R.id.day3, R.id.day4, R.id.day5};
        int[] logoIds = {R.id.logo1, R.id.logo2, R.id.logo3, R.id.logo4, R.id.logo5};
        int[] weatherIds = {R.id.weather1, R.id.weather2, R.id.weather3, R.id.weather4, R.id.weather5};
        int[] maxTempIds = {R.id.max1, R.id.max2, R.id.max3, R.id.max4, R.id.max5};
        int[] minTempIds = {R.id.min1, R.id.min2, R.id.min3, R.id.min4, R.id.min5};

        for (int i = 0; i < 5; i++) {
            days[i] = findViewById(dayIds[i]);
            weatherLogos[i] = findViewById(logoIds[i]);
            weatherDescriptions[i] = findViewById(weatherIds[i]);
            maxTemps[i] = findViewById(maxTempIds[i]);
            minTemps[i] = findViewById(minTempIds[i]);
        }

        fetchWeatherData(receivedString);
    }
    private void fetchWeatherData(String city) {
        OkHttpClient client = new OkHttpClient();
        String url = BASE_URL + city + "&appid=" + API_KEY;

        Request request = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(() -> Toast.makeText(fourDaysforcastActivity.this, "Failed to get data", Toast.LENGTH_SHORT).show());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String responseData = response.body().string();
                    try {
                        JSONObject jsonObject = new JSONObject(responseData);
                        JSONArray list = jsonObject.getJSONArray("list");

                        runOnUiThread(() -> {
                            for (int i = 0; i < 5; i++) {
                                int index = i * 8; // Approx. every 24 hours
                                if (index >= list.length()) break;

                                try {
                                    JSONObject dayData = list.getJSONObject(index);
//                                    String dateTime = dayData.getString("dt_txt").split(" ")[0]; //for display only date
                                    long unixTime = dayData.getLong("dt"); // Get UNIX timestamp
                                    String dayStr = convertTimestampToDay(unixTime);//convert to days
                                    JSONObject main = dayData.getJSONObject("main");
                                    String tempMax = String.format("%.1f", main.getDouble("temp_max") - 273.15) + " °C";
                                    String tempMin = String.format("%.1f", main.getDouble("temp_min") - 273.15) + " °C";
                                    String weatherDesc = dayData.getJSONArray("weather").getJSONObject(0).getString("description");

//                                    days[i].setText(dateTime);
                                    days[i].setText(dayStr);
                                    maxTemps[i].setText(tempMax);
                                    minTemps[i].setText(tempMin);
                                    weatherDescriptions[i].setText(weatherDesc);

                                    switch (weatherDesc.toLowerCase()) {
                                        case "clear sky":
                                            weatherLogos[i].setImageDrawable(ContextCompat.getDrawable(fourDaysforcastActivity.this,R.drawable.sunny1));
                                            break;
                                        case "rain":
                                            weatherLogos[i].setImageDrawable(ContextCompat.getDrawable(fourDaysforcastActivity.this,R.drawable.rainlogo));
                                            break;
                                        case "cloud":
                                            weatherLogos[i].setImageDrawable(ContextCompat.getDrawable(fourDaysforcastActivity.this,R.drawable.cloudylogo));
                                            break;
                                        case "snow":
                                            weatherLogos[i].setImageDrawable(ContextCompat.getDrawable(fourDaysforcastActivity.this,R.drawable.snowlogo));
                                            break;
                                        case "mist":
                                            weatherLogos[i].setImageDrawable(ContextCompat.getDrawable(fourDaysforcastActivity.this,R.drawable.mistlogo));
                                            break;
                                        default:
                                            weatherLogos[i].setImageDrawable(ContextCompat.getDrawable(fourDaysforcastActivity.this,R.drawable.partlycloudy));
                                            break;

                                    }
                                } catch (Exception e) {
                                    Toast.makeText(fourDaysforcastActivity.this, "Error parsing forecast data", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    } catch (Exception e) {
                        runOnUiThread(() -> Toast.makeText(fourDaysforcastActivity.this, "Error parsing data", Toast.LENGTH_SHORT).show());
                    }
                }
            }
        });
    }


    //for day-wise fetching
    private String convertTimestampToDay(long unixTime) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("EEEE");
        java.util.Date date = new java.util.Date(unixTime * 1000L);
        return sdf.format(date);
    }
}