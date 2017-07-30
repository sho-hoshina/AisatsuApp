package jp.techacademy.shou.hoshina.aisatsuapp;

import android.app.TimePickerDialog;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView m_TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Button = (Button)findViewById(R.id.btnTimePickerDialog);
        Button.setOnClickListener(this);

        m_TextView = (TextView)findViewById(R.id.txt1);

    }

    @Override
    public void onClick(View v) {
        showTimePickerDialog();
    }

    private void showTimePickerDialog(){
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener(){
                    @Override
                    public void onTimeSet(TimePicker View, int hourOfDay, int minute){
                        m_TextView.setText(greetingMsg(hourOfDay, minute));
                    }
                },
                13,
                0,
                true);
        timePickerDialog.show();
    }

    //時刻によってメッセージを返す
    private String greetingMsg(int hour, int minute)
    {
        int tmpMinute = hour * 60 + minute;
        String msg = "";

        //2:00～9:59では「おはよう」
        //10:00～17:59では「こんにちは」
        //18:00～1:59では「こんばんは」
        if(tmpMinute < 2 * 60)
        {
            msg = "こんばんは";
        }
        else if(tmpMinute < 10 * 60)
        {
            msg = "おはよう";
        }
        else if(tmpMinute < 18 * 60)
        {
            msg = "こんにちは";
        }
        else
        {
            msg = "こんばんは";
        }
        return msg;
    }
}
