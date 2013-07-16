package com.tty.vdaijia;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class Util {
	public static final void Debug(String info){
		Log.d("test", info);
	}
	
	static Toast toast;
	public static void showToast(Context context, int resId){
		showToast(context, context.getResources().getString(resId));
	}
	public static void showToast(Context context, String text){
		if(toast == null){
			toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
		}else{
			toast.setText(text);
		}
		toast.show();
	}
	
}
