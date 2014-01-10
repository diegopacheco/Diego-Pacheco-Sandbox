package com.example.sistemadehorasandroid.dao;

import android.app.Activity;
import android.database.Cursor;

import com.example.sistemadehorasandroid.model.Horas;
import com.example.sistemadehorasandroid.utils.SQLLiteUtils;

public class HorasDAO {
	
	private SQLLiteUtils dbhelper = null;
	
	public HorasDAO(Activity a) {
		dbhelper = new SQLLiteUtils(a.getApplicationContext());
	}
	
	public void persist(Horas horas){
		dbhelper.persist(horas);
	}
	
	public Horas retrieve(){
		Horas horas = new Horas();
		Cursor cursor = dbhelper.getCursor(horas);

		cursor.moveToFirst();
		while(!cursor.isAfterLast()){
			horas.setData(cursor.getString(0));
			horas.setDesc(cursor.getString(1));
			cursor.moveToNext();
		}
		cursor.close();
		return horas;
	}
	
}
