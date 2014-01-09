package com.example.sistemadehorasandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView; 

public class BemVindoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bemvindo);
		
		findViewById(R.id.buttonAtividade).setOnClickListener(new OnClickListener(){
			@Override
            public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), HorasActivity.class);
				startActivity(i); 
			}	
		});
		
		findViewById(R.id.buttonFechar).setOnClickListener(new OnClickListener(){
			@Override
            public void onClick(View v) {
				android.os.Process.killProcess(android.os.Process.myPid());
			}	
		});
		
		
		
		((TextView)findViewById(R.id.lblTextoBemVindo)).setText( getIntent().getStringExtra("nome") + "  " );
	}

}
