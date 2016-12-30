package gdmec07150605.lenovo.dialogdemo;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView tv1,tv2, tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.uidate);
        tv2 = (TextView) findViewById(R.id.uitime);
        tv3 = (TextView) findViewById(R.id.charactor);
    }
    public void characterpickerdialog(View v){
        final String options = "12379797*&(%^%31??S>DPL";
        CharacterPickerDialog cpd = new CharacterPickerDialog(this, new View(this), null, options, false){
            @Override
            public void onClick(View v) {
                tv3.append(((Button) v).getText().toString());
                if (((Button) v).getText().toString().equals("")) {
                    dismiss();
                }
            }
        };
        cpd.show();
    }
    public void datepickerdialog(View v){
        DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                tv1.setText("日期：" + year + "-" + (month + 1) + "-" + dayOfMonth);
            }
        }, 2016, 10, 25);
        dpd.show();
    }
    public void timepickerdialog(View v){
        TimePickerDialog tpd = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                tv2.setText(hourOfDay + ":" + minute);
            }
        },Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), true);

        tpd.show();
    }
    public void progressdialog(View v){
        final ProgressDialog pg =ProgressDialog.show(this, "加载", "加载中，请稍后.......", true);
        new Thread(){
            public void run(){
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    pg.dismiss();
                }
            }
        }.start();
    }
}
