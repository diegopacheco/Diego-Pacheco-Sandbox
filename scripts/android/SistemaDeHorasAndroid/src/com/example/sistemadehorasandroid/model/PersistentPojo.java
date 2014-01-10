package com.example.sistemadehorasandroid.model;

import java.util.Map;

public interface PersistentPojo {
	public String toTableName();
	public Map<String,String> toMap();
	public String[] toStringArrayFields();
	public String[] toStringArrayValues();
}
