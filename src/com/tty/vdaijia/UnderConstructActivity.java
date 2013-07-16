package com.tty.vdaijia;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UnderConstructActivity extends Activity {

	public static final String BundleKeyInfo = "under_construct_tip";
	public static final String BundleKeyTitle = "title_content";
	public static final String BundleKeyNoTitle = "title_is_back";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_under_construct);
		
		String info = getIntent().getStringExtra(BundleKeyInfo);
		boolean noTitle = getIntent().getBooleanExtra(BundleKeyNoTitle, true);
		String title = getIntent().getStringExtra(BundleKeyTitle);
		if(info == null){
			info = "under construction and wait";
		}
		
		TextView textView = (TextView) findViewById(R.id.txtInfo);
		textView.setText(info);
		
		if(noTitle){
			findViewById(R.id.title).setVisibility(View.GONE);
		}else{
			TextView txtTitle = (TextView) findViewById(R.id.txtTitle);
			txtTitle.setText(title);
			Button btnBack = (Button)findViewById(R.id.btnBack);
			btnBack.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					UnderConstructActivity.this.finish();
				}
			});
		}
	}

}
