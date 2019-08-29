package com.example.beginwork;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private View thumbView;

    // this is values for default
    int min = 0, max = 100;

    List<String> intervals = new ArrayList<>();

    private List<Car> cars = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intervals.add("one");
        intervals.add("two");
        intervals.add("three");
        intervals.add("four");
        intervals.add("25");
        intervals.add("90");
        intervals.add("124");
        intervals.add("50");

        seekBar = findViewById(R.id.seekBar);
        thumbView = LayoutInflater.from(this).inflate(R.layout.layout_seekbar_thumb, null, false);
        setIntervals(intervals);
        min = seekBar.getMin();
        max = seekBar.getMax();
        seekBar.setProgress(min);
        seekBar.setThumb(getThumb(min));
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBar.setThumb(getThumb(progress));
//                double customProgress = (progress * step);
//                seekBar.setProgress(step);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        setInitialData();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        DataAdapter adapter = new DataAdapter(this, cars);
        recyclerView.setAdapter(adapter);
    }

    // void for set interval values
    public void setIntervals(List<String> intervals) {
        seekBar.setMax(intervals.size()-1);
    }


    // Html.fromHtml(" &#x20bd")
    // simbol ruble

    public Drawable getThumb(int progress) {
        // JUST COMMENT
        // maybe it will want, maybe won't want
        // I don't know :)
//        ((TextView) thumbView.findViewById(R.id.tvProgress)).setText(progress + " " +Html.fromHtml(" &#x20bd"));
        ((TextView) thumbView.findViewById(R.id.tvProgress)).setText(intervals.get(progress));

        // if value from List intervals is number, that we added to values our symbol ruble
        if (intervals.get(progress).matches("[-+]?\\d+")){
            ((TextView) thumbView.findViewById(R.id.tvProgress)).setText(intervals.get(progress) + " " +Html.fromHtml(" &#x20bd"));
        }
        thumbView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        Bitmap bitmap = Bitmap.createBitmap(thumbView.getMeasuredWidth(), thumbView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        thumbView.layout(0, 0, thumbView.getMeasuredWidth(), thumbView.getMeasuredHeight());
        thumbView.draw(canvas);

        return new BitmapDrawable(getResources(), bitmap);
    }

    // initialization data for recycler adapter
    // here we set data for recycler items
    private void setInitialData(){
        cars.add(new Car(R.drawable.automobile, "Эконом", "5 мин"));
        cars.add(new Car(R.drawable.firstmobile, "Стандарт", "2 мин"));
        cars.add(new Car(R.drawable.secondmobile, "Комфорт", "3 мин"));
        cars.add(new Car(R.drawable.forthmobile, "Минивен", "4 мин"));
        cars.add(new Car(R.drawable.fifthmobile, "F1", "1 мин"));
    }
}

