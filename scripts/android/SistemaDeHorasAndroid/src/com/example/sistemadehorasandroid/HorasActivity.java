package com.example.sistemadehorasandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class HorasActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_horas);
		findViewById(R.id.buttonSalvarHorASX).setOnClickListener(new OnClickListener(){
			@Override
            public void onClick(View v) {
				String data = ((EditText)findViewById(R.id.txtData)).getText().toString();
				String desc = ((EditText)findViewById(R.id.txtDescricao)).getText().toString();
				
				if(data == null ||data.equals(""))
					 Toast.makeText(getApplicationContext(), "Preencha Data", Toast.LENGTH_SHORT).show();
				
				if(desc == null ||desc.equals(""))
					 Toast.makeText(getApplicationContext(), "Preencha Descricao", Toast.LENGTH_SHORT).show();
				
				android.os.Process.killProcess(android.os.Process.myPid());

			}	
		});
	}

}
