package uz.sanjar.weather.core.network.models

data class Cord(
    val lon: Double,
    val lat: Double
)
// select * from dict co-0,col1-eng,col2-uz
// select uz,en from dict co-0,col1-uz,col2-en


data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)

data class Wind(
    val speed: Float,
    val deg: Int
)

data class Sys(
    val type: Int,
    val id: Int,
    val country: String,
    val sunrise: Long,
    val sunset: Long
)

data class Main(
    val temp: Double,
    val feels_like: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Double,
    val humidity: Double,
)

data class CurrentWeather(
    val weather: List<Weather>,
    val sys: Sys,
    val wind: Wind,
    val main: Main,
    val coord: Cord,
    val base: String,
    val visibility: Double,
    val dt: Long,
    val id: Double,
    val name: String,
    val cod: Double
)