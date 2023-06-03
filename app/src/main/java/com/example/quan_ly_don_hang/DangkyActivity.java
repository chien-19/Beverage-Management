package com.example.quan_ly_don_hang;

import com.example.quan_ly_don_hang.database.DbHelper;
import com.example.quan_ly_don_hang.model.Users;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DangkyActivity extends Activity {
	DbHelper dbManager;
	EditText txtUsername;
	EditText txtPassword;
	Button btnSave, btnClear;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dangky);
		dbManager = new DbHelper(this);
		txtUsername = (EditText) findViewById(R.id.txtUsername_User);
		txtPassword = (EditText) findViewById(R.id.txtPassword_User);
		btnClear = (Button)findViewById(R.id.btnGiamgia);
		btnSave = (Button) findViewById(R.id.btnLogin);

		btnSave.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Users users = createUser();
				if (users != null) {
					dbManager.adduser(users);
					Toast.makeText(DangkyActivity.this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
					Intent in = new Intent(getApplicationContext(), Frm_Login.class);
					startActivity(in);
				}
			}
			
		});
		btnClear.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				txtUsername.setText(" ");
				txtPassword.setText(" ");
			}
		});

	}

	private Users createUser() {
		String name = txtUsername.getText().toString().trim();
		String password = txtPassword.getText().toString().trim();

		Users users = new Users(name, password);
		return users;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dangky, menu);
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
