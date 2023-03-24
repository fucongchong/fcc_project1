package bjfu.it.fucongchong.weather.bean;

import android.widget.Toast;

import bjfu.it.fucongchong.weather.WeatherActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class CityInfoWeather {
    private Weatherinfo weatherinfo;

    public Weatherinfo getWeatherinfo()
    {
        return weatherinfo;
    }

    public void setWeatherinfo(Weatherinfo weatherinfo)
    {
        this.weatherinfo=weatherinfo;
    }

    public class Weatherinfo{
        private String weather;

        public String getWeather()
        {
            return weather;
        }

        public void setWeather(String weather)
        {
            this.weather=weather;
        }
    }




}
