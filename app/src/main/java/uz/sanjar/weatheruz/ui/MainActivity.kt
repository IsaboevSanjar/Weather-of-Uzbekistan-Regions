package uz.sanjar.weatheruz.ui

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.sanjar.weatheruz.R
import uz.sanjar.weatheruz.core.cache.CityCache
import uz.sanjar.weatheruz.core.cons.CONSTANTS
import uz.sanjar.weatheruz.core.network.connection.NetworkConnection
import uz.sanjar.weatheruz.core.network.models.CurrentWeather
import uz.sanjar.weatheruz.core.network.service.WeatherService
import uz.sanjar.weatheruz.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    //Jizzax
    val jizzakhLat = 40.12464129636424
    val jizzakhLon = 67.87468490031269

    //Tashkent
    val tashkentLat = 41.32567
    val tashkentLon = 69.24129

    //Sirdaryo
    val sirdaryoLat = 40.8373
    val sirdaryoLon = 68.6618

    //Andijon
    val andijonLat = 40.8154
    val andijontLon = 72.2837

    //Fargona
    val fargonaLat = 40.3734
    val fargonaLon = 71.7978

    //namangan
    val namanganLat = 41.0058
    val namanganLon = 71.6436

    //Samarqand
    val samarqandLat = 39.6270
    val samarqandLon = 66.9750

    //qashqadaryo
    val qashqadaryoLat = 38.9271
    val qashqadaryoLon = 65.7539

    //surhandaryo
    val surhandaryoLat = 37.9409
    val surhandaryoLon = 67.5709

    //buxoro
    val buxoroLat = 39.7681
    val buxoroLon = 64.4556

    //navoiy
    val navoiyLat = 40.1039
    val navoiyLon = 65.3688

    //xorazm
    val xorazmLat = 41.3895
    val xorazmLon = 60.3415

    //qoraqolpoq
    val qoraqolpoqLat = 42.4619
    val qoraqolpoqLon = 59.6166

    private var lat = qoraqolpoqLat
    private var lon = qoraqolpoqLon

    val API = "b15a8e6a646926fc11b23b60f6b9ff2e"

    val TAG = "MainActivityTAG"

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val cityName get() = CityCache.getCache().city
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bottomSheetFragment = BottomSheetFragment()
        val citiesSheet = CitiesSheetFragment()
        binding.appInfo.setOnClickListener(View.OnClickListener {
            bottomSheetFragment.show(supportFragmentManager, "BottomSheetDialog")
        })
        binding.location.setOnClickListener(View.OnClickListener {
            citiesSheet.show(supportFragmentManager, "CitiesSheetDialog")
        })
        binding.swipeRefresh.setOnRefreshListener {
            Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show()
            loadingData()
            if (binding.errorText.visibility == View.VISIBLE) {
                binding.errorText.visibility = View.GONE
            }
            binding.swipeRefresh.isRefreshing = false
        }
        timeCounter()
        loadingData()
    }


    private fun timeCounter() {
        object : CountDownTimer(1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.loader.visibility = View.VISIBLE
                mainViewGone()
            }

            override fun onFinish() {
                binding.loader.visibility = View.GONE
            }
        }.start()

    }

    private fun loadingData() {
        val connection = NetworkConnection.getRetrofit()
        val service: WeatherService = connection.create(WeatherService::class.java)
        checkCity()
        val result = service.getCurrentWeather("metric", lat, lon, CONSTANTS.apiKey)

        result.enqueue(object : Callback<CurrentWeather> {
            override fun onResponse(
                call: Call<CurrentWeather>,
                response: Response<CurrentWeather>
            ) {
                if (response.isSuccessful) {
                    binding.errorText.visibility = View.GONE

                    val data = response.body()

                    if (data != null) {
                        val updateAt: String = "Updated at:\n" + SimpleDateFormat(
                            "dd/MM/yyyy\n hh:mm:a",
                            Locale.ENGLISH
                        ).format(
                            Date(data.dt * 1000)
                        )
                        val sunsetData: String = SimpleDateFormat(
                            "hh:mm:a",
                            Locale.ENGLISH
                        ).format(Date(data.sys.sunset * 1000))
                        val sunriseData: String = SimpleDateFormat(
                            "hh:mm:a",
                            Locale.ENGLISH
                        ).format(Date(data.sys.sunrise * 1000))
                        val windSped: String = data.wind.speed.toString()
                        mainViewVisible()
                        binding.address.text = data.name + ", " + data.sys.country
                        binding.updateAt.text = updateAt
                        val degree: Int = (data.main.temp).toInt()
                        binding.temp.text = degree.toString()
                        binding.tempMin.text = data.main.temp_min.toString()
                        binding.tempMax.text = data.main.temp_max.toString()
                        binding.pressure.text = data.main.pressure.toString() + " mbar"
                        binding.humidity.text = data.main.humidity.toString() + " %"
                        binding.wind.text = windSped
                        binding.sunrise.text = sunriseData
                        binding.sunset.text = sunsetData
                    }
                    Log.d(TAG, "onResponse: $data")

                }

            }

            override fun onFailure(call: Call<CurrentWeather>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t}")
                mainViewGone()
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_LONG).show()
                binding.errorText.visibility = View.VISIBLE
            }

        })
    }

    private fun checkCity() {
        if (cityName == "tashkent") {
            lat = tashkentLat
            lon = tashkentLon
        } else if (cityName == "fargana") {
            lat = fargonaLat
            lon = fargonaLon
        } else if (cityName == "andijon") {
            lat = andijonLat
            lon = andijontLon
        } else if (cityName == "namangan") {
            lat = namanganLat
            lon = namanganLon
        } else if (cityName == "sirdaryo") {
            lat = sirdaryoLat
            lon = sirdaryoLon
        } else if (cityName == "jizzakh") {
            lat = jizzakhLat
            lon = jizzakhLon
        } else if (cityName == "samarqand") {
            lat = samarqandLat
            lon = samarqandLon
        } else if (cityName == "qashqadaryo") {
            lat = qashqadaryoLat
            lon = qashqadaryoLon
        } else if (cityName == "surhandaryo") {
            lat = surhandaryoLat
            lon = surhandaryoLon
        } else if (cityName == "navoiy") {
            lat = navoiyLat
            lon = navoiyLon
        } else if (cityName == "buxoro") {
            lat = buxoroLat
            lon = buxoroLon
        } else if (cityName == "xorazm") {
            lat = xorazmLat
            lon = xorazmLon
        } else if (cityName == "qoraqalpoq") {
            lat = qoraqolpoqLat
            lon = qoraqolpoqLon
        } else {
            lat = tashkentLat
            lon = tashkentLon
        }


    }

    private fun mainViewGone() {
        binding.addressContainer.visibility = View.GONE
        binding.overviewContainer.visibility = View.GONE
        binding.detailContainer.visibility = View.GONE
        binding.mainContainer.setBackgroundResource(R.color.white)
    }

    private fun mainViewVisible() {
        binding.addressContainer.visibility = View.VISIBLE
        binding.overviewContainer.visibility = View.VISIBLE
        binding.detailContainer.visibility = View.VISIBLE
        binding.mainContainer.setBackgroundResource(R.drawable.gradient_normal_back)
    }

}



