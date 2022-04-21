package uz.sanjar.weather.core.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import uz.sanjar.weather.R;

public class SpinnerAdapter extends BaseAdapter {
    private ArrayList<Integer> images = new ArrayList<>();

    public void setImages(ArrayList<Integer> data1) {
        this.images = data1;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Integer getItem(int i) {
        return images.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_city, viewGroup, false);

        ImageView imageView = view1.findViewById(R.id.icon_city);
        imageView.setImageResource(getItem(i));

        return view1;
    }
}
