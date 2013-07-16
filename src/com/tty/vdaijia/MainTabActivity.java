package com.tty.vdaijia;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainTabActivity extends TabActivity implements OnCheckedChangeListener{

	private String[] tags = { "tag0", "tag1", "tag2", "tag3" };
//		private int[] tabIds = {
//				R.id.tab_home,
//				R.id.tab_dial,
//				R.id.tab_studio,
//				R.id.tab_contact,
//				R.id.tab_more
//		};
	public static final int TabIndex0 = 0;
	public static final int TabIndex1 = 1;
	public static final int TabIndex2 = 2;
	public static final int TabIndex3 = 3;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maintab);
		
		setupTabs();
		
		RadioGroup tabGroups = (RadioGroup) findViewById(R.id.tabGroups);
		tabGroups.setOnCheckedChangeListener(this);
	}

	TabHost mTabHost;
	void setupTabs(){
		mTabHost = getTabHost();
		Intent intent1 = new Intent(MainTabActivity.this, FindDriverActivity.class);
		TabSpec tabSpec1 = mTabHost.newTabSpec(tags[TabIndex0])
							.setIndicator(tags[TabIndex0])
							.setContent(intent1);
		mTabHost.addTab(tabSpec1);
		
		Intent intent2 = new Intent(MainTabActivity.this, UnderConstructActivity.class);
		intent2.putExtra(UnderConstructActivity.BundleKeyInfo, "邀请好友正在建设中...");
		TabSpec tabSpec2 = mTabHost.newTabSpec(tags[TabIndex1])
							.setIndicator(tags[TabIndex1])
							.setContent(intent2);
		mTabHost.addTab(tabSpec2);
		
		Intent intent3 = new Intent(MainTabActivity.this, UnderConstructActivity.class);
		intent3.putExtra(UnderConstructActivity.BundleKeyInfo, "我的订单正在建设中...");
		TabSpec tabSpec3 = mTabHost.newTabSpec(tags[TabIndex2])
							.setIndicator(tags[TabIndex2])
							.setContent(intent3);
		mTabHost.addTab(tabSpec3);
		
		Intent intent4 = new Intent(MainTabActivity.this, MoreActivity.class);
		TabSpec tabSpec4 = mTabHost.newTabSpec(tags[TabIndex3])
							.setIndicator(tags[TabIndex3])
							.setContent(intent4);
		mTabHost.addTab(tabSpec4);
	}
	
	private void setTabByIndex(int index){
		mTabHost.setCurrentTabByTag(tags[index]);
	}
	
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch(checkedId){
		case R.id.tab1:
			Util.Debug("tab1");
			setTabByIndex(TabIndex0);
			break;
		case R.id.tab2:
			Util.Debug("tab2");
			setTabByIndex(TabIndex1);
			break;
		case R.id.tab3:
			Util.Debug("tab3");
			setTabByIndex(TabIndex2);
			break;
		case R.id.tab4:
			Util.Debug("tab4");
			setTabByIndex(TabIndex3);
			break;
		default:
		}
	}

}
