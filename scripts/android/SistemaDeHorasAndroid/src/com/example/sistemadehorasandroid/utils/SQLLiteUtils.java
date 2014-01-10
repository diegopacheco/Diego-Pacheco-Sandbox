package com.example.sistemadehorasandroid.utils;

import java.util.Map;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.sistemadehorasandroid.model.PersistentPojo;

public class SQLLiteUtils extends SQLiteOpenHelper {
	
	private static final String DATABASE_NAME = "horas.db";
	private static final int DATABASE_VERSION = 4;
	
	private static final String SQL_HORAS_TABLE = "CREATE TABLE IF NOT EXISTS HORAS (DATA varchar,DESCR varchar)";
	private static final String SQL_DROP_HORAS_TABLE = "DROP TABLE IF EXISTS HORAS";
	
	private SQLiteDatabase database = null;
	
	public SQLLiteUtils(Context context){
		super(context, DATABASE_NAME,null, DATABASE_VERSION);
		database = this.getWritableDatabase();
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_HORAS_TABLE);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(SQL_DROP_HORAS_TABLE);
		db.execSQL(SQL_HORAS_TABLE);
	}
	
	public void persist(PersistentPojo pojo){
		ContentValues cv = new ContentValues();
		String table = pojo.toTableName();
		Map<String,String> values = pojo.toMap();
		
		for(String key : values.keySet())
			cv.put(key,values.get(key));
		
		database.insert(table,null,cv);
		database.close();
		database = this.getWritableDatabase();
	}
	
	public Cursor getCursor(PersistentPojo pojo){
		return database.query(pojo.toTableName(), pojo.toStringArrayFields() , null, null,null, null,null,null);
	}		
	
}
