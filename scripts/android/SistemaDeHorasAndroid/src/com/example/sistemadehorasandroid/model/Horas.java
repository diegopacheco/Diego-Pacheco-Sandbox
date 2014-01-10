package com.example.sistemadehorasandroid.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Horas implements Serializable, PersistentPojo{
	
	private static final long serialVersionUID = 1L;
	
	private String data;
	private String desc;
	
	public Horas() {}
	
	public Horas(String data, String desc) {
		super();
		this.data = data;
		this.desc = desc;
	}

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return "Data: " + data + " - Desc: " + desc;
	}
	
	@Override
	public Map<String,String> toMap(){
		Map<String,String> m = new HashMap<String,String>();
		m.put("DATA", data);
		m.put("DESCR", desc);
		return m;
	}
	
	@Override
	public String toTableName(){
		return "HORAS";
	}
	
	@Override
	public String[] toStringArrayValues(){
		String[] arr = new String[2];
		arr[0] = data;
		arr[1] = desc;
		return arr;
	}
	
	@Override
	public String[] toStringArrayFields() {
		String[] arr = new String[2];
		arr[0] = "DATA";
		arr[1] = "DESCR";
		return arr;
	}
	
}
