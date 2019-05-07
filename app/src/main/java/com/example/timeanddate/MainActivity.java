package com.example.timeanddate;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private EditText editTextHour;
    private EditText editTextHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextHour = findViewById(R.id.editTextHour);
        editTextHistory = findViewById(R.id.editTextHistory);

        editTextHour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);

                TimePickerDialog timePicker;
                timePicker = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        editTextHour.setText(hourOfDay + " : " + minute);
                    }
                },hour , minute , true);
                timePicker.setButton(TimePickerDialog.BUTTON_POSITIVE , "Ayarla" , timePicker);
                timePicker.setButton(TimePickerDialog.BUTTON_NEGATIVE , "Iptal" , timePicker);
                timePicker.show();


            }
        });

        editTextHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                final int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePicker;

                datePicker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        editTextHistory.setText(dayOfMonth + "/" + (month+1) +"/" + year);
                    }
                },year,month,day );

                datePicker.setButton(TimePickerDialog.BUTTON_POSITIVE , "Ayarla", datePicker);
                datePicker.setButton(TimePickerDialog.BUTTON_NEGATIVE , "Iptal" , datePicker);
                datePicker.show();
            }
        });
    }
}
