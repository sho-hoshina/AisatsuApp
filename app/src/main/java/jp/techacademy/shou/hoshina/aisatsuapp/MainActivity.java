package jp.techacademy.shou.hoshina.aisatsuapp;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView m_TextView;
    TimePicker m_TimePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(this);

        m_TextView = (TextView)findViewById(R.id.txt1);
        m_TimePicker = (TimePicker)findViewById(R.id.timePicker1);
    }

    @Override
    public void onClick(View v) {
        int hour;
        int minute;
        int currentApiVersion = Build.VERSION.SDK_INT;

        if (currentApiVersion > Build.VERSION_CODES.LOLLIPOP_MR1) {
            hour = m_TimePicker.getHour();
            minute = m_TimePicker.getMinute();
        } else{
            hour = m_TimePicker.getCurrentHour();
            minute = m_TimePicker.getCurrentMinute();
        }

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
        m_TextView.setText(msg);
    }
}
