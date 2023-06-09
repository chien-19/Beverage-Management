package com.example.quan_ly_don_hang;

import com.example.quan_ly_don_hang.database.DbHelper;
import com.example.quan_ly_don_hang.model.DanhMuc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class ThemDanhMucActivity extends Activity {
	DbHelper dbManager;
	EditText txtThemDM;
	Button btnLuu;
ImageButton ibtnback;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_them_danh_muc);
		dbManager = new DbHelper(this);
		txtThemDM = (EditText) findViewById(R.id.txtTenSP_ThemSP);
		btnLuu = (Button) findViewById(R.id.btnSaveDM);
		ibtnback = (ImageButton)findViewById(R.id.ibtnbackthemdm);
		ibtnback.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnLuu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				DanhMuc dm = createDanhMuc();
				if (dm != null ){
					dbManager.addDanhmuc(dm);
				}
				Toast.makeText(ThemDanhMucActivity.this, "�? th�m danh muc", Toast.LENGTH_SHORT).show();
				Intent i = new Intent(getApplicationContext(), DanhMucActivity.class);
				startActivity(i);
			}
			
		});
	}

	private DanhMuc createDanhMuc() {
		String tenDM = txtThemDM.getText().toString().trim();
		DanhMuc dm = new DanhMuc(tenDM);
		return dm;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.them_danh_muc, menu);
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
