package edu.nyit.app.demo.activity;

import android.view.View;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Vibrator;
import android.widget.EditText;

import edu.nyit.app.demo.R;
import edu.nyit.app.demo.Toaster;


public class Alpha extends Activity {

    protected Context   context;
    protected Intent    intent;
    protected Toaster   toaster;
    protected Vibrator  vibrator;

    protected String msg;
    protected EditText ed_msg;
    public static final String _msg = "alpha.msg";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alpha);
        context = getApplicationContext();
        toaster = new Toaster(context);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    }

    protected void onResume() {
        super.onResume();
        ed_msg = (EditText) findViewById(R.id.alpha_field);
    }

    public void work_beta(View view) {
        vibrator.vibrate(200);
        intent = new Intent(this, edu.nyit.app.demo.activity.Beta.class);
        msg = ed_msg.getText().toString();
        if(!msg.isEmpty())
        {
            intent.putExtra(_msg, msg);
            startActivity(intent);
        } else {
            help(view);
        }
    }

    public void work_gamma(View view) {
        vibrator.vibrate(200);
        intent = new Intent(this, edu.nyit.app.demo.activity.Gamma.class);
        startActivity(intent);
    }

    public void help(View view) {
        vibrator.vibrate(200);
        toaster.toast(getString(R.string.alpha_help));
    }

}
