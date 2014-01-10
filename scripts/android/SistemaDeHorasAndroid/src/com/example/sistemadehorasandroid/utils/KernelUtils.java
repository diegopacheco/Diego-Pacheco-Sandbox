package com.example.sistemadehorasandroid.utils;

public class KernelUtils {
	
	public static void kill(){
		android.os.Process.killProcess(android.os.Process.myPid());
	}
	
}
