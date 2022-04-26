package uz.sanjar.weatheruz.core.app;

import android.app.Application;

import uz.sanjar.weatheruz.core.cache.CityCache;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CityCache.init(this);
    }
}
