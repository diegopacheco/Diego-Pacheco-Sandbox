package com.example.sistemadehorasandroid;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

import com.example.sistemadehorasandroid.comp.HorasAdapter;
import com.example.sistemadehorasandroid.dao.HorasDAO;
import com.example.sistemadehorasandroid.model.Horas;
import com.example.sistemadehorasandroid.utils.UIUtils;

public class HorasActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_horas);
		
		findViewById(R.id.buttonSalvarHorASX).setOnClickListener(new OnClickListener(){
			
			@Override
            public void onClick(View v) {
				
				String data = UIUtils.getTextById(HorasActivity.this, R.id.txtData);
				String desc = UIUtils.getTextById(HorasActivity.this, R.id.txtDescricao);
				
				if(data == null ||data.equals("")) UIUtils.alert(HorasActivity.this, "Preencha Data");
				if(desc == null ||desc.equals("")) UIUtils.alert(HorasActivity.this, "Preencha Descricao");
				
				Horas horas = new Horas(data,desc);
				HorasDAO dao = new HorasDAO(HorasActivity.this);
				dao.persist(horas);
				
				UIUtils.alert(HorasActivity.this, "From DB: " + dao.retrieve().toString() );
				//KernelUtils.kill();
			}
			
		});
		
		List<Horas> itens = new ArrayList<Horas>();
		itens.add(new Horas("100","test"));
		itens.add(new Horas("101","test2"));
		itens.add(new Horas("102","test3"));
		
	    ((ListView) findViewById(R.id.lv1)).setAdapter(new HorasAdapter(getBaseContext(), R.layout.horas_listview, itens));

	}

}
