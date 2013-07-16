package com.tty.vdaijia;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.tty.vdaijia.adapter.CommentAdapter;
import com.tty.vdaijia.model.CommentInfo;
import com.tty.vdaijia.model.DriverModel;

public class DriverDetailActivity extends Activity implements OnClickListener{
	public static final String BundleKeyModelInfo = "driver_info";
	
	CommentAdapter mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_driver_detail);
		
		mDriverInfo = (DriverModel) getIntent().getSerializableExtra(BundleKeyModelInfo);
		initDriverInfo(mDriverInfo);
		
		findViewById(R.id.titleBack).setOnClickListener(this);
		manipulateData();
	}

	DriverModel mDriverInfo;
	void initDriverInfo(DriverModel model){
		if(model == null)
			return;
		
		ImageView portrait = (ImageView) findViewById(R.id.driverPort);
		TextView txtName = (TextView) findViewById(R.id.driverName);
		TextView txtLocation = (TextView) findViewById(R.id.driverLocation);
		TextView txtTotalCount = (TextView) findViewById(R.id.txtTotalCounts);
		TextView txtTotalYear = (TextView) findViewById(R.id.txtTotalYears);
		TextView txtHomeTown = (TextView) findViewById(R.id.txtHomeTown);
		Button phoneCall = (Button) findViewById(R.id.callDriver);
		
		portrait.setImageResource(model.getPort());
		txtName.setText(model.getName());
		txtLocation.setText("距离：" + model.getDistance() + "公里");
		txtTotalCount.setText("代驾：" + model.getTotalCounts() + "次");
		txtTotalYear.setText("驾龄：" + model.getDriveYear() + "年");
		txtHomeTown.setText("籍贯：" + model.getHomeTown());
		
		phoneCall.setOnClickListener(this);
				
		ListView listView = (ListView) findViewById(R.id.commentList);
		mAdapter = new CommentAdapter(this);
		listView.setAdapter(mAdapter);
	}
	
	
	String[] comments = new String[]{
			"不错,人很热情，非常满意！",
			"挺好，服务周到！",
			"还行，感觉不太熟练！",
			"一般，态度不是太好！",
			"差，各种不好！",
	};
	String[] phoneNO = new String[]{
			"186****9333",
			"186****7333",
			"186****3333",
			"186****7433",
			"186****8978",
	};
	void manipulateData(){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String ymd = format.format(calendar.getTime());
		
		List<CommentInfo> infos = new ArrayList<CommentInfo>();
		for(int index = 0; index < 10; index++){
			CommentInfo item = new CommentInfo(phoneNO[index%5], ymd, comments[index%5]);
			infos.add(item);
		}
		mAdapter.setData(infos);
		mAdapter.notifyDataSetChanged();
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.titleBack:
			this.finish();
			break;
		case R.id.callDriver:
//			Util.showToast(this, "呼叫 " + mDriverInfo.getName());
			dial2Phone("4008517517");
			break;
		}
	}
	
	private void dial2Phone(String phoneNume){
		Intent intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:" + phoneNume));  
        startActivity(intent); 
	}

}
