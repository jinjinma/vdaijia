package com.tty.vdaijia.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tty.vdaijia.R;

public class OptionItemView extends LinearLayout {
	TextView mOptionName;
	
	String mStrOptionName;
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public OptionItemView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		setupView(context);
		initAttrs(context,attrs);
		initValue();
	}

	public OptionItemView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setupView(context);
		initAttrs(context, attrs);
		initValue();
	}

	public OptionItemView(Context context) {
		super(context);
		setupView(context);
	}
	
	void initAttrs(Context context, AttributeSet attrs){
		if(attrs != null){
			TypedArray typeArray = context.obtainStyledAttributes(attrs, R.styleable.optionView);
			mStrOptionName = typeArray.getString(R.styleable.optionView_optionName);
			typeArray.recycle();
		}
	}
	
	void initValue(){
		if(mStrOptionName != null){
			mOptionName.setText(mStrOptionName);
		}
	}
	
	void setupView(Context context){
		setOrientation(HORIZONTAL);
		setBackgroundResource(R.drawable.about_item_selector);
		setClickable(true);
		
		LayoutInflater flater = LayoutInflater.from(context);
		flater.inflate(R.layout.option_item, this);
		
		mOptionName = (TextView) findViewById(R.id.optionName);
	}
	
	public void setOptionName(String name){
		mOptionName.setText(name);
	}

}
