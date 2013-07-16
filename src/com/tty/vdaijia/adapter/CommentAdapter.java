package com.tty.vdaijia.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.tty.vdaijia.R;
import com.tty.vdaijia.model.CommentInfo;
import com.tty.vdaijia.model.DriverModel;

public class CommentAdapter extends BaseAdapter {
	List<CommentInfo> mDatas;
	LayoutInflater mFlater;
	
	public CommentAdapter(Context context){
		mFlater = LayoutInflater.from(context);
		mDatas = new ArrayList<CommentInfo>();
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
	
	public void setData(List<CommentInfo> data){
		mDatas = data;
	}
	
	public CommentInfo getModelByIndex(int position){
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
			convertView = mFlater.inflate(R.layout.item_comment, null);
			holder = new ViewHolder();
			holder.txtSubInfo = (TextView) convertView.findViewById(R.id.txtSubInfo);
			holder.txtComment = (TextView) convertView.findViewById(R.id.txtContent);
			convertView.setTag(holder);
		}
		
		CommentInfo model = mDatas.get(position);
		String from = "来自：" + model.getPhoneNo() + "　" + model.getStamp();
		holder.txtSubInfo.setText(from);
		holder.txtComment.setText(model.getComment());
		return convertView;
	}

	class ViewHolder{
		TextView txtSubInfo;
		TextView txtComment;
	}
}
