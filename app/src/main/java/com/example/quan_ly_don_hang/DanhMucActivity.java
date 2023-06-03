package com.example.quan_ly_don_hang;

import java.util.ArrayList;

import com.example.quan_ly_don_hang.adapter.DanhMucAdapter;
import com.example.quan_ly_don_hang.database.DbHelper;
import com.example.quan_ly_don_hang.model.DanhMuc;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

public class DanhMucActivity extends Activity {
	
ImageButton btnThemDM, btnBack;
//SimpleCursorAdapter adapter;
Cursor cursor;
ArrayList<DanhMuc> arrDM = new ArrayList<DanhMuc>();
DanhMucAdapter adapter;
ListView lv;
DbHelper dbManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_danh_muc);
		btnThemDM = (ImageButton)findViewById(R.id.ibtnAddDM);
		btnBack = (ImageButton)findViewById(R.id.ibtnBacksp);
		lv = (ListView)findViewById(R.id.lv_SP);
		dbManager = new DbHelper(this);
		display();
		btnBack.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			Intent i = new Intent(getApplicationContext(), SanPhamActivity.class);
			startActivity(i);
			}
		});
		btnThemDM.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			Intent i = new Intent(getApplicationContext(),ThemDanhMucActivity.class);
			startActivity(i);
			}
		});
				

	
	}
	public void display(){
		cursor = dbManager.SELECT_ALL_DANHMUC();
		/*
		String[] from = new String[]{dbManager.ID,dbManager.TEN_DANHMUC};
		int[] to  = new int[]{R.id.tv_Id,R.id.tv_tendm};
		adapter = new SimpleCursorAdapter(DanhMucActivity.this, R.layout.item_list_danhmuc, cursor, from, to, 0);
		dbManager.CloseDB();
		*/
		if(adapter==null){
		while (cursor.moveToNext()){
			
			arrDM.add(new DanhMuc(cursor.getInt(0), cursor.getString(1)));
		}
		adapter = new DanhMucAdapter(this, R.layout.item_list_danhmuc, arrDM);
		lv.setAdapter(adapter);
		}else{
		adapter.notifyDataSetChanged();
		}
		
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.danh_muc, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
