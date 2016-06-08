package edu.nyit.app.demo.activity;

import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.os.Vibrator;
import android.view.View;
import android.widget.TextView;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import edu.nyit.app.demo.R;
import edu.nyit.app.demo.FileMaker;
import edu.nyit.app.demo.Toaster;

public class Delta extends Activity {

    public static DateFormat formatter = new SimpleDateFormat("MMddHHmm");

    protected Context context;
    protected Toaster toaster;
    protected Vibrator vibrator;

    protected String name, msg;
    protected TextView tv_msg;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delta);
        context = getApplicationContext();
        toaster = new Toaster(context);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        FileMaker.folder(getString(R.string.app_storage));
        name = formatter.format(new Date()) + ".txt";
        FileMaker.touchFile(name);
        FileMaker.open();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        tv_msg = (TextView) findViewById(R.id.delta_msg);
    }

    public void work_append(View view) {
        vibrator.vibrate(200);
        msg = tv_msg.getText().toString();
        if(!msg.isEmpty()) {
            toaster.toast(String.format("writing %s to %s", msg, name));
            FileMaker.println(msg);
        } else {
            toaster.toast("type something first");
        }
    }

    public void work_close(View view) {
        vibrator.vibrate(200);
        toaster.toast(String.format("closing %s", name));
        FileMaker.close();
    }

}
