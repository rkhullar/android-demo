package edu.nyit.app.demo.activity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;
import android.content.pm.ActivityInfo;

import edu.nyit.app.demo.R;

public class Beta extends Activity {

    protected Intent intent;
    protected TextView tv_msg;
    protected String msg;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_beta);
        loadIntent();
    }

    protected void loadIntent() {
        intent = getIntent();
        msg = intent.getStringExtra(edu.nyit.app.demo.activity.Alpha._msg);
    }

    protected void onResume() {
        super.onResume();
        tv_msg = (TextView) findViewById(R.id.beta_msg);
        tv_msg.setText(msg);
    }
}
