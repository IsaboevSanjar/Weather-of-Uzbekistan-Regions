package uz.sanjar.weather.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;

import uz.sanjar.weather.R;

public class Dialog extends android.app.Dialog {
    public Dialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_dialog);
    }
}
