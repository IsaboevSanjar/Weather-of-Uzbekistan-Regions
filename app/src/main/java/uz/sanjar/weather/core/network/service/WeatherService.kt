package uz.sanjar.weather.core.network.service

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import uz.sanjar.weather.core.network.models.CurrentWeather

interface WeatherService {

    //        https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}
    @GET("data/2.5/weather")
    fun getCurrentWeather(
        @Query("units") unit: String,
        @Query("lat") lt: Double,
        @Query("lon") ln: Double,
        @Query("appid") apiKey: String
    ): Call<CurrentWeather>


}