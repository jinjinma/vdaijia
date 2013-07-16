package com.tty.vdaijia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class TestActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.layout_test);
		
		findViewById(R.id.btn1).setOnClickListener(this);
		findViewById(R.id.btn2).setOnClickListener(this);
		findViewById(R.id.btn3).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btn1:
			Intent intent1 = new Intent(this,BaseMapDemo.class);
			startActivity(intent1);
			break;
		case R.id.btn2:
			Intent intent2 = new Intent(this, OverlayDemo.class);
			startActivity(intent2);
			break;
		case R.id.btn3:
			Intent intent3 = new Intent(this, LocationOverlayDemo.class);
			startActivity(intent3);
			break;
		}
	}

}
