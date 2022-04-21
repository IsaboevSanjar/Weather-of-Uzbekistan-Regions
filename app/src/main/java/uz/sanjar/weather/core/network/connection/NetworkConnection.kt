package uz.sanjar.weather.core.network.connection

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkConnection {
    companion object {
        private var retrofit: Retrofit? = null

        //        https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}
        fun getRetrofit(): Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl("https://api.openweathermap.org")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
    }
}