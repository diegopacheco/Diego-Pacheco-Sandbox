package com.example.sistemadehorasandroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Integer countPause = 0;
	private Integer countStart = 0;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(ACTIVITY_SERVICE, "Create");
        Toast.makeText(getApplicationContext(), "onCreate", Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        Toast.makeText(getApplicationContext(), "onCreateOptionsMenu", Toast.LENGTH_SHORT).show();
        return true;
    }
    
    @Override
    protected void onStart() {
    	// TODO Auto-generated method stub
    	Log.d(ACTIVITY_SERVICE, "Start");
    	Toast.makeText(getApplicationContext(), "onStart", Toast.LENGTH_SHORT).show();
    	super.onStart();
    }
    
    @Override
    protected void onResume() {
    	// TODO Auto-generated method stub
    	Toast.makeText(getApplicationContext(), "onResume", Toast.LENGTH_SHORT).show();
    	super.onResume();
    }
  
    @Override
    protected void onPause() {
    	countPause++;
    	Toast.makeText(getApplicationContext(), "onPause " + countPause, Toast.LENGTH_SHORT).show();
    	// TODO Auto-generated method stub
    	super.onPause();
    }
    
    @Override
    protected void onStop() {
    	// TODO Auto-generated method stub
    	super.onStop();
    	Toast.makeText(getApplicationContext(), "onStop", Toast.LENGTH_SHORT).show();
    }
    
    @Override
    protected void onDestroy() {
    	// TODO Auto-generated method stub
    	Toast.makeText(getApplicationContext(), "onDestroy", Toast.LENGTH_SHORT).show();
    	super.onDestroy();
    }
    
    @Override
    protected void onRestart() {
    	countStart++;
    	// TODO Auto-generated method stub
    	Toast.makeText(getApplicationContext(), "onRestart " + countStart, Toast.LENGTH_SHORT).show();
    	super.onRestart();
    }
    
}
