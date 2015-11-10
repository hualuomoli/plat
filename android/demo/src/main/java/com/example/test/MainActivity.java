package com.example.test;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {

	@ViewById
	EditText et;

	@ViewById
	Button button;

	@ViewById
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Click(R.id.button)
	void click() {
		tv.setText(et.getText().toString());
	}

}
