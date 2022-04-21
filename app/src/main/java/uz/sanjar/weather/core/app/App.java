package uz.sanjar.weather.core.app;

import android.app.Application;

import uz.sanjar.weather.core.cache.CityCache;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CityCache.init(this);
    }
}
