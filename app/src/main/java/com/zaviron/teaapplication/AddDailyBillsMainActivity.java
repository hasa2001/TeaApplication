package com.zaviron.teaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class AddDailyBillsMainActivity extends AppCompatActivity {
    private final static String TAG = AddDailyBillsMainActivity.class.getName();
    private CalendarView calendarView;
    private TextView user_id, teaPacketPrice, totalRawTeaWeight, advancedFee, DolomiteFee, FertilizerFee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_daily_bills_main);
        calendarView = findViewById(R.id.calendarView);
        user_id = findViewById(R.id.user_id);
        teaPacketPrice = findViewById(R.id.teaPacket);
        totalRawTeaWeight = findViewById(R.id.totalTeaKg);
        advancedFee = findViewById(R.id.advancedFee);
        DolomiteFee = findViewById(R.id.dolomite);
        FertilizerFee = findViewById(R.id.fertilizerId);
        findViewById(R.id.addBillBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double total_teaPacketPrice;
                String customer_id;
                Double total_raw_tea;
                Double total_advanced_fee;
                Double total_dolomite_fee;
                Double total_fertilizer_fee;
                if (user_id.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "කරුණාකර දලු සපයන්නාගේ අංකය ඇතුලත් කරන්න.", Toast.LENGTH_LONG).show();
                } else if (totalRawTeaWeight.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "කරුණාකර දලු ප්‍රමාණය ඇතුලත් කරන්න.(kg)", Toast.LENGTH_LONG).show();
                } else {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");


                    String format = simpleDateFormat.format(calendarView.getDate());
                    customer_id = user_id.getText().toString();
                    if (teaPacketPrice.getText().toString().isEmpty()) {
                        total_teaPacketPrice = 0.0;
                    } else {
                        total_teaPacketPrice = Double.parseDouble(teaPacketPrice.getText().toString());
                    }
                    if (advancedFee.getText().toString().isEmpty()) {
                        total_advanced_fee = 0.0;
                    } else {
                        total_advanced_fee = Double.parseDouble(advancedFee.getText().toString());
                    }
                    if (DolomiteFee.getText().toString().isEmpty()) {
                        total_dolomite_fee = 0.0;
                    } else {
                        total_dolomite_fee = Double.parseDouble(DolomiteFee.getText().toString());
                    }
                    if (FertilizerFee.getText().toString().isEmpty()) {
                        total_fertilizer_fee = 0.0;
                    } else {
                        total_fertilizer_fee = Double.parseDouble(FertilizerFee.getText().toString());
                    }

                    total_raw_tea = Double.parseDouble(totalRawTeaWeight.getText().toString());


                    System.out.println(format + " " + customer_id + " " + total_teaPacketPrice.toString() + " " + total_raw_tea.toString() + " " + total_advanced_fee.toString() + " " + total_dolomite_fee.toString() + " " + total_fertilizer_fee.toString());
                    Log.i(TAG, String.valueOf(format));
                }


            }
        });
    }
}