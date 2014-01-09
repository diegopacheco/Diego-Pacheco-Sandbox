package com.example.sistemadehorasandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class LoginActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		findViewById(R.id.button1).setOnClickListener(new OnClickListener(){
			@Override
            public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), BemVindoActivity.class);
				String nome = ((EditText)findViewById(R.id.txtNome)).getText().toString();
				i.putExtra("nome", nome );
				startActivity(i); 
			}	
		});
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

}
