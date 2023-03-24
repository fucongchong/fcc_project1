package bjfu.it.fucongchong.weather.network;


import bjfu.it.fucongchong.weather.bean.CityInfoWeather;
import bjfu.it.fucongchong.weather.bean.IPSee;
import bjfu.it.fucongchong.weather.bean.SKWeather;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService{
    public static final String HOST_WEATHER="http://www.weather.com.cn";
    public static final String HOST_WEATHER_2="https://ip.seeip.org";
    @GET("/data/cityinfo/{cityId}.html")
    Call<CityInfoWeather> getCityInfoWeather(@Path("cityId")String cityId);

    @GET("/data/sk/{cityId}.html")
    Call<SKWeather> getSKWeather(@Path("cityId")String cityId);

    @GET("https://ip.seeip.org/geoip")
    Call<IPSee> getIPSee();
}
