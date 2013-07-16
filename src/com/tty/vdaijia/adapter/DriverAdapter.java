package com.tty.vdaijia.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.MonthDisplayHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.tty.vdaijia.R;
import com.tty.vdaijia.model.DriverModel;

public class DriverAdapter extends BaseAdapter {
	List<DriverModel> mDatas;
	LayoutInflater mFlater;
	
	public DriverAdapter(Context context){
		mFlater = LayoutInflater.from(context);
		mDatas = new ArrayList<DriverModel>();
	}
	
	public interface OnCallDriverListener{
		public void onCallDriver(View v, int position);
	}
	
	OnCallDriverListener mCallListener;
	public void setOnCallDriverListener(OnCallDriverListener listener){
		mCallListener = listener;
	}
	
	public void clearData(){
		if(mDatas != null)
			mDatas.clear();
	}
	
	public void setData(List<DriverModel> data){
		mDatas = data;
	}
	
	public DriverModel getModelByIndex(int position){
		if(position >= 0 && position < mDatas.size()){
			return mDatas.get(position);
		}
		return null;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mDatas == null ? 0 : mDatas.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mDatas == null ? null : mDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		if(convertView != null){
			holder = (ViewHolder) convertView.getTag();
		}else{
			convertView = mFlater.inflate(R.layout.item_driver, null);
			holder = new ViewHolder();
			holder.portrait = (ImageView) convertView.findViewById(R.id.driverPort);
			holder.txtName = (TextView) convertView.findViewById(R.id.driverName);
			holder.txtLocation = (TextView) convertView.findViewById(R.id.driverLocation);
			holder.txtTotalCount = (TextView) convertView.findViewById(R.id.txtTotalCounts);
			holder.txtTotalYear = (TextView) convertView.findViewById(R.id.txtTotalYears);
			holder.txtHomeTown = (TextView) convertView.findViewById(R.id.txtHomeTown);
			holder.phoneCall = (Button) convertView.findViewById(R.id.callDriver);
			convertView.setTag(holder);
		}
		
		DriverModel model = mDatas.get(position);
		holder.portrait.setImageResource(model.getPort());
		holder.txtName.setText(model.getName());
		holder.txtLocation.setText("距离：" + model.getDistance() + "公里");
		holder.txtTotalCount.setText("代驾：" + model.getTotalCounts() + "次");
		holder.txtTotalYear.setText("驾龄：" + model.getDriveYear() + "年");
		holder.txtHomeTown.setText("籍贯：" + model.getHomeTown());
		
		holder.phoneCall.setTag(position);
		holder.phoneCall.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(mCallListener != null){
					int position = (Integer) v.getTag();
					mCallListener.onCallDriver(v, position);
				}
			}
		});
		
		return convertView;
	}

	class ViewHolder{
		ImageView portrait;
		TextView txtName;
		TextView txtLocation;
		TextView txtTotalCount;
		TextView txtTotalYear;
		TextView txtHomeTown;
		Button phoneCall;
	}
}
