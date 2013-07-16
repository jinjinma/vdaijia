package com.tty.vdaijia;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MoreActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_more);
		
		findViewById(R.id.serviceLine).setOnClickListener(this);
		findViewById(R.id.apkUpdate).setOnClickListener(this);
		findViewById(R.id.suggest).setOnClickListener(this);
		findViewById(R.id.aboutMe).setOnClickListener(this);
		findViewById(R.id.serviceTerms).setOnClickListener(this);
		findViewById(R.id.joinUs).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.serviceLine:
			Util.showToast(this, R.string.under_construction);
			break;
		case R.id.apkUpdate:
			Util.showToast(this, R.string.under_construction);
			break;
		case R.id.suggest:
			Util.showToast(this, R.string.under_construction);
			break;
		case R.id.aboutMe:
			Util.showToast(this, R.string.under_construction);
			break;
		case R.id.serviceTerms:
			Util.showToast(this, R.string.under_construction);
			break;
		case R.id.joinUs:
			Util.showToast(this, R.string.under_construction);
			break;
		default:
		}
	}
	

}
