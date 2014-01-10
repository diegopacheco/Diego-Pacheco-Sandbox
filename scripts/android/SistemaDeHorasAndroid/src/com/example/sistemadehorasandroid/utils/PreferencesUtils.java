package com.example.sistemadehorasandroid.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesUtils {
	
	public static final SharedPreferences getPreferences(Activity a){
		return a.getSharedPreferences(Utils.APP_SETTINGS,Context.MODE_PRIVATE);
	}
	
	public static final void write(SharedPreferences preferences,String key, String value){
		preferences.edit().putString(key,value).commit();
	}
	
}
