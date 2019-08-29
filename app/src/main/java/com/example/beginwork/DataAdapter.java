package com.example.beginwork;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Car> cars;

    DataAdapter(Context context, List<Car> cars){
        this.cars = cars;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Car car = cars.get(position);
        holder.ivCarPhoto.setImageResource(car.getImageSrc());
        holder.tvCarType.setText(car.getType());
        holder.tvCarTime.setText(car.getTime());
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        final ImageView ivCarPhoto;
        final TextView tvCarType, tvCarTime;

        ViewHolder(View view){
            super(view);
            ivCarPhoto = view.findViewById(R.id.ivCarPhoto);
            tvCarType = view.findViewById(R.id.tvCarType);
            tvCarTime = view.findViewById(R.id.tvCarTime);
        }
    }
}
