package uz.sanjar.weatheruz.core.model;

import android.widget.TextView;

import java.util.ArrayList;

public class SpinnerModel {
    ArrayList<Integer> cityImages;
    TextView cityName;

    public SpinnerModel(ArrayList<Integer> cityImages, TextView cityName) {
        this.cityImages = cityImages;
        this.cityName = cityName;
    }

    public SpinnerModel() {

    }

    public ArrayList<Integer> getCityImages() {
        return cityImages;
    }

    public void setCityImages(ArrayList<Integer> cityImages) {
        this.cityImages = cityImages;
    }

    public TextView getCityName() {
        return cityName;
    }

    public void setCityName(TextView cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "SpinnerModel{" +
                "cityImages=" + cityImages +
                ", cityName=" + cityName +
                '}';
    }
}
