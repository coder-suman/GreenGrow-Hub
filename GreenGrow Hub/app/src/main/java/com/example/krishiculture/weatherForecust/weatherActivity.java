package com.example.krishiculture.weatherForecust;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.krishiculture.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class weatherActivity extends AppCompatActivity {
    private String city;
    private String today;
    private TextView cityName, temp, weather, maxTemp, minTemp, humidityValue, windValue, feelsLike, sunrise, sunset, seaLevel, days, date;
    private SearchView searchView;
    private ImageView weatherLogo;
    private ConstraintLayout rootlayout;

    private final String API_KEY = "74955d1d4c857e6209a6639ba67d96b6"; // Replace with your API key
    private final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather?q="; // Fixed URL

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 100;

    private void checkLocationPermission() {
        fetchCurrentLocation();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                fetchCurrentLocation();
            } else {
                Toast.makeText(this, "Location permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private FusedLocationProviderClient fusedLocationProviderClient;

    private void fetchCurrentLocation() {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        // Check if location permissions are granted
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Request permissions if not granted
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION},
                    LOCATION_PERMISSION_REQUEST_CODE);
            return; // Exit until permissions are granted
        }

        // Check if location services are enabled
        android.location.LocationManager locationManager = (android.location.LocationManager) getSystemService(LOCATION_SERVICE);
        if (locationManager != null && !locationManager.isProviderEnabled(android.location.LocationManager.GPS_PROVIDER)) {
            Toast.makeText(this, "Please enable location services", Toast.LENGTH_SHORT).show();
            return; // Exit until location services are enabled
        }

        // Fetch the location
        fusedLocationProviderClient.getLastLocation()
                .addOnSuccessListener(location -> {
                    if (location != null) {
                        double latitude = location.getLatitude();
                        double longitude = location.getLongitude();
                        fetchCityName(latitude, longitude); // Get the city name and fetch weather data
                    } else {
                        Toast.makeText(weatherActivity.this, "Unable to fetch location. Retrying...", Toast.LENGTH_SHORT).show();
                        retryFetchingLocation(); // Retry fetching the location
                    }
                })
                .addOnFailureListener(e -> Toast.makeText(weatherActivity.this, "Failed to get location: " + e.getMessage(), Toast.LENGTH_SHORT).show());
    }

    // Retry fetching location with a slight delay
    private void retryFetchingLocation() {
        new android.os.Handler().postDelayed(this::fetchCurrentLocation, 6000); // Retry after 3 seconds
    }



    private void fetchCityName(double latitude, double longitude) {
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (addresses != null && !addresses.isEmpty()) {
                String cityName = addresses.get(0).getLocality(); // Get the city name
                if (cityName != null) {
                    Toast.makeText(this, "City: " + cityName, Toast.LENGTH_SHORT).show();
                    city=cityName;
                    // Use the city name to fetch weather data
                    fetchWeatherData(cityName);
                } else {
                    Toast.makeText(this, "City name not found!", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error fetching city name", Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        //check and request location permission
        checkLocationPermission();

        // Initialize the UI elements
        searchView = findViewById(R.id.searchView);
        cityName = findViewById(R.id.cityname);
        temp = findViewById(R.id.temp);
        weather = findViewById(R.id.weather);
        maxTemp = findViewById(R.id.maxtemp);
        minTemp = findViewById(R.id.mintemp);
        humidityValue = findViewById(R.id.humidityvalue);
        windValue = findViewById(R.id.windvalue);
        feelsLike = findViewById(R.id.feelslike);
        sunrise = findViewById(R.id.sunrise);
        sunset = findViewById(R.id.sunset);
        seaLevel = findViewById(R.id.sealevel);
        days = findViewById(R.id.days);
        date = findViewById(R.id.date);
        weatherLogo = findViewById(R.id.weatherlogo);
        rootlayout = findViewById(R.id.main);

        // Set search query listener
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String trimmedQuery = query.replaceAll("\\s+", "");
                city=trimmedQuery;
                fetchWeatherData(trimmedQuery);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void fetchWeatherData(String city) {
        OkHttpClient client = new OkHttpClient();
        String url = BASE_URL + city + "&appid=" + API_KEY;

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(() -> Toast.makeText(weatherActivity.this, "Network Error...", Toast.LENGTH_SHORT).show());
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String responseData = response.body().string();
                    try {
                        JSONObject jsonObject = new JSONObject(responseData);
                        JSONObject main = jsonObject.getJSONObject("main");
                        JSONObject wind = jsonObject.getJSONObject("wind");
                        JSONObject sys = jsonObject.getJSONObject("sys");
                        String weatherDescription = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");

                        // Get necessary data
                        String cityNameStr = jsonObject.getString("name");
                        String tempStr = String.format("%.2f", main.getDouble("temp") - 273.15); // Convert Kelvin to Celsius
                        String maxTempStr = String.format("%.2f", main.getDouble("temp_max") - 273.15);
                        String minTempStr = String.format("%.2f", main.getDouble("temp_min") - 273.15);
                        String feelslikestr = String.format("%.2f", main.getDouble("feels_like") - 273.15);
                        String humidityStr = main.getString("humidity");
                        String windSpeedStr = String.format("%.2f", wind.getDouble("speed")*3.6) + " km/h";
                        String seaLevelStr = main.has("sea_level") ? main.getString("sea_level") + " hPa" : "N/A";
                        String sunriseStr = convertTime(sys.getLong("sunrise"));
                        String sunsetStr = convertTime(sys.getLong("sunset"));
                        String dateStr = convertTimestampToDate(jsonObject.getLong("dt"));
                        String dayStr = convertTimestampToDay(jsonObject.getLong("dt"));

                        today=tempStr + " °C";

                        // Update UI on main thread
                        runOnUiThread(() -> {
                            cityName.setText(cityNameStr);
                            temp.setText(tempStr + " °C");
                            weather.setText(weatherDescription.toUpperCase());
                            maxTemp.setText("Max: " + maxTempStr + " °C");
                            minTemp.setText("Min: " + minTempStr + " °C");
                            feelsLike.setText(feelslikestr + " °C");
                            humidityValue.setText(humidityStr + " %");
                            windValue.setText(windSpeedStr);
                            seaLevel.setText(seaLevelStr);
                            sunrise.setText(sunriseStr);
                            sunset.setText(sunsetStr);
                            date.setText(dateStr);
                            days.setText(dayStr);

                            switch (weatherDescription.toLowerCase()){
                                case "clear sky":
                                    weatherLogo.setImageDrawable(ContextCompat.getDrawable(weatherActivity.this,R.drawable.sunny1));
                                    rootlayout.setBackgroundResource(R.drawable.clearsky);
                                    break;
                                case "rain":
                                    weatherLogo.setImageDrawable(ContextCompat.getDrawable(weatherActivity.this,R.drawable.rainlogo));
                                    rootlayout.setBackgroundResource(R.drawable.rainback);
                                    break;
                                case "cloud":
                                    weatherLogo.setImageDrawable(ContextCompat.getDrawable(weatherActivity.this,R.drawable.cloudylogo));
                                    rootlayout.setBackgroundResource(R.drawable.colud_background);
                                    break;
                                case "snow":
                                    weatherLogo.setImageDrawable(ContextCompat.getDrawable(weatherActivity.this,R.drawable.snowlogo));
                                    rootlayout.setBackgroundResource(R.drawable.snowback);
                                    break;
                                case "mist":
                                    weatherLogo.setImageDrawable(ContextCompat.getDrawable(weatherActivity.this,R.drawable.mistlogo));
                                    rootlayout.setBackgroundResource(R.drawable.mistbackground);
                                    break;
                                default:
                                    weatherLogo.setImageDrawable(ContextCompat.getDrawable(weatherActivity.this,R.drawable.partlycloudy));
                                    rootlayout.setBackgroundResource(R.drawable.partycloudybg);
                                    break;
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                        runOnUiThread(() -> Toast.makeText(weatherActivity.this, "Error parsing data", Toast.LENGTH_SHORT).show());
                    }
                }
            }
        });
    }


    private String convertTime(long unixTime) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("hh:mm a");
        java.util.Date date = new java.util.Date(unixTime * 1000L);
        return sdf.format(date);
    }
    private String convertTimestampToDate(long unixTime) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd MMMM yyyy");
        java.util.Date date = new java.util.Date(unixTime * 1000L);
        return sdf.format(date);
    }
    private String convertTimestampToDay(long unixTime) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("EEEE");
        java.util.Date date = new java.util.Date(unixTime * 1000L);
        return sdf.format(date);
    }
    public void callforecast(View view){
        Intent intent = new Intent(weatherActivity.this, fourDaysforcastActivity.class);
        intent.putExtra("EXTRA_KEY", city);
        intent.putExtra("Temp", today);
        startActivity(intent);
    }
}
