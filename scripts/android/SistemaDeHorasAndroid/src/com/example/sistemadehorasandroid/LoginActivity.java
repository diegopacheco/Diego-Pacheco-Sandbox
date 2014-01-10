package com.example.sistemadehorasandroid;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.sistemadehorasandroid.mocks.DataMocks;
import com.example.sistemadehorasandroid.utils.InternalStorageUtils;
import com.example.sistemadehorasandroid.utils.PreferencesUtils;
import com.example.sistemadehorasandroid.utils.UIUtils;
import com.example.sistemadehorasandroid.utils.Utils;

public class LoginActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		findViewById(R.id.button1).setOnClickListener(new OnClickListener(){
			@Override
            public void onClick(View v) {
				
				Log.d(ACTIVITY_SERVICE, "Login Attempet Report\br " + InternalStorageUtils.readAll(LoginActivity.this,Utils.APP_SETTINGS_TRY_LOGIN_ERROR));
				
				Intent i = new Intent(getApplicationContext(), BemVindoActivity.class);
				String user = UIUtils.getTextById(LoginActivity.this, R.id.txtNome);
				String pass = UIUtils.getTextById(LoginActivity.this, R.id.txtIdade);
				
				if (!user.equals(DataMocks.MOCKED_USER) || !pass.equals(DataMocks.MOCKED_PASS)) {
					InternalStorageUtils.writeAppend(LoginActivity.this, Utils.APP_SETTINGS_TRY_LOGIN_ERROR, "Wrong login attempet User:" + user + " Pass: " + pass);
					UIUtils.alert(LoginActivity.this, "User/Pass Inválido!");
					return;
				}
				
				SharedPreferences prefs = PreferencesUtils.getPreferences(LoginActivity.this);
				PreferencesUtils.write( prefs , Utils.APP_SETTINGS_USER, UIUtils.getTextById(LoginActivity.this, R.id.txtNome));
				PreferencesUtils.write( prefs , Utils.APP_SETTINGS_PASS, UIUtils.getTextById(LoginActivity.this, R.id.txtIdade));
				
				i.putExtra("nome", user );
				startActivity(i);
				
		}});
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		UIUtils.persistentBehavior(LoginActivity.this,R.id.txtNome,Utils.APP_SETTINGS_USER);
		UIUtils.persistentBehavior(LoginActivity.this,R.id.txtIdade,Utils.APP_SETTINGS_PASS);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

}
