package com.example.sistemadehorasandroid.comp;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.sistemadehorasandroid.R;
import com.example.sistemadehorasandroid.model.Horas;

public class HorasAdapter extends ArrayAdapter<Horas> {

	private List<Horas> itens;

	public HorasAdapter(Context context, int textViewResourceId, List<Horas> itens) {
		super(context, textViewResourceId, itens);
		this.itens = itens;
	}

	@Override
	public int getCount() {
		return itens.size();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View gridView = convertView;
		if (convertView == null) { // if it's not recycled, initialize some
			// attributes
			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			gridView = inflater.inflate(R.layout.horas_listview, parent, false);
		}
		Horas horas = itens.get(position);
		((TextView) gridView.findViewById(R.id.txtDescLV)).setText(horas.getDesc());
		((TextView) gridView.findViewById(R.id.txtDataLV)).setText(horas.getData());
		return gridView;
	}

}

