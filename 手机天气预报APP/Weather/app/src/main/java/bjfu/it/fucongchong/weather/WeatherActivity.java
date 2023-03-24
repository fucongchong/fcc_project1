package bjfu.it.fucongchong.weather;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import bjfu.it.fucongchong.weather.bean.CityInfoWeather;
import bjfu.it.fucongchong.weather.bean.IPSee;
import bjfu.it.fucongchong.weather.bean.SKWeather;
import bjfu.it.fucongchong.weather.network.ApiService;
import bjfu.it.fucongchong.weather.network.RetrofitManager;
import bjfu.it.fucongchong.weather.utils.CityHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class WeatherActivity extends AppCompatActivity {

    private TextView cityNameTv;
    private TextView tempTv;
    private TextView weatherTv;
    private TextView wdTv;
    private TextView wsTv;
    private TextView sdTv;
    private TextView apTv;
    private String cityId;
    private ApiService apiService;
    private ApiService apiService2;

    private TextView regionTv;

    private String region2;

    public String getRegion2() {
        return region2;
    }

    public void setRegion2(String region2) {
        this.region2 = region2;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        cityNameTv=findViewById(R.id.cityName);
        tempTv=findViewById(R.id.temp);
        weatherTv=findViewById(R.id.weather);
        wdTv=findViewById(R.id.wd);
        wsTv=findViewById(R.id.ws);
        sdTv=findViewById(R.id.sd);
        apTv=findViewById(R.id.ap);
        regionTv=findViewById(R.id.region);

        cityNameTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(WeatherActivity.this,CityListActivity.class);
                startActivityForResult(intent,CityListActivity.CITY_ID_RESULT_CODE);
            }
        });

        apiService= RetrofitManager.getInstance().getRetrofit(ApiService.HOST_WEATHER).create(ApiService.class);
        apiService2=RetrofitManager.getInstance().getRetrofit(ApiService.HOST_WEATHER_2).create(ApiService.class);


//        refresh(CityHelper.getDefaultCityId());

        Call<IPSee>ipSeeCall=apiService2.getIPSee();
        ipSeeCall.enqueue(new Callback<IPSee>() {
            @Override
            public void onResponse(Call<IPSee> call, Response<IPSee> ipSeeResponse) {
                IPSee ipSee=ipSeeResponse.body();

                region2=ipSee.getRegion();
                if(region2!=null) {
                    if (region2.equals("Guizhou")) {//由于天气列表中没有贵州，故用省会贵阳代替
                        region2 = "101260101";
                    } else {
                        region2 = "101210101";//检索到的地址与实际不符返回杭州(作者本人测试地点在贵州）
                    }
                }
                else
                {
                    region2="101110101";//没检索到数据返回西安（作者本人测试地点在贵州）
                }

                refresh(region2);

            }

            @Override
            public void onFailure(Call<IPSee> call, Throwable t) {

            }
        });








//        Call<CityInfoWeather> cityInfoCall=apiService.getCityInfoWeather(cityId);
//        cityInfoCall.enqueue(new Callback<CityInfoWeather>() {
//
//            @Override
//            public void onResponse(Call<CityInfoWeather> call, Response<CityInfoWeather> response) {
//
//                Toast.makeText(WeatherActivity.this,"请求CityInfo接口失败",Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onFailure(Call<CityInfoWeather> call,Throwable t)
//            {
//                Toast.makeText(WeatherActivity.this,"请求CityInfo接口失败",Toast.LENGTH_LONG).show();
//            }
//
//        }
//        );

//        Call<SKWeather> skCall=apiService.getSKWeather(cityId);
//        skCall.enqueue(new Callback<SKWeather>() {
//            @Override
//            public void onResponse(Call<SKWeather> call, Response<SKWeather> response) {
//                Toast.makeText(WeatherActivity.this,"请求SK接口失败",Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onFailure(Call<SKWeather> call, Throwable throwable) {
//                Toast.makeText(WeatherActivity.this,"请求SK接口失败",Toast.LENGTH_LONG).show();
//            }
//        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==CityListActivity.CITY_ID_RESULT_CODE)
        {
            if(data!=null)
            {
                String cityId=data.getStringExtra(CityListActivity.CITY_ID_KRY);
                refresh(cityId);
            }
        }
    }

    private void refresh(final String cityId)
    {
        if(TextUtils.isEmpty(cityId)||cityId.equals(this.cityId))
        {
            return;
        }
        Call<CityInfoWeather> cityInfoCall=apiService.getCityInfoWeather(cityId);
        cityInfoCall.enqueue(new Callback<CityInfoWeather>() {
            @Override
            public void onResponse(Call<CityInfoWeather> call, final Response<CityInfoWeather> cityInfoResponse) {
                Call<SKWeather> skCall=apiService.getSKWeather(cityId);
                skCall.enqueue(new Callback<SKWeather>() {
                    @Override
                    public void onResponse(Call<SKWeather> call, Response<SKWeather> skResponse) {
                        //更新界面
                        Call<IPSee>ipSeeCall=apiService2.getIPSee();
                        ipSeeCall.enqueue(new Callback<IPSee>() {
                            @Override
                            public void onResponse(Call<IPSee> call, Response<IPSee> ipSeeResponse) {
                                CityInfoWeather cityInfoWeather=cityInfoResponse.body();
                                SKWeather skWeather=skResponse.body();
                                IPSee ipSee=ipSeeResponse.body();
                                WeatherActivity.this.cityId=cityId;

                                cityNameTv.setText(getString(R.string.city_name_str,CityHelper.getInstance().getCityInfoMap().get(cityId).getName()));
                                tempTv.setText(getString(R.string.temp_str,skWeather.getWeatherinfo().getTemp()));
                                weatherTv.setText(cityInfoWeather.getWeatherinfo().getWeather());
                                wdTv.setText(getString(R.string.wd_str,skWeather.getWeatherinfo().getWD()));
                                wsTv.setText(getString(R.string.ws_str,skWeather.getWeatherinfo().getWS()));
                                sdTv.setText(getString(R.string.sd_str,skWeather.getWeatherinfo().getSD()));
                                apTv.setText(getString(R.string.ap_str,skWeather.getWeatherinfo().getAP()));
//                                regionTv.setText(getString(R.string.region_str,ipSee.getRegion()));
                                String temp_set_region="没有获取到正确数据";
                                if(ipSee.getRegion().equals("Guizhou"))
                                    temp_set_region="贵阳";//由于天气列表中没有贵州，故用省会贵阳代替（IP只定位至省份）
                                regionTv.setText(getString(R.string.region_str,temp_set_region));
                            }

                            @Override
                            public void onFailure(Call<IPSee> call, Throwable t) {
                                Toast.makeText(WeatherActivity.this,"请求IP接口失败",Toast.LENGTH_LONG).show();
                            }
                        });
//                        CityInfoWeather cityInfoWeather=cityInfoResponse.body();
//                        SKWeather skWeather=skResponse.body();
//                        WeatherActivity.this.cityId=cityId;
//                        cityNameTv.setText(getString(R.string.city_name_str,CityHelper.getInstance().getCityInfoMap().get(cityId).getName()));
//                        tempTv.setText(getString(R.string.temp_str,skWeather.getWeatherinfo().getTemp()));
//                        weatherTv.setText(cityInfoWeather.getWeatherinfo().getWeather());
//                        wdTv.setText(getString(R.string.wd_str,skWeather.getWeatherinfo().getWD()));
//                        wsTv.setText(getString(R.string.ws_str,skWeather.getWeatherinfo().getWS()));
//                        sdTv.setText(getString(R.string.sd_str,skWeather.getWeatherinfo().getSD()));
//                        apTv.setText(getString(R.string.ap_str,skWeather.getWeatherinfo().getAP()));
                    }

                    @Override
                    public void onFailure(Call<SKWeather> call, Throwable throwable) {
                        Toast.makeText(WeatherActivity.this,"请求SK接口失败",Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onFailure(Call<CityInfoWeather> call, Throwable throwable) {
                Toast.makeText(WeatherActivity.this,"请求CityInfo接口失败",Toast.LENGTH_LONG).show();
            }
        });
    }


}
