package com.example.time_picker;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Build;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.TimePicker;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView=findViewById(R.id.tv1);
        TimePicker timePicker=findViewById(R.id.tp1);
        Button button=findViewById(R.id.b1);

        timePicker.setIs24HourView(true);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int h,m;
                String ampm;

                if (Build.VERSION.SDK_INT >= 23)
                {
                    h=timePicker.getHour();
                    m=timePicker.getMinute();

                }
                else {

                    h=timePicker.getCurrentHour();
                    m=timePicker.getCurrentMinute();

                }

                if (h > 12)
                {
                    ampm="PM";
                    h=h-12;
                }
                else
                {
                    ampm="AM";

                }
                textView.setText("Time :"+h+":"+m+":"+ampm);
            }
        });
    }
}