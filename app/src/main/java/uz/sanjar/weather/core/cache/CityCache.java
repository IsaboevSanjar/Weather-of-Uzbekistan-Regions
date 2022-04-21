package uz.sanjar.weather.core.cache;

import android.content.Context;
import android.content.SharedPreferences;

public class CityCache {
    private static CityCache cache;
    private SharedPreferences preferences;

    private CityCache(Context context) {
        preferences = context.getSharedPreferences("weather", Context.MODE_PRIVATE);
    }

    public static CityCache getCache() {
        return cache;
    }

    public static void init(Context context) {
        if (cache == null) {
            cache = new CityCache(context);
        }
    }

    public String getCity() {
        return preferences.getString("city", "tashkent");
    }

    public void setCity(String name) {
        preferences.edit().putString("city", name).apply();
    }
}
