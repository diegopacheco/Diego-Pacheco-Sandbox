package com.example.sistemadehorasandroid.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Context;

public class InternalStorageUtils {
	
	public static void writeAppend(Activity a,String file,String content){
		try {
			FileOutputStream fos = a.openFileOutput(file, Context.MODE_APPEND);
			fos.write(content.getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}		
	}
	
	public static String readAll(Activity a,String file){
		try {
			FileInputStream fis = a.openFileInput(file);
			int c;
			StringBuffer buff = new StringBuffer();
			while ((c = fis.read()) != -1)
				buff.append( (char) c );
				
			return buff.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}		
	}
	
}
