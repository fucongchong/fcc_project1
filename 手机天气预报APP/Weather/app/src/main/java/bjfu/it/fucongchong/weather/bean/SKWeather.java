package bjfu.it.fucongchong.weather.bean;

import androidx.annotation.Keep;

import bjfu.it.fucongchong.weather.network.ApiService;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
@Keep
public class SKWeather {
    private Weatherinfo weatherinfo;
    public Weatherinfo getWeatherinfo(){return weatherinfo;}

    public void setWeatherinfo(Weatherinfo weatherinfo){this.weatherinfo=weatherinfo;}
    @Keep
    public class Weatherinfo{
        private String temp;
        private String WD;
        private String WS;
        private String SD;
        private String AP;

        public String getTemp() {
            return temp;
        }

        public void setTemp(String temp) {
            this.temp = temp;
        }

        public String getWD() {
            return WD;
        }

        public void setWD(String WD) {
            this.WD = WD;
        }

        public String getWS() {
            return WS;
        }

        public void setWS(String WS) {
            this.WS = WS;
        }

        public String getSD() {
            return SD;
        }

        public void setSD(String SD) {
            this.SD = SD;
        }

        public String getAP() {
            return AP;
        }

        public void setAP(String AP) {
            this.AP = AP;
        }
    }

}
